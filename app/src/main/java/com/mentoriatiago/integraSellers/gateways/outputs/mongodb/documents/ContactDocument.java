package com.mentoriatiago.integraSellers.gateways.outputs.mongodb.documents;

import com.mentoriatiago.integraSellers.domains.Contact;
import com.mentoriatiago.integraSellers.domains.ContactTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDocument {

  private ContactTypeEnum type;
  private String value;

  public ContactDocument(Contact contact) {

    this.type = contact.getType();
    this.value = contact.getValue();

  }

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
