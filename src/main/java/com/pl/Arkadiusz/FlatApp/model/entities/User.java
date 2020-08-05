package com.pl.Arkadiusz.FlatApp.model.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString( callSuper = true, exclude = {"bills", "flat",})
@Builder
@Entity
@Table(name = "users")
public class User extends EntityBase {


    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int flatNumber;
    //    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Bill> bills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_flat",
            joinColumns =
                    {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "flat_id", referencedColumnName = "id")})
    private Flat flat;

    @OneToMany(mappedBy = "user")
    private List<Advert> advert;

    @PrePersist
    protected void prePersist(){
        super.prePersist();
        this.role = "USER";
    }

//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//        name="users_tasks",
//            joinColumns = {@JoinColumn(name="user_id")},
//            inverseJoinColumns = {@JoinColumn(name="task_id")}
//    )
//    Set<Task> tasks = new HashSet<>();


}
