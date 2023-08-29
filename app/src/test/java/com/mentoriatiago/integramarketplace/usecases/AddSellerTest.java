package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddSellerTest {
    @InjectMocks
    private AddSeller addSeller;
    @Mock
    private SellerDataGateway sellerDataGateway;
    @Test
    public void deveSalvarUmSeller(){
        Seller seller = new Seller();
        Mockito.when(sellerDataGateway
                .findByRegistrationCode(seller.getRegistrationCode()))
                .thenReturn(Optional.empty());
        addSeller.execute(seller);
        Mockito.verify(sellerDataGateway).save(seller);
    }
    @Test
    public void deveLancarExceptionEmSellerRepetido(){
        Mockito.when(sellerDataGateway.findByRegistrationCode(Mockito.any()))
                .thenReturn(Optional.of(new Seller()));

        Assertions.assertThrows(AlreadyRegisteredException.class, ()->addSeller.execute(new Seller()));
    }
  
}