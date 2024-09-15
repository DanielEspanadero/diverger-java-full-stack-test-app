package com.diveger.backend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeopleDTO {
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    private List<String> films;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    private String name;
    @JsonProperty("skin_color")
    private String skinColor;
    private String created;
    private String edited;
    private List<String> species;
    private List<String> starships;
    private String url;
    private List<String> vehicles;
}
