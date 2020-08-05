package com.pl.Arkadiusz.FlatApp.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Status status;
    private LocalDate startDate;
    private LocalDate deadline;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "owner_id", insertable = false, updatable = false)
    private Long ownerId;

    public static enum Status{
        ACTIVE,
        INACTIVE;
    }

}
