package com.estesting.gateway.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Error {
  private String code;
  private List<String> message;
}
