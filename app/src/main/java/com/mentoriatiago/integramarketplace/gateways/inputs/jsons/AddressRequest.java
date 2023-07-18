package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import com.mentoriatiago.integramarketplace.domains.Address;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddressRequest {
    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public Address toDomain(){
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
