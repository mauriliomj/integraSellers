package com.mentoriatiago.integraSellers.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
