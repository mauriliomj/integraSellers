package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.NotFoundException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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
  @Captor
  private ArgumentCaptor<Seller> sellerArgumentCaptor;

  @Test
  public void shouldFindAndSaveChangesOfSellerById() {
    Mockito.when(sellerDataGateway.findById(mockSeller().getSellerId()))
        .thenReturn(Optional.of(mockSeller()));
    updateSeller.execute(mockSeller().getSellerId(), mockSeller());

    Mockito.verify(sellerDataGateway).findById(mockSeller().getSellerId());
    Mockito.verify(sellerDataGateway).save(sellerArgumentCaptor.capture());

    Seller capturedSeller = sellerArgumentCaptor.getValue();
    Assertions.assertEquals(mockSeller().getSellerId(), capturedSeller.getSellerId());
    Assertions.assertEquals(mockSeller().getName(), capturedSeller.getName());
    Assertions.assertEquals(mockSeller().getContact(), capturedSeller.getContact());
    Assertions.assertEquals(mockSeller().getAddress(), capturedSeller.getAddress());
    Assertions.assertEquals(mockSeller().getRegistrationCode(), capturedSeller
        .getRegistrationCode());

    //conferir divergencia de datas com o Tiago...

    Assertions.assertNotEquals(mockSeller().getCreatedDate(), capturedSeller.getCreatedDate());
    Assertions.assertNotEquals(mockSeller().getLastModifiedDate(), capturedSeller
        .getLastModifiedDate());
  }

  @Test
  public void shouldThrowNotFoundException() {
    Mockito.when(sellerDataGateway.findById(any()))
        .thenThrow(new NotFoundException("Seller não encontrado!"));

    Assertions.assertThrows(NotFoundException.class, () -> updateSeller
        .execute(mockSeller().getSellerId(), mockSeller()));
  }

  public Seller mockSeller() {
    Seller mockSeller = new Seller();
    mockSeller.setSellerId("1693535770652_1");
    mockSeller.setName("MCM Comercial Eletrica ME");
    mockSeller.setRegistrationCode("17.562.451/0001-15");
    mockSeller.setCreatedDate(LocalDateTime.now());
    mockSeller.setLastModifiedDate(LocalDateTime.now());

    return mockSeller;
  }
}