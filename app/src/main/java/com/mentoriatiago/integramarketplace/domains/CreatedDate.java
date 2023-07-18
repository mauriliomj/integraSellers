package com.mentoriatiago.integramarketplace.domains;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CreatedDate {
    private String createdDate;

    public String dateTime() {
        createdDate = LocalDateTime.now().toString();
        return createdDate;
    }
}
