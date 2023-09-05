package com.mentoriatiago.integramarketplace.usecases;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.gateways.outputs.SellerDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GetAllSellersTest {

    @InjectMocks
    private GetAllSellers getAllSellers;
    @Mock
    private SellerDataGateway sellerDataGateway;

    @Test
    public void deveRetornarUmaPageSeller(){

        int pageNumber = 0;
        int pageSize = 10;
        Page<Seller> sellerPage = mock(Page.class);

        Mockito.when(sellerDataGateway.findAll(PageRequest.of(pageNumber,pageSize)))
                .thenReturn(sellerPage);
        getAllSellers.getSellers(pageNumber,pageSize);

        Mockito.verify(sellerDataGateway).findAll(PageRequest.of(pageNumber,pageSize));
        Assertions.assertEquals(sellerPage, sellerDataGateway
                .findAll(PageRequest.of(pageNumber,pageSize)));

    }
}