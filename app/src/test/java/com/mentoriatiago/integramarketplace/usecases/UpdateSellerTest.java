package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.gateways.inputs.jsons.SellerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.support.SimpleTriggerContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UpdateSellerTest {

    @Autowired
    UpdateSeller updateSeller;

    @Autowired
    GetSellerById getSellerById;
    @Test
    public void shouldUpdateSellerById(){

        SellerRequest sellerRequest = new SellerRequest();
        sellerRequest.setName("Junit Test");

        updateSeller.updateSeller("1686582944990_1", sellerRequest);

        Seller modifiedSeller = getSellerById.getSeller("1686582944990_1");

        assertEquals(sellerRequest.getRegistrationCode(), modifiedSeller.getRegistrationCode());
    }
}
