package com.diveger.backend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponseDTO {
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
}
