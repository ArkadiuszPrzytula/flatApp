package com.pl.Arkadiusz.FlatApp.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user"})
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "bills")
public class Bill extends EntityBase {


    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private String invoiceNumber;
    @Column(nullable = false)
    private Date invoiceDate;
    @Column(nullable = false)
    private Double grossAmount;
    @Column(nullable = false)
    private Boolean active = true;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    enum Category {
        EARMARKED_FUND,
        REPAIR_FUND,
        CO_AND_CW_FIXED_FEE,
        MANAGEMENT_COSTS,
        CENTRAL_HEATING,
        WASTE_DISPOSAL,
        WATER_HEATING,
        COLD_WATER_AND_SEWAGE,
        ENERGY;
    }
}
