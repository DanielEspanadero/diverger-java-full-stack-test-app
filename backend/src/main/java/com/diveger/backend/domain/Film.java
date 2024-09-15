package com.diveger.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Film {
    private List<People> characters;
    private String created;
    private String director;
    private String edited;
    private int episodeId;
    private String openingCrawl;
    private List<Planet> planets;
    private String producer;
    private String releaseDate;
    private List<Specie> species;
    private List<Starship> starships;
    private String title;
    private String url;
    private List<Vehicle> vehicles;
}
