package com.pl.Arkadiusz.FlatApp.model.repositories;

import com.pl.Arkadiusz.FlatApp.model.entities.Bill;
import com.pl.Arkadiusz.FlatApp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findAllByActiveAndUser(Boolean active, User user);
}
