package com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources;

import com.mentoriatiago.integraSellers.domains.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SellerResource {

    @Id
    private String sellerId;
    private String name;
    @Indexed
    private String registrationCode;
    private ContactResource contact;
    private AddressResource address;
    private String createdDate;
    private String lastModifiedDate;

    public SellerResource(Seller seller) {

        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = new ContactResource(seller.getContact());
        this.address = new AddressResource(seller.getAddress());
        this.createdDate = seller.getCreatedDate().toString();
        this.lastModifiedDate = seller.getLastModifiedDate().toString();

    }

    public Seller toDomain() {

        Seller seller = new Seller();
        seller.setSellerId(this.sellerId);
        seller.setName(this.name);
        seller.setRegistrationCode(this.registrationCode);
        seller.setContact(this.contact.toDomain());
        seller.setAddress(this.address.toDomain());
        seller.setCreatedDate(seller.getCreatedDate());
        seller.setLastModifiedDate(seller.getLastModifiedDate());

        return seller;

    }
}
