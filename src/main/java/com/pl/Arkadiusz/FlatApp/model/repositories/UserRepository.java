package com.pl.Arkadiusz.FlatApp.model.repositories;

import com.pl.Arkadiusz.FlatApp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);
    Optional<User> findById(Long Id);

    List<User> findAllByUsername(String userName);
}
