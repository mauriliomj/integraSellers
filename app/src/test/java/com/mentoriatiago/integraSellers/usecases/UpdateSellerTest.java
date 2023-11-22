package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.NotFoundException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdateSellerTest {

    @InjectMocks
    private UpdateSeller updateSeller;
    @Mock
    private SellerDataGateway sellerDataGateway;

    @Test
    public void deveEncontrarESalvarAlteracoesDeUmSellerPeloId(){

        Seller seller = mockSeller();
        Seller modifiedSeller = mockSellerUpdated();

        Mockito.when(sellerDataGateway.findById(seller.getSellerId()))
            .thenReturn(Optional.of(seller));

        Seller sellerAfterModified = updateSeller.updateSeller(seller.getSellerId(),
            modifiedSeller);

        Mockito.verify(sellerDataGateway).findById(seller.getSellerId());

        Assertions.assertEquals(seller.getCreatedDate(), sellerAfterModified.getCreatedDate());
        Assertions.assertNotEquals(seller.getLastModifiedDate(),
            sellerAfterModified.getLastModifiedDate());
        Assertions.assertEquals(seller.getRegistrationCode(),
            sellerAfterModified.getRegistrationCode());
        Assertions.assertNotEquals(seller.getName(),sellerAfterModified.getName());

    }

    @Test
    public void deveLancarNotFoundSeNaoEncontrarOSeller(){

        Seller seller = mockSeller();
        Seller modifiedSeller = mockSellerUpdated();

        Mockito.when(sellerDataGateway.findById(any()))
            .thenThrow(new NotFoundException("Seller não encontrado!"));

        Assertions.assertThrows(NotFoundException.class, ()->updateSeller
            .updateSeller(seller.getSellerId(), modifiedSeller));

    }

    public Seller mockSeller(){

        Seller mockSeller = new Seller();
        mockSeller.setSellerId("1693535770652_1");
        mockSeller.setName("MCM Comercial Eletrica ME");
        mockSeller.setRegistrationCode("17.562.451/0001-15");
        mockSeller.setCreatedDate(LocalDateTime.now());
        mockSeller.setLastModifiedDate(LocalDateTime.now());
        return mockSeller;

    }

    public Seller mockSellerUpdated(){

        Seller mockSellerUpdated = new Seller();
        mockSellerUpdated.setSellerId("1693535770652_1");
        mockSellerUpdated.setName("Supermercado Lopes");
        mockSellerUpdated.setRegistrationCode("17.562.451/0001-15");
        return mockSellerUpdated;

    }
}