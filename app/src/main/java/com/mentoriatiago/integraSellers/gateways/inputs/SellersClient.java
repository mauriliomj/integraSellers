package com.mentoriatiago.integraSellers.gateways.inputs;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.domains.SellerId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sellers", url = "http://localhost:8080/sellers")
public interface SellersClient {
  @RequestMapping(method = RequestMethod.POST, value = "", consumes = "application/json")
  void addSellers(Seller seller);

  @RequestMapping(method = RequestMethod.GET, value = "")
  Page<Seller> getSellers();

  @RequestMapping(method = RequestMethod.PUT, value = "/{sellerId}")
  Seller updateSeller(SellerId sellerId);

  @RequestMapping(method = RequestMethod.GET, value = "/{sellerId}")
  Seller getSeller(SellerId sellerId);
}
