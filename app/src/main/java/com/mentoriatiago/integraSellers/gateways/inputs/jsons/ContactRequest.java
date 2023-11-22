package com.mentoriatiago.integraSellers.gateways.inputs.jsons;

import com.mentoriatiago.integraSellers.domains.Contact;
import com.mentoriatiago.integraSellers.domains.ContactTypeEnum;
import lombok.Data;

@Data
public class ContactRequest {

  private ContactTypeEnum type;
  private String value;

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
