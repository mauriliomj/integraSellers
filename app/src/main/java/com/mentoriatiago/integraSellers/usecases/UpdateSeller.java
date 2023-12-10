package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.NotFoundException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UpdateSeller {

  private SellerDataGateway sellerDataGateway;

  public Seller updateSeller(String sellerId, Seller updatedSeller) {

    Optional<Seller> existingSeller = sellerDataGateway.findById(sellerId);

    if (existingSeller.isPresent()) {

      updatedSeller.setLastModifiedDate(LocalDateTime.now());
      updatedSeller.setSellerId(existingSeller.get().getSellerId());

      sellerDataGateway.save(updatedSeller);

      return updatedSeller;

    } else {

      throw new NotFoundException("Seller não encontrado!");

    }
  }
}
