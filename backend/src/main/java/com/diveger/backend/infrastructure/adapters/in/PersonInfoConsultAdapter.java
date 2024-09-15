package com.diveger.backend.infrastructure.adapters.in;

import com.diveger.backend.application.dto.CharacterResponseDTO;
import com.diveger.backend.application.ports.out.PersonInfoPort;

import java.util.List;

public class PersonInfoConsultAdapter implements PersonInfoPort {
    private final PersonInfoPort personInfoPort;

    public PersonInfoConsultAdapter(PersonInfoPort personInfoPort) {
        this.personInfoPort = personInfoPort;
    }

    @Override
    public List<CharacterResponseDTO> getPersonInfo(String name) {
        return personInfoPort.getPersonInfo(name);
    }
}