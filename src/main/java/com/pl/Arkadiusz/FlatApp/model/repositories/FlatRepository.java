package com.pl.Arkadiusz.FlatApp.model.repositories;

import com.pl.Arkadiusz.FlatApp.model.entities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {
    boolean existsFlatByFlatNumber(int number);
}
