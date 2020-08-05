package com.pl.Arkadiusz.FlatApp.service.implementation;

import com.pl.Arkadiusz.FlatApp.dto.LoggedUserDto;
import com.pl.Arkadiusz.FlatApp.dto.RegisterUSerDto;
import com.pl.Arkadiusz.FlatApp.model.entities.Flat;
import com.pl.Arkadiusz.FlatApp.model.entities.User;
import com.pl.Arkadiusz.FlatApp.model.repositories.FlatRepository;
import com.pl.Arkadiusz.FlatApp.model.repositories.UserRepository;
import com.pl.Arkadiusz.FlatApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Service
@Slf4j
public class UserServiceDefault implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final FlatRepository flatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceDefault(PasswordEncoder passwordEncoder, UserRepository userRepository, FlatRepository flatRepository, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.flatRepository = flatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveUser(RegisterUSerDto registerUSerDto) throws Exception {
        User user = modelMapper.map(registerUSerDto, User.class);
        user.setPassword(passwordEncoder.encode(registerUSerDto.getPassword()));
        log.debug("{}: try save user with username {}", this.getClass().getName(), registerUSerDto.getUsername());
        User savedUser = null;
        try {
            savedUser = userRepository.save(user);
        } catch (EntityExistsException eex) {
            log.debug("{}:  user with username {} exist in database ", this.getClass().getName(), registerUSerDto.getUsername());
            throw new Exception("This user exist in database");
        } catch (Exception exception) {
            log.debug("{}: failure save user with username {} ", this.getClass().getName(), registerUSerDto.getUsername());
            throw new Exception("Save not complied");
        }

        log.debug("{}: saved user ->{}", this.getClass().getName(), savedUser);
    }

    @Override
    public LoggedUserDto getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(user, LoggedUserDto.class);
    }

    @Override
    public User getRawUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);

    }
}
