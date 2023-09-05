package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegistered;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.joda.time.LocalDateTime;

@Component
@AllArgsConstructor
public class AddSeller {

    private SellerDataGateway sellerDataGateway;

    public void execute(Seller seller) {

        if(sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){

            throw new AlreadyRegistered("Seller já registrado!");

        } else{

            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(LocalDateTime.now());
            seller.setLastModifiedDate(LocalDateTime.now());

            sellerDataGateway.save(seller);

        }
    }
}
