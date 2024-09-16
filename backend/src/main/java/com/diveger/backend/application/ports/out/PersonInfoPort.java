package com.diveger.backend.application.ports.out;

import com.diveger.backend.application.dto.CharacterResponseDTO;

import java.util.List;

public interface PersonInfoPort {
    List<CharacterResponseDTO> getPersonInfo(String name);
}
