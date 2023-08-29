package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class AddSeller {

    private SellerDataGateway sellerDataGateway;

    @Autowired
    public AddSeller(SellerDataGateway sellerDataGateway){

        this.sellerDataGateway = sellerDataGateway;

    }

    public void execute(Seller seller) {
        if(sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){
            throw new AlreadyRegisteredException("Seller já registrado!");
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(LocalDateTime.now().toString());
            seller.setLastModifiedDate(LocalDateTime.now().toString());
            sellerDataGateway.save(seller);
        }
    }
}
