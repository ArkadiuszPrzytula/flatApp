package com.pl.Arkadiusz.FlatApp.dto;

import lombok.Data;

@Data
public class LoggedUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
