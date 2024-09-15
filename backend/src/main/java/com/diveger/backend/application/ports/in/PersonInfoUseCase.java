package com.diveger.backend.application.ports.in;

import com.diveger.backend.application.dto.CharacterResponseDTO;

import java.util.List;

public interface PersonInfoUseCase {
    List<CharacterResponseDTO> getPersonInfo(String name);
}
