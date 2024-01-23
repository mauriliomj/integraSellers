package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.NotFoundException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetSellerById {

  private SellerDataGateway sellerDataGateway;

  public Seller execute(String sellerId) {

    return sellerDataGateway.findById(sellerId).orElseThrow(() -> new
        NotFoundException("ID não encontrado!"));

  }
}
