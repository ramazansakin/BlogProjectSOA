package com.sakinramzan.blogapp.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PojoUserRegistration {
    private String username;
    private String password;
    private String passwordConfirmation;
}
