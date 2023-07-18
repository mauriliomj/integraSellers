package com.mentoriatiago.integramarketplace.gateways.outputs.mongodb;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.repositories.SellersRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerDataGatewayMongoImpl implements SellerDataGateway {

  @Autowired
  private SellersRepository sellersRepository;

  @Override
  public void save(Seller seller) {
    sellersRepository.save(new SellerDocument(seller));
  }

  @Override
  public Optional<Seller> findByRegistrationCode(String registrationCode) {
    return sellersRepository.findByRegistrationCode(registrationCode).map(SellerDocument::toDomain);
  }

  @Override
  public Optional<Seller> findById(String sellerId) {
    return sellersRepository.findById(sellerId).map(SellerDocument::toDomain);
  }

  @Override
  public Boolean sellerExists(String sellerId) {
    return sellersRepository.existsById(sellerId);
  }
}
