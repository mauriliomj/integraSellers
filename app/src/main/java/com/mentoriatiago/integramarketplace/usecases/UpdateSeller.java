package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.inputs.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.gateways.outputs.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UpdateSeller {
    @Autowired
    private SellersRepository sellersRepository;
    public Optional<Seller> updateSeller(String sellerId, SellerRequest updatedSeller){
        Optional<Seller> existingSeller = sellersRepository.findById(sellerId);
        Seller seller = updatedSeller.toDomain();

        if (existingSeller.isPresent()) {
            seller.setCreatedDate(existingSeller.get().getCreatedDate());
            seller.setSellerId(existingSeller.get().getSellerId());
            seller.setLastModifiedDate(LocalDateTime.now().toString());
            sellersRepository.save(seller);

            return sellersRepository.findById(sellerId);

        } else {
            throw new NotFound("Seller não encontrado!");
        }
    }
}
