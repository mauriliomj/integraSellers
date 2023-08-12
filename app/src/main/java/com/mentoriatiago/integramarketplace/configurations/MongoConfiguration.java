package com.mentoriatiago.integramarketplace.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {
        "com.mentoriatiago.integramarketplace.gateways.outputs"})
public class MongoConfiguration {
}
