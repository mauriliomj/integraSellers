package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import com.mentoriatiago.integramarketplace.domains.Contact;
import com.mentoriatiago.integramarketplace.domains.ContactTypeEnum;
import lombok.Data;

@Data
public class ContactRequest {

  private ContactTypeEnum type;
  private String value;

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
