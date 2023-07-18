package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.outputs.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class GetSellerById {
    @Autowired
    private SellersRepository sellersRepository;
    public Optional<Seller> getSeller(String sellerId){
        if(sellersRepository.existsById(sellerId)){
            return sellersRepository.findById(sellerId);
        } else{
            throw new NotFound(sellerId+" Id não encontrado!");
        }
    }
}
