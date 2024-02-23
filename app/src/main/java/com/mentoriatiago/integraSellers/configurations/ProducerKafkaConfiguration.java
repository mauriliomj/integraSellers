package com.mentoriatiago.integraSellers.configurations;

import com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources.SellerResource;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
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
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return new DefaultKafkaProducerFactory<>(properties);
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> configProps = kafkaProperties.buildConsumerProperties();
    configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new
        ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
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
