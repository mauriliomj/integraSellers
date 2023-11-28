package com.mentoriatiago.integraSellers.gateways.outputs.mongodb;
import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integraSellers.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoriatiago.integraSellers.gateways.outputs.mongodb.repositories.SellersRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    return sellersRepository.findByRegistrationCode(registrationCode)
            .map(SellerDocument::toDomain);

  }

  @Override
  public Optional<Seller> findById(String sellerId) {

    return sellersRepository.findById(sellerId).map(SellerDocument::toDomain);

  }

  @Override
  public Page<Seller> findAll(Pageable pageable) {

    return sellersRepository.findAll(pageable).map(SellerDocument::toDomain);

  }
}

