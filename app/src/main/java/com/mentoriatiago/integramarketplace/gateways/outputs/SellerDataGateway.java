package com.mentoriatiago.integramarketplace.gateways.outputs;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface SellerDataGateway {

  void save(Seller seller);

  Optional<Seller> findByRegistrationCode(String registrationCode);

  Optional<Seller> findById(String sellerId);

  Boolean sellerExists(String sellerId);

  Page<Seller> findAll(PageRequest pageRequest);

  boolean existsById(String sellerId);

}
