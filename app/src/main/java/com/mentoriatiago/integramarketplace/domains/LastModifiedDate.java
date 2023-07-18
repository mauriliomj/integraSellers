package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LastModifiedDate {
    private String modifiedDate;

    public String lastModifiedDate() {
        modifiedDate = LocalDateTime.now().toString();
        return modifiedDate;
    }
}
