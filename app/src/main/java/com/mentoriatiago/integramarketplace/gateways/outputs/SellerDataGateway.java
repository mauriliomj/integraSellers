package com.mentoriatiago.integramarketplace.gateways.outputs;

import com.mentoriatiago.integramarketplace.domains.Seller;
import java.util.Optional;

public interface SellerDataGateway {

  void save(Seller seller);

  Optional<Seller> findByRegistrationCode(String registrationCode);

  Optional<Seller> findById(String sellerId);

  Boolean sellerExists(String sellerId);

}
