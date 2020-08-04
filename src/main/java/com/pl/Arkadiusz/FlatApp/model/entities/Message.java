package com.pl.Arkadiusz.FlatApp.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "messages")
public class Message extends EntityBase {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String receiver;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User userId;
}
