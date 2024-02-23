package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.*;
import com.mentoriatiago.integraSellers.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.SellerService;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.AddressResource;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.ContactResource;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.SellerResource;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddSeller {
  @Autowired
  private SellerDataGateway sellerDataGateway;
  @Autowired
  private SellerService sellerService;
  @Autowired
  private SellerResource sellerResource;

  public void execute(Seller seller) {

    if (sellerDataGateway.findByRegistrationCode(seller.getRegistrationCode()).isPresent()) {

      throw new AlreadyRegisteredException("Seller já registrado!");

    } else {

      seller.setSellerId(new SellerId().selerId());
      seller.setCreatedDate(LocalDateTime.now());
      seller.setLastModifiedDate(LocalDateTime.now());

      sellerResource.setSellerId(seller.getSellerId());
      sellerResource.setName(seller.getName());
      sellerResource.setRegistrationCode(seller.getRegistrationCode());
      sellerResource.setContact(new ContactResource(seller.getContact()));
      sellerResource.setAddress(new AddressResource(seller.getAddress()));
      sellerResource.setCreatedDate(seller.getCreatedDate().toString());
      sellerResource.setLastModifiedDate(seller.getLastModifiedDate().toString());

      sellerDataGateway.save(seller);
      sellerService.sellerIntegral(sellerResource);
    }
  }
}
