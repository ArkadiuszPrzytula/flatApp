package com.pl.Arkadiusz.FlatApp.dto;

import com.pl.Arkadiusz.FlatApp.model.entities.EntityBase;
import com.pl.Arkadiusz.FlatApp.model.entities.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AdvertDto {
    Long id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    String title;
    @NotNull
    @NotBlank
    String description;

    private Boolean active;

    private LoggedUserDto user;

}
