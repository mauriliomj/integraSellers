package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Id a ser consultado "1690151525280_1"
@SpringBootTest
public class GetSellerByIdTest {

    @Autowired
    GetSellerById getSellerById;

    @Test
    public void shouldGetSellerById(){
        Seller sellerTest = getSellerById.getSeller("1690151525280_1");

        String name = "josue";
        String registrationCode = "josueteste";
        String contact = "string";
        String street = "string";
        String number = "string";
        String zipcode = "string";
        String city = "string";
        String state = "string";
        String country = "string";
        String createdDate = "2023-07-23T19:32:05.467391959";
        String lastModifiedDate = "2023-07-23T19:32:05.468277123";

        assertEquals(name, sellerTest.getName());
        assertEquals(registrationCode, sellerTest.getRegistrationCode());
        assertEquals(contact, sellerTest.getContact().getValue());
        assertEquals(street, sellerTest.getAddress().getStreet());
        assertEquals(number, sellerTest.getAddress().getNumber());
        assertEquals(zipcode, sellerTest.getAddress().getZipcode());
        assertEquals(city, sellerTest.getAddress().getCity());
        assertEquals(state, sellerTest.getAddress().getState());
        assertEquals(country, sellerTest.getAddress().getCountry());
        assertEquals(createdDate, sellerTest.getCreatedDate());
        assertEquals(lastModifiedDate, sellerTest.getLastModifiedDate());
    }

}
