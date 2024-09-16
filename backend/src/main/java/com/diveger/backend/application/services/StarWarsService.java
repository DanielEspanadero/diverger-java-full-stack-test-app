package com.diveger.backend.application.services;

import com.diveger.backend.application.dto.CharacterResponseDTO;
import com.diveger.backend.application.ports.in.PersonInfoUseCase;
import com.diveger.backend.application.ports.out.PersonInfoPort;

import java.util.List;

public class StarWarsService implements PersonInfoUseCase {
    private final PersonInfoPort personInfoPort;

    public StarWarsService(PersonInfoPort personInfoPort) {
        this.personInfoPort = personInfoPort;
    }

    @Override
    public List<CharacterResponseDTO> getPersonInfo(String name) {
        return personInfoPort.getPersonInfo(name);
    }
}
