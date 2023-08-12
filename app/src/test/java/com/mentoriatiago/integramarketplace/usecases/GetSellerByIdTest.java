package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GetSellerByIdTest {

    //"sellerId": "1690151525280_1"
    //"registrationCode": "josueteste"

    @Autowired
    GetSellerById getSellerById;

    @Test
    public void shouldGetSellerById(){
        Seller sellerTest = getSellerById.getSeller("1690151525280_1");
        String registrationCode = "josueteste";

        assertEquals(registrationCode, sellerTest.getRegistrationCode());
    }

}
