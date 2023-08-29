package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.domains.SellerId;
import com.mentoriatiago.integramarketplace.exceptions.NotFound;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import com.sun.source.tree.ModuleTree;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetSellerByIdTest {
    @InjectMocks
    private GetSellerById getSellerById;
    @Mock
    private SellerDataGateway sellerDataGateway;
    @Test
    public void deveriaMostrarUmSellerPeloId(){
        String sellerId = "Id Teste";
        Seller seller = mock(Seller.class);
        Mockito.when(sellerDataGateway.findById(sellerId))
                .thenReturn(Optional.of(seller));
        getSellerById.getSeller(sellerId);
        Mockito.verify(sellerDataGateway).findById(sellerId);
    }
    @Test
    public void deveLancarExceptionSeNaoEncontrarUmSeller(){
        String sellerId = "test";

        Mockito.when(sellerDataGateway.findById(sellerId)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFound.class, ()-> getSellerById.getSeller(sellerId));

        Mockito.verify(sellerDataGateway).findById(sellerId);
    }
}