package com.assesment.securityservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialDto {
    private  Long id;
    private String name;
    private String email;
    private String userRole;
    private String password;
}
