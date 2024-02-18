package com.mentoriatiago.integraSellers.gateways.outputs.kafka.resources;

import com.mentoriatiago.integraSellers.domains.Address;
import com.mentoriatiago.integraSellers.domains.Contact;
import com.mentoriatiago.integraSellers.domains.Seller;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SellerResource {
  private String sellerId;
  private String name;
  private String registrationCode;
  private String contact;
  private String address;
  private String createdDate;
  private String lastModifiedDate;
}
