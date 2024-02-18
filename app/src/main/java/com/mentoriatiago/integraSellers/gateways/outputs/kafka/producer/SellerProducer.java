package com.mentoriatiago.integraSellers.gateways.outputs.kafka.producer;

import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.SellerResource;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SellerProducer {
  @Autowired
  @Value("${integra-sellers.seller.broadcast}")
  private String seller_topic;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(SellerResource sellerResource) throws IOException {
    String content = objectMapper.writeValueAsString(sellerResource);
    kafkaTemplate.send(seller_topic, content);
  }
}
