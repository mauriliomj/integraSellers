package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateSeller {

    private SellerDataGateway sellerDataGateway;

    @Autowired
    public UpdateSeller(SellerDataGateway sellerDataGateway){
        this.sellerDataGateway = sellerDataGateway;
    }

    public Seller updateSeller(String sellerId, Seller updatedSeller){
        Optional<Seller> existingSeller = sellerDataGateway.findById(sellerId);
        if (existingSeller.isPresent()) {
            updatedSeller.setCreatedDate(existingSeller.get().getCreatedDate());
            updatedSeller.setLastModifiedDate(LocalDateTime.now());
            sellerDataGateway.save(updatedSeller);
            return updatedSeller;
        } else {
            throw new NotFound("Seller não encontrado!");
        }
    }
}
