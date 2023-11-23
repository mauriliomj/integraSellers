package com.mentoriatiago.integraSellers.gateways.inputs.jsons;

import lombok.Data;
import java.util.List;

@Data
public class ErrorResponse {

  private List<String> errors;

  public ErrorResponse(final List<String> errors) {
    this.errors = errors;
  }

}
