package com.caalzate.spring.security.login.models;

import com.caalzate.spring.security.login.security.services.UserDetailsImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje extends UserDetailContent{

    @JsonProperty("id")
    private String id;

    @JsonProperty("contenido")
    private UserDetailContent contenido;
    
}
