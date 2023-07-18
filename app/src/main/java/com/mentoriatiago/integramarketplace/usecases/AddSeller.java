package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.gateways.outputs.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class AddSeller {
    @Autowired
    private SellersRepository sellersRepository;
    public void save(Seller seller){
        if(sellersRepository.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){
            throw new AlreadyRegisteredException("Seller já registrado!");
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(new CreatedDate().dateTime());
            seller.setLastModifiedDate(new LastModifiedDate().lastModifiedDate());
            sellersRepository.save(seller);
        }
    }
}
