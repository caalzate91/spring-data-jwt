package com.caalzate.spring.security.login.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailContent{   

    private String username;

    private String email;
    
    
}
