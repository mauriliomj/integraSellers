package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAllSellers {

  private SellerDataGateway sellerDataGateway;

  public Page<Seller> execute(int pageNumber, int pageSize) {

    PageRequest pageable = PageRequest.of(pageNumber, pageSize);

    return sellerDataGateway.findAll(pageable);

  }
}
