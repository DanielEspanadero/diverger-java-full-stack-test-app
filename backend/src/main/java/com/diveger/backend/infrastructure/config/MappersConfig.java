package com.diveger.backend.infrastructure.config;

import com.diveger.backend.application.mappers.PeopleMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public PeopleMapper peopleMapper() {
        return new PeopleMapper();
    }
}
