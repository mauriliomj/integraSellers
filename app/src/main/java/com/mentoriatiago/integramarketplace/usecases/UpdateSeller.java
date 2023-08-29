package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.inputs.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UpdateSeller {
    private SellerDataGateway sellerDataGateway;
    @Autowired
    public UpdateSeller(SellerDataGateway sellerDataGateway){
        this.sellerDataGateway = sellerDataGateway;
    }
    public Optional<Seller> updateSeller(String sellerId, SellerRequest updatedSeller){
        Optional<Seller> existingSeller = sellerDataGateway.findById(sellerId);
        Seller seller = updatedSeller.toDomain();

        if (existingSeller.isPresent()) {
            seller.setCreatedDate(existingSeller.get().getCreatedDate());
            seller.setSellerId(existingSeller.get().getSellerId());
            seller.setLastModifiedDate(LocalDateTime.now().toString());
            sellerDataGateway.save(seller);

            return existingSeller;

        } else {
            throw new NotFound("Seller não encontrado!");
        }
    }
}
