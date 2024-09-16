package com.diveger.backend.infrastructure.adapters.in.controllers;

import com.diveger.backend.application.dto.CharacterResponseDTO;
import com.diveger.backend.application.ports.in.PersonInfoUseCase;
import com.diveger.backend.infrastructure.common.Endpoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoints.SWAPI_PROXY)
public class StarWarsController {
    private final PersonInfoUseCase personInfoUseCase;

    public StarWarsController(PersonInfoUseCase personInfoUseCase) {
        this.personInfoUseCase = personInfoUseCase;
    }

    @GetMapping(Endpoints.PERSON_INFO)
    public List<CharacterResponseDTO> getPersonInfo(@RequestParam String name) {
        return personInfoUseCase.getPersonInfo(name);
    }
}
