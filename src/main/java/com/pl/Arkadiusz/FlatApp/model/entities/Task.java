package com.pl.Arkadiusz.FlatApp.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (of = "id")
@Builder
@Entity
@Table(name = "tasks")
public class Task extends EntityBase{

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean active;
    private String status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "owner_id", insertable = false, updatable = false)
    private Long ownerId;

}
