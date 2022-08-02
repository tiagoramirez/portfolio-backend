package com.tiagoramirez_portfolio.portfolio.security.dto;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUser {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String full_name;

    @PastOrPresent
    @NotBlank
    private LocalDate birthday;

    @Email
    private String mail;

    private Set<String> roles = new HashSet<>();
}
