package com.estesting.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    @Setter
    String username;
    @Setter
    String password;
}
