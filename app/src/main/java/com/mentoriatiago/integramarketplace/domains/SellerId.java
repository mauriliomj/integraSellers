package com.mentoriatiago.integramarketplace.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@EqualsAndHashCode
public class SellerId {

    AtomicLong id = new AtomicLong();

    public String selerId(){

        Date now = new Date();
        long timestamp = now.getTime();
        long userId = id.incrementAndGet();
        String sellerId = timestamp+"_"+userId;
        return sellerId;

    }
}
