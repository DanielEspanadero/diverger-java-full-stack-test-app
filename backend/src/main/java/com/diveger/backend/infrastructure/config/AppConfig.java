package com.diveger.backend.infrastructure.config;

import com.diveger.backend.application.mappers.PeopleMapper;
import com.diveger.backend.application.ports.in.PersonInfoUseCase;
import com.diveger.backend.application.ports.out.PersonInfoPort;
import com.diveger.backend.application.services.StarWarsService;
import com.diveger.backend.infrastructure.adapters.out.PersonInfoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://swapi.dev/api/"));
        return restTemplate;
    }

    @Bean
    public PersonInfoPort personInfoPort(RestTemplate restTemplate, PeopleMapper peopleMapper) {
        return new PersonInfoAdapter(restTemplate, peopleMapper);
    }

    @Bean
    public PersonInfoUseCase personInfoUseCase(PersonInfoPort personInfoPort) {
        return new StarWarsService(personInfoPort);
    }
}
