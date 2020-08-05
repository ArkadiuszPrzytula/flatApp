package com.pl.Arkadiusz.FlatApp.service.implementation;

import com.pl.Arkadiusz.FlatApp.dto.AdvertDto;
import com.pl.Arkadiusz.FlatApp.model.entities.Advert;
import com.pl.Arkadiusz.FlatApp.model.repositories.AdvertRepository;
import com.pl.Arkadiusz.FlatApp.service.AdvertService;
import com.pl.Arkadiusz.FlatApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.pl.Arkadiusz.FlatApp.utilis.SecurityUtils.getUsername;

@Service
@Slf4j
public class AdvertServiceDefault implements AdvertService {
    private final AdvertRepository advertRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public AdvertServiceDefault(AdvertRepository advertRepository, ModelMapper modelMapper, UserService userService) {
        this.advertRepository = advertRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public List<AdvertDto> getAllAdvert() {
        return advertRepository.findAll().stream().map(this::mapAdvertOnAdvertDto).collect(Collectors.toList());
    }

    @Override
    public void save(AdvertDto advertDto) throws Exception {
        Advert advert = modelMapper.map(advertDto, Advert.class);
        if (advert.getUser()==null)
        advert.setUser(userService.getRawUser(getUsername()));

        Advert savedAdvert;
        try {
            savedAdvert = advertRepository.save(advert);
        } catch (EntityExistsException eex) {
            log.debug("{}: advert with title {} exist in database ", this.getClass().getName(), advertDto.getTitle());
            throw new Exception("This advert exist in database");
        } catch (Exception exception) {
            log.debug("{}: failure save user with username {} ", this.getClass().getName(), advertDto.getTitle());
            throw new Exception("Save not complied");
        }
        log.debug("{}: saved advert-> {}", this.getClass().getName(), savedAdvert);
    }

    @Override
    public AdvertDto getAdvert(Long id) {
        return modelMapper
                .map(advertRepository
                        .findByActiveAndId(true, id)
                        .orElseThrow(EntityNotFoundException::new),AdvertDto.class);
    }


    private AdvertDto mapAdvertOnAdvertDto(Advert advert) {
        return modelMapper.map(advert, AdvertDto.class);
    }
}
