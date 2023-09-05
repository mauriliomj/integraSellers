package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddSeller {

    private SellerDataGateway sellerDataGateway;

    public void execute(Seller seller) {

        if(sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){

            throw new AlreadyRegisteredException("Seller já registrado!");

        } else{

            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(LocalDateTime.now());
            seller.setLastModifiedDate(LocalDateTime.now());

            sellerDataGateway.save(seller);

        }
    }
}
