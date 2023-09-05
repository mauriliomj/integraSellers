package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAllSellers {

    private SellerDataGateway sellerDataGateway;

    public Page<Seller> getSellers(int pageNumber, int pageSize){

        PageRequest pageable = PageRequest.of(pageNumber, pageSize);

        return sellerDataGateway.findAll(pageable);

    }
}
