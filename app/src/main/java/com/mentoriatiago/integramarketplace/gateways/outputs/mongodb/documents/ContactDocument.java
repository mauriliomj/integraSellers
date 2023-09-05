package com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.documents;

import com.mentoriatiago.integramarketplace.domains.Contact;
import com.mentoriatiago.integramarketplace.domains.ContactTypeEnum;
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
