package com.diveger.backend.infrastructure.adapters.out;

import com.diveger.backend.application.dto.CharacterResponseDTO;
import com.diveger.backend.application.ports.out.PersonInfoPort;
import com.diveger.backend.infrastructure.common.exceptions.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PersonInfoAdapter implements PersonInfoPort {

    @Override
    public List<CharacterResponseDTO> getPersonInfo(String name) {
        validateCharacterName(name);

        return null;
    }

    private void validateCharacterName(String name) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Character name is null or empty");
            throw new BadRequestException("The character name must not be empty.");
        }
    }

    // Obtain person info from the Star Wars API

    // Obtain faster vehicle url

    // Get films
}
