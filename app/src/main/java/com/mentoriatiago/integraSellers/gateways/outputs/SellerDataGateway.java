package com.mentoriatiago.integraSellers.gateways.outputs;

import com.mentoriatiago.integraSellers.domains.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface SellerDataGateway {

  void save(Seller seller);

  Optional<Seller> findByRegistrationCode(String registrationCode);

  Optional<Seller> findById(String sellerId);

  Page<Seller> findAll(Pageable pageable);

}
