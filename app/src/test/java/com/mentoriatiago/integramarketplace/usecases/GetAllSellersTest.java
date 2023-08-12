package com.mentoriatiago.integramarketplace.usecases;
import com.mentoriatiago.integramarketplace.domains.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import static org.junit.jupiter.api.Assertions.assertEquals;

//A ideia aqui é testar se a pagina e a quantidade de sellers emitidas pelo repositório
//corresponde a quantidade enviada ao repositório
@SpringBootTest
public class GetAllSellersTest {

    @Autowired
    GetAllSellers getAllSellers;

    @Test
    public void testPagination(){

    Integer pageNumber = 1;
    Integer pageSize = 10;

    Page<Seller> sellerList = getAllSellers.getSellers(1,10);

    assertEquals(pageSize, sellerList.getSize());
    assertEquals(pageNumber, sellerList.getNumber());

    }
}
