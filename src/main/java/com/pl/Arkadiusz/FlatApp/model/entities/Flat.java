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
    private String flatNumber;
    @Column(nullable = false)
    private Boolean active;

//    @OneToOne
//    @JoinColumn(name="user_id")
//    private User user;

}
