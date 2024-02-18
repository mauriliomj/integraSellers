package com.mentoriatiago.integraSellers.configurations;

import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerKafkaConfiguration {
  @Autowired
  private KafkaProperties kafkaProperties;

  @Value("${integra-sellers.seller.broadcast}")
  private String seller_topic;

  @Bean
  public ProducerFactory<String, String> producerFactory(){
    Map<String, Object> properties = kafkaProperties.buildProducerProperties();
    return new DefaultKafkaProducerFactory<>(properties);
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public NewTopic sellerRequestTopicBuilder(){
    return TopicBuilder
        .name(seller_topic)
        .partitions(1)
        .replicas(1)
        .build();
  }
}
