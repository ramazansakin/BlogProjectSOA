package com.sakinramzan.blogapp.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PojoUserRegistration {
    private String username;
    private String password;
    private String passwordConfirmation;

}
