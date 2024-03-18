package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.*;
import com.mentoriatiago.integraSellers.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.SellerBroadcast;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddSeller {
  @Autowired
  private SellerDataGateway sellerDataGateway;
  @Autowired
  private SellerBroadcast sellerBroadcast;


  public void execute(Seller seller) {
    if (sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()) {
      throw new AlreadyRegisteredException("Seller já registrado!");
    } else {
      seller.setSellerId(new SellerId().selerId());
      seller.setCreatedDate(LocalDateTime.now());
      seller.setLastModifiedDate(LocalDateTime.now());
      sellerBroadcast.sellerIntegral(seller);
      sellerDataGateway.save(seller);
    }
  }
}
