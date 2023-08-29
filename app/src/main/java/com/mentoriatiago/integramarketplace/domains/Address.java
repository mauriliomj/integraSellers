package com.mentoriatiago.integramarketplace.domains;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String state;
    private String country;

}
