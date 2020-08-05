package com.pl.Arkadiusz.FlatApp.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "flats")
public class Flat extends EntityBase {

    @Column(nullable = false)
    private int flatNumber;


    @OneToOne(mappedBy = "flat")
    private User user;

    public Flat(int flatNumber, boolean active) {
        this.flatNumber= flatNumber;
    }
}
