package com.diveger.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Specie {
    private String averageHeight;
    private String averageLifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    private String eyeColors;
    private String hairColors;
    private String homeworld;
    private String language;
    private String name;
    private List<People> people;
    private List<Film> films;
    private String skinColors;
    private String url;
}
