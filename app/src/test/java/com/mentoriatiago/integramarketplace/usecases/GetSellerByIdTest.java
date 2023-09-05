package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFoundException;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class GetSellerByIdTest {

    @InjectMocks
    private GetSellerById getSellerById;
    @Mock
    private SellerDataGateway sellerDataGateway;

    @Test
    public void deveriaEncontrarUmSellerPeloId(){

        Mockito.when(sellerDataGateway.findById(mockSeller().getSellerId()))
                .thenReturn(Optional.of(mockSeller()));

        getSellerById.getSeller(mockSeller().getSellerId());

        Mockito.verify(sellerDataGateway).findById(mockSeller().getSellerId());

    }

    @Test
    public void deveLancarExceptionSeNaoEncontrarUmSeller(){

        Mockito.when(sellerDataGateway.findById(mockSeller().getSellerId()))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, ()-> getSellerById
                .getSeller(mockSeller().getSellerId()));

        Mockito.verify(sellerDataGateway).findById(mockSeller().getSellerId());

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
}