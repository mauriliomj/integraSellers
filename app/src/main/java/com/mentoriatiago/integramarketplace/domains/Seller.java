package com.mentoriatiago.integramarketplace.domains;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Document("sellers")
public class Seller {

    @Id
    private String sellerId;
    @NotNull(message = "{not.null}")
    @Indexed
    private String name;
    @NotNull(message = "{not.null}")
    @Indexed
    private String registrationCode;
    @Indexed
    private Contact contact;
    @Indexed
    private Address address;
    @Indexed
    private String createdDate;
    @Indexed
    private String lastModifiedDate;

}
