export interface FilmResponseDTO {
    title: string;
}

export interface CharacterResponseDTO {
    name: string;
    birth_year: string;
    gender: string;
    planet_name: string;
    fastest_vehicle_driven: string;
    films: FilmResponseDTO[];
}
