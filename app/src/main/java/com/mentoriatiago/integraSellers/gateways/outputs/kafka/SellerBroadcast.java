package com.mentoriatiago.integraSellers.gateways.outputs.kafka;

import com.mentoriatiago.integraSellers.configurations.Ff4jFeatures;
import com.mentoriatiago.integraSellers.domains.Seller;
import com.mentoriatiago.integraSellers.exceptions.ErrorSendingMessage;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.producer.SellerProducer;
import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.SellerResource;
import java.io.IOException;
import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerBroadcast {
  @Autowired
  private SellerProducer sellerProducer;
  @Autowired
  private FF4j ff4j;

  public void sellerIntegral(Seller seller){
    SellerResource sellerResource = new SellerResource(seller);
    if(ff4j.check(Ff4jFeatures.SEND_TO_BROADCAST.getKey())){
      try {
        sellerProducer.sendMessage(sellerResource);
      } catch (IOException e) {
        throw new ErrorSendingMessage("Erro ao processar a mensagem!");
      }
    }
  }
}
