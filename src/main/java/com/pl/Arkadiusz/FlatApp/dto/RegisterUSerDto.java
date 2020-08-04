package com.pl.Arkadiusz.FlatApp.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterUSerDto {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @Size(min = 2, max = 30)
    private String password;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @Email(message = "email is not available")
    private String email;

    private int flatNumber;
}
