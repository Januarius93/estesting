package com.estesting.gateway.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class Message {

  protected static ObjectMapper objectMapper = new ObjectMapper();
  private Map<String, Object> responseMessage;
  @Setter
  private String code;
  @Setter
  private List<String> message;

  public <E> Message(HttpStatus httpStatus, List<String> messages) {
    this.code = httpStatus.getReasonPhrase();
    this.message = messages;
    responseMessage = Map.of("code", httpStatus, "message", messages);
  }

  public <E> Message(HttpStatus httpStatus, String message) {
    this.code = httpStatus.getReasonPhrase();
    this.message = List.of(message);
    responseMessage = Map.of("code", httpStatus, "message", message);
  }
}
