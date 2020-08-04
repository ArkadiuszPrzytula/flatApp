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
    @Column(nullable = false)
    private Boolean active;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Flat(int flatNumber, boolean active) {
        this.flatNumber= flatNumber;
        this.active = active;
    }
}
