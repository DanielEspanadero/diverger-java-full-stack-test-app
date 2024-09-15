package com.diveger.backend.application.mappers;

import com.diveger.backend.application.dto.CharacterResponseDTO;
import com.diveger.backend.application.dto.FilmResponseDTO;
import com.diveger.backend.domain.People;

import java.util.List;

public class PeopleMapper {

    public CharacterResponseDTO peopleToCharacterResponse(People people) {
        if (people == null) {
            return null;
        }

        CharacterResponseDTO dto = new CharacterResponseDTO();
        dto.setName(people.getName());
        dto.setGender(people.getGender());
        dto.setPlanetName(people.getPlanetName());
        dto.setFastestVehicleDriven(people.getFastestVehicleDriven());
        dto.setBirthYear(people.getBirthYear());

        List<FilmResponseDTO> filmDTOs = people.getFilms().stream()
                .map(film -> new FilmResponseDTO(film.getTitle(), film.getReleaseDate()))
                .toList();

        dto.setFilms(filmDTOs);

        return dto;
    }
}
