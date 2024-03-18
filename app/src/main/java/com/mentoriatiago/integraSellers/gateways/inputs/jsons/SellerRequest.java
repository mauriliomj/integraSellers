package com.mentoriatiago.integraSellers.gateways.inputs.jsons;

import com.mentoriatiago.integraSellers.domains.Seller;
import javax.validation.constraints.NotNull;
import lombok.Data;
import static java.util.Optional.ofNullable;

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

    return seller;

  }
}
