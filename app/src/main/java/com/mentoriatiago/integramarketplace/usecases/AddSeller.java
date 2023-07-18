package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddSeller {

    @Autowired
    private SellerDataGateway sellerDataGateway;

    public void execute(Seller seller) {
        if(sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){
            throw new AlreadyRegisteredException("Seller já registrado!");
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(new CreatedDate().dateTime());
            seller.setLastModifiedDate(new LastModifiedDate().lastModifiedDate());
            sellerDataGateway.save(seller);
        }
    }
}
