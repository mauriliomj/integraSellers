package com.mentoriatiago.integraSellers.domains;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    public Seller(Contact contact, Address address){
        this.address = address;
        this.contact = contact;

    }

    private String sellerId;
    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
