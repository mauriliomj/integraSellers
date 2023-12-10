package com.mentoriatiago.integraSellers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntegraSellersApplication {

  public static void main(String[] args) {
    SpringApplication.run(IntegraSellersApplication.class, args);
  }

}
