package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.*;
import com.mentoriatiago.integraSellers.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddSeller {

  private SellerDataGateway sellerDataGateway;

  public void execute(Seller seller) {

    if (sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()) {

      throw new AlreadyRegisteredException("Seller já registrado!");

    } else {

      seller.setSellerId(new SellerId().selerId());
      seller.setCreatedDate(LocalDateTime.now());
      seller.setLastModifiedDate(LocalDateTime.now());

      sellerDataGateway.save(seller);

    }
  }
}
