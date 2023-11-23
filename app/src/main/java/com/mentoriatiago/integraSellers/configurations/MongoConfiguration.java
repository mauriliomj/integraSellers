package com.mentoriatiago.integraSellers.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {
    "com.mentoriatiago.integraSellers.gateways.outputs"})
public class MongoConfiguration {

}
