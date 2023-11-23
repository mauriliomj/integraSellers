package com.mentoriatiago.integraSellers.gateways.inputs.jsons;

import com.mentoriatiago.integraSellers.domains.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

  private String street;
  private String number;
  private String zipcode;
  private String city;
  private String state;
  private String country;

  public Address toDomain() {

    Address address = new Address();
    address.setStreet(street);
    address.setNumber(number);
    address.setZipcode(zipcode);
    address.setCity(city);
    address.setState(state);
    address.setCountry(country);

    return address;

  }
}
