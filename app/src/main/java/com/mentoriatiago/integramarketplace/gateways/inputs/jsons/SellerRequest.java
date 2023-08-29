package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import static java.util.Optional.ofNullable;

import com.mentoriatiago.integramarketplace.domains.Seller;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SellerRequest {

  @NotNull(message = "{not.null}")
  private String name;
  @NotNull(message = "{not.null}")
  private String registrationCode;
  private ContactRequest contact;
  private AddressRequest address;

  public Seller toDomain() {
    Seller seller = new Seller();
    seller.setName(name);
    seller.setRegistrationCode(registrationCode);
    seller.setContact(ofNullable(contact).map(ContactRequest::toDomain).orElse(null));
    seller.setAddress(ofNullable(address).map(AddressRequest::toDomain).orElse(null));
    return new Seller();
  }
}
