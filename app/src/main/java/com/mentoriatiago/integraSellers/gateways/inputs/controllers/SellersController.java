package com.mentoriatiago.integraSellers.gateways.inputs.controllers;

import com.mentoriatiago.integraSellers.domains.*;
import com.mentoriatiago.integraSellers.exceptions.NotFoundException;
import com.mentoriatiago.integraSellers.gateways.inputs.jsons.SellerRequest;
import com.mentoriatiago.integraSellers.usecases.AddSeller;
import com.mentoriatiago.integraSellers.usecases.GetAllSellers;
import com.mentoriatiago.integraSellers.usecases.GetSellerById;
import com.mentoriatiago.integraSellers.usecases.UpdateSeller;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

@Getter
@RestController
@RequestMapping(value = "/sellers")
public class SellersController {

  @Autowired
  private AddSeller addSeller;
  @Autowired
  private GetAllSellers getAllSellers;
  @Autowired
  private GetSellerById getSellerById;
  @Autowired
  private UpdateSeller updateSeller;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  @ApiOperation("Adiciona um novo seller!")
  @NotNull
  public void addSellers(@RequestBody SellerRequest sellerRequest) {

    addSeller.execute(sellerRequest.toDomain());

  }

  @GetMapping
  @ApiOperation("Lista os sellers cadastrados.")
  public Page<Seller> getSellers(@RequestParam(defaultValue = "0") int pageNumber,
      @RequestParam(defaultValue = "10") int pageSize) {

    return getAllSellers.getSellers(pageNumber, pageSize);

  }

  @PutMapping(value = "/{sellerId}")
  @ApiOperation("Atualiza/modifica os sellers cadastrados.")
  public Seller updateSeller(@PathVariable String sellerId,
      @RequestBody SellerRequest updatedSeller)
      throws NotFoundException {

    return updateSeller.updateSeller(sellerId, updatedSeller.toDomain());

  }

  @GetMapping("/{sellerId}")
  @ApiOperation("Busca um Seller pelo Id.")
  public Seller getSeller(String sellerId) {

    return getSellerById.getSeller(sellerId);

  }
}
