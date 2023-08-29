package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.domains.SellerId;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.inputs.jsons.ContactRequest;
import com.mentoriatiago.integramarketplace.gateways.inputs.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

@SpringBootTest
class UpdateSellerTest {
    @InjectMocks
    private UpdateSeller updateSeller;
    @Mock
    private SellerDataGateway sellerDataGateway;
    @Test
    public void deveEncontrarESalvarAlteracoesDeUmSellerPeloId(){
        String sellerId = "test";
        Seller seller = mock(Seller.class);
        SellerRequest sellerRequest = new SellerRequest();
        sellerRequest.setContact(new ContactRequest());

        Mockito.when(sellerDataGateway.findById(sellerId))
                .thenReturn(Optional.of(seller));

        Optional<Seller> optionalSeller = updateSeller
                .updateSeller(sellerId,sellerRequest);

        Assertions.assertTrue(optionalSeller.isPresent());
        Assertions.assertEquals(seller, optionalSeller.get(),"sellers iguais");
        Mockito.verify(sellerDataGateway).findById(sellerId);
        Mockito.verify(sellerDataGateway).save(any(Seller.class));
     }

    @Test
    public void deveLancarNotFoundSeNaoEncontrarOSeller(){
        String sellerId = "test";
        SellerRequest sellerRequest = new SellerRequest();
        sellerRequest.setContact(new ContactRequest());

        Mockito.when(sellerDataGateway.findById(sellerId))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(NotFound.class,
                ()->updateSeller.updateSeller(sellerId,sellerRequest),
                "Deve Lancar exception NotFound!");

        Mockito.verify(sellerDataGateway).findById(sellerId);
    }
}