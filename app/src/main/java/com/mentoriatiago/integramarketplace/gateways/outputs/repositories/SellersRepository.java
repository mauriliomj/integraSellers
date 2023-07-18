package com.mentoriatiago.integramarketplace.gateways.outputs.repositories;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface SellersRepository extends PagingAndSortingRepository<Seller, String> {

    @Override
    Page<Seller> findAll(Pageable pageable);

    public Optional<Seller> findByRegistrationCode(String registrationCode);

    public Optional<Seller> findById(String sellerId);

    public boolean existsById(String sellerId);

}
