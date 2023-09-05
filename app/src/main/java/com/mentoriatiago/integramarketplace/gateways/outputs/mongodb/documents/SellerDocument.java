package com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.documents;

import com.mentoriatiago.integramarketplace.domains.Seller;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.joda.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("sellers")
public class SellerDocument {

    @Id
    private String sellerId;
    private String name;
    @Indexed
    private String registrationCode;
    private ContactDocument contact;
    private AddressDocument address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public SellerDocument(Seller seller) {

        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = new ContactDocument(seller.getContact());
        this.address = new AddressDocument(seller.getAddress());
        this.createdDate = seller.getCreatedDate();
        this.lastModifiedDate = seller.getLastModifiedDate();

    }

    public Seller toDomain() {

        Seller seller = new Seller();
        seller.setSellerId(this.sellerId);
        seller.setName(this.name);
        seller.setRegistrationCode(this.registrationCode);
        seller.setContact(this.contact.toDomain());
        seller.setAddress(this.address.toDomain());
        seller.setCreatedDate(this.createdDate);
        seller.setLastModifiedDate(this.lastModifiedDate);

        return seller;

    }
}
