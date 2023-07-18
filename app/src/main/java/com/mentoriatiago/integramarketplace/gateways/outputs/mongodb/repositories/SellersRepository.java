package com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.repositories;

import com.mentoriatiago.integramarketplace.gateways.outputs.mongodb.documents.SellerDocument;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellersRepository extends PagingAndSortingRepository<SellerDocument, String> {

  Optional<SellerDocument> findByRegistrationCode(String registrationCode);

}
