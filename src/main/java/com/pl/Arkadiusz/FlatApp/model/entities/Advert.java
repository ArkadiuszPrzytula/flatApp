package com.pl.Arkadiusz.FlatApp.model.entities;


import lombok.*;

import javax.persistence.*;


@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString(exclude = {"user"}) @EqualsAndHashCode (of = "id")
    @Builder
    @Entity
    @Table(name = "adverts")
    public class Advert extends EntityBase{

        @Column(nullable = false)
        private String title;
        @Column(nullable = false)
        private String description;
        @Column(nullable = false)
        private Boolean active;

        @ManyToOne
        @JoinColumn(name="user_id", nullable = false)
        private User user;

    }

