package com.estesting.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Error {
    @Setter
    private String error;
    @Setter
    private List<String> message;
}
