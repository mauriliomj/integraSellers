package com.mentoriatiago.integraSellers.usecases;

import com.mentoriatiago.integraSellers.domains.Address;
import com.mentoriatiago.integraSellers.domains.Contact;
import com.mentoriatiago.integraSellers.domains.ContactTypeEnum;
import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.AlreadyRegisteredException;
import com.mentoriatiago.integraSellers.gateways.outputs.SellerDataGateway;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.SellerBroadcast;
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
public class AddSellerTest {

  @InjectMocks
  private AddSeller addSeller;
  @Mock
  private SellerDataGateway sellerDataGateway;

  @Mock
  private SellerBroadcast sellerBroadcast;

  @Test
  public void shouldSaveASeller() {
    Seller seller = mockSeller();

    Mockito.when(sellerDataGateway.
            findByRegistrationCode(seller.getRegistrationCode()))
        .thenReturn(Optional.empty());

    addSeller.execute(seller);

    Mockito.verify(sellerDataGateway)
        .findByRegistrationCode(seller.getRegistrationCode());
    Mockito.verify(sellerBroadcast).sellerIntegral(seller);
    Mockito.verify(sellerDataGateway).save(seller);
  }

  @Test
  public void shouldThrowAlreadyRegisteredException() {

    Mockito.when(sellerDataGateway.findByRegistrationCode(any()))
        .thenThrow(new AlreadyRegisteredException("Seller já registrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class,
        () -> addSeller.execute(mockSeller()));

  }

  public Seller mockSeller() {
    Seller mockSeller = new Seller();
    mockSeller.setSellerId("1693535770652_1");
    mockSeller.setName("MCM Comercial Eletrica ME");
    mockSeller.setAddress(mockAddress());
    mockSeller.setContact(mockContact());
    mockSeller.setRegistrationCode("17.562.451/0001-15");
    mockSeller.setCreatedDate(LocalDateTime.now());
    mockSeller.setLastModifiedDate(LocalDateTime.now());

    return mockSeller;
  }

  public Address mockAddress(){
    return new Address("street", "number", "zipcode",
        "city", "state", "country");
  }

  public Contact mockContact(){
    return new Contact(ContactTypeEnum.EMAIL, "email@test");
  }
}