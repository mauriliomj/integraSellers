package com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources;

import com.mentoriatiago.integraSellers.domains.Contact;
import com.mentoriatiago.integraSellers.domains.ContactTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResource {

  private ContactTypeEnum type;
  private String value;

  public ContactResource(Contact contact) {

    this.type = contact.getType();
    this.value = contact.getValue();

  }

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
