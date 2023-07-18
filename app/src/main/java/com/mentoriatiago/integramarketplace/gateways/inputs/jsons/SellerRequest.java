package com.mentoriatiago.integramarketplace.gateways.inputs.jsons;

import com.mentoriatiago.integramarketplace.domains.Address;
import com.mentoriatiago.integramarketplace.domains.Contact;
import com.mentoriatiago.integramarketplace.domains.Seller;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SellerRequest {

    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;

    public Seller toDomain() {
        Seller seller = new Seller();
        seller.setName(name);
        seller.setRegistrationCode(registrationCode);
        seller.setContact(contact);
        seller.setAddress(address);
        return seller;
    }
}
