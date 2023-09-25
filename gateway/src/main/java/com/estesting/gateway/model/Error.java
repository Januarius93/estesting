package com.estesting.gateway.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class Error {
  @Setter private String code;
  @Setter private List<String> message;
}
