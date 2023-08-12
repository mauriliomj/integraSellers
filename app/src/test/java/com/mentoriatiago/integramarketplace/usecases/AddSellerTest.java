package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/* Perguntar ao Tiago se é válido criar um novo repositorio ou o junit
apaga os objetos gerados */

@SpringBootTest
public class AddSellerTest {
    @Autowired
    AddSeller addSeller;

    @Test
    public void shouldSaveASeller(){

        Seller seller = new Seller("sellerIdTestJunit1", "name",
                "registrationCode1",
                new Contact(ContactTypeEnum.EMAIL, "maurilio@maurilio"),
                new Address(),"01/01/2021", "01/02/2021");

        addSeller.execute(seller);

        Seller sellerSaved = new GetSellerById().getSeller("sellerIdTestJunit1");

        assertEquals("sellerIdTestJunit1", sellerSaved);
    }
}