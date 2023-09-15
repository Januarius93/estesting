package com.estesting.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Credentials {
    @Setter
    String username;
    @Setter
    String password;
}
