export interface FilmResponse {
    name: string;
}

export interface CharacterResponse {
    name: string;
    birth_year: string;
    gender: string;
    planet_name: string;
    fastest_vehicle_driven: string;
    films: FilmResponse[];
}
