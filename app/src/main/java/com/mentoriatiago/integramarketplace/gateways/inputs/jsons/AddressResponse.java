package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import com.mentoriatiago.integramarketplace.domains.Address;

public class AddressResponse {

    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public AddressResponse(Address address){
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
    }

}