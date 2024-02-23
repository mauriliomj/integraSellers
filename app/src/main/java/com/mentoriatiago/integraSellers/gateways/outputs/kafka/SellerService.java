package com.mentoriatiago.integraSellers.gateways.outputs.kafka;

import com.mentoriatiago.integraSellers.exceptions.ErrorSendingMessage;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.producer.SellerProducer;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.SellerResource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
  @Autowired
  private SellerProducer sellerProducer;

  public void sellerIntegral(SellerResource sellerResource){
    try {
      sellerProducer.sendMessage(sellerResource);
    } catch (IOException e) {
      throw new ErrorSendingMessage("Erro ao processar a mensagem!");
    }
  }
}
