package com.diveger.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class People {
    private String birthYear;
    private String eyeColor;
    private List<Film> films;
    private String gender;
    private String hairColor;
    private String height;
    private String planetName;
    private String homeworld;
    private String mass;
    private String name;
    private String skinColor;
    private String created;
    private String edited;
    private List<Specie> species;
    private List<Starship> starships;
    private String url;
    private List<Vehicle> vehicles;
    private String fastestVehicleDriven;
}
