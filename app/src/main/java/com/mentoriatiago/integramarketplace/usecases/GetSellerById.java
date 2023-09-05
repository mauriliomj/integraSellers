package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetSellerById {

    private SellerDataGateway sellerDataGateway;

    public Seller getSeller(String sellerId){

        return sellerDataGateway.findById(sellerId).orElseThrow(()->new
                NotFound("ID não encontrado!"));

    }
}
