package com.pl.Arkadiusz.FlatApp.model.entities;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "adverts")
public class Advert extends EntityBase {
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

