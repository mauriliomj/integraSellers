package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetAllSellers {
    @Autowired
    private SellersRepository sellersRepository;

    public Page<Seller> getSellers(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        return sellersRepository.findAll(pageable);
    }
}
