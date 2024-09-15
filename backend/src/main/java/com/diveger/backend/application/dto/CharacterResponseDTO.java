package com.diveger.backend.application.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"name", "birth_year", "gender", "planet_name", "fastest_vehicle_driven", "films"})
public class CharacterResponseDTO {
    private String name;
    private String birthYear;
    private String gender;
    private String planetName;
    private String fastestVehicleDriven;
    private List<FilmResponseDTO> films;
}
