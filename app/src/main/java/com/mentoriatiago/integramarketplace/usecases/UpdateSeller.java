package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFoundException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UpdateSeller {

    private SellerDataGateway sellerDataGateway;

    public Seller updateSeller(String sellerId, Seller updatedSeller){

        Optional<Seller> existingSeller = sellerDataGateway.findById(sellerId);

        if (existingSeller.isPresent()) {

            updatedSeller.setCreatedDate(existingSeller.get().getCreatedDate());
            updatedSeller.setLastModifiedDate(LocalDateTime.now());

            sellerDataGateway.save(updatedSeller);

            return updatedSeller;

        } else {

            throw new NotFoundException("Seller não encontrado!");

        }
    }
}
