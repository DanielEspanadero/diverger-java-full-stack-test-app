package com.diveger.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Starship {
    private String mglt;
    private String cargoCapacity;
    private String consumables;
    private String costInCredits;
    private String created;
    private String crew;
    private String edited;
    private String hyperdriveRating;
    private String length;
    private String manufacturer;
    private String maxAtmospheringSpeed;
    private String model;
    private String name;
    private String passengers;
    private List<Film> films;
    private List<People> pilots;
    private String starshipClass;
    private String url;
}
