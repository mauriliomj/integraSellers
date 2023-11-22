package com.mentoriatiago.integraSellers.gateways.inputs.jsons;

import com.mentoriatiago.integraSellers.domains.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SellerResponse {

    private String sellerId;
    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public SellerResponse(Seller seller) {

        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = seller.getContact();
        this.address = seller.getAddress();
        this.createdDate = seller.getCreatedDate();
        this.lastModifiedDate = seller.getLastModifiedDate();

    }
}
