package com.estesting.gateway.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Error {
  @Setter private String error;
  @Setter private List<String> message;
}
