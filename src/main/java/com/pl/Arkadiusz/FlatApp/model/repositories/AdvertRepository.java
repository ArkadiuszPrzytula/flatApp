package com.pl.Arkadiusz.FlatApp.model.repositories;

import com.pl.Arkadiusz.FlatApp.model.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
    List<Advert> findAll();
    Optional<Advert> findByActiveAndId(Boolean active, Long id);

    Optional<Advert> findByIdAndUserUsername(Long advertId, String userName);

    Advert findTopByOrderByCreatedAtDesc();
}
