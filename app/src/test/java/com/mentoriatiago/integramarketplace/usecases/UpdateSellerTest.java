package com.mentoriatiago.integramarketplace.usecases;

import static java.util.Optional.empty;
import static org.mockito.ArgumentMatchers.anyString;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
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
class UpdateSellerTest {

    @InjectMocks
    private UpdateSeller updateSeller;

    @Mock
    private SellerDataGateway sellerDataGateway;

    @Test
    public void deveEncontrarESalvarAlteracoesDeUmSellerPeloId(){
        //dado - given
        Seller seller = mockSeller();

        Mockito.when(sellerDataGateway.findById(seller.getSellerId()))
            .thenReturn(Optional.of(seller));

        //quando - when
        Seller savedSeller = updateSeller
            .updateSeller(seller.getSellerId(), seller);

        //então - then
        Assertions.assertNotNull(savedSeller);
        Assertions.assertEquals(seller, savedSeller);
        Mockito.verify(sellerDataGateway).findById(seller.getSellerId());
        Mockito.verify(sellerDataGateway).save(seller);
     }

    @Test
    public void deveLancarNotFoundSeNaoEncontrarOSeller(){
        //given
        Mockito.when(sellerDataGateway.findById(anyString())).thenReturn(empty());

        //when
        Assertions.assertThrows(NotFound.class,
                ()->updateSeller.updateSeller("123",new Seller()),
                "Deve Lancar exception NotFound!");

        //then
        Mockito.verify(sellerDataGateway).findById("123");
    }

    private Seller mockSeller() {
        Seller seller = new Seller();
        seller.setSellerId("1");
        seller.setName("Seller de Teste");
        seller.setRegistrationCode("36.506.556/0001-00");
        seller.setCreatedDate(LocalDateTime.now());
        seller.setLastModifiedDate(LocalDateTime.now());
        return seller;
    }

}