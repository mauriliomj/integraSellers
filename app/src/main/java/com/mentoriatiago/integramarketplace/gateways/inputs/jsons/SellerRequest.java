package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import com.mentoriatiago.integramarketplace.domains.Address;
import com.mentoriatiago.integramarketplace.domains.Contact;
import com.mentoriatiago.integramarketplace.domains.Seller;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
public class SellerRequest {

  @NotNull(message = "{not.null}")
  private String name;
  @NotNull(message = "{not.null}")
  private String registrationCode;
  private ContactRequest contact;
  private Address address;

  public Seller toDomain() {
    Seller seller = new Seller();
    seller.setName(name);
    seller.setRegistrationCode(registrationCode);
    seller.setContact(contact.toDomain());
    seller.setAddress(address);
    return seller;
  }
}
