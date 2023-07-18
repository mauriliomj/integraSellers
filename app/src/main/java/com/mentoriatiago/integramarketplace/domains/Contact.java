package com.mentoriatiago.integramarketplace.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
  private ContactTypeEnum type;
  private String value;

}
