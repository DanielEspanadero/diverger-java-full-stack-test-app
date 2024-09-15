import { useState } from 'react';
import { CharactersStyled } from "./CharactersStyled.tsx";
import { BtnBack } from "../../components/btn-back/BtnBack.tsx";
import { Link } from "react-router-dom";
import axios from 'axios';
import { CharacterResponseDTO } from '../../interfaces/Character';

export const Characters = () => {
    const [name, setName] = useState('');
    const [characterData, setCharacterData] = useState<CharacterResponseDTO | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value);
    };

    const handleSearch = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/swapi-proxy/person-info?name=${encodeURIComponent(name)}`);
            setCharacterData(response.data);
            setError(null);
        } catch (err) {
            setError('Error al obtener la información del personaje' + err);
            setCharacterData(null);
        }
    };

    return (
        <CharactersStyled>
            <header className="header">
                <Link
                    style={{textDecoration: 'none'}}
                    to="/"
                >
                    <BtnBack />
                </Link>
                <img className="logo" src="/images/Star_Wars_Logo..png" alt="logo sw" />
            </header>
            <h1>Characters</h1>

            <input
                type="text"
                value={name}
                onChange={handleInputChange}
                placeholder="Enter character name"
            />

            <button onClick={handleSearch}>Search</button>

            {error && <p>{error}</p>}
            {characterData && (
                <div className="character-card">
                    <h2>{characterData.name}</h2>
                    <p>Birth Year: {characterData.birth_year}</p>
                    <p>Gender: {characterData.gender}</p>
                    <p>Planet: {characterData.planet_name}</p>
                    <p>Fastest Vehicle Driven: {characterData.fastest_vehicle_driven}</p>
                    <h3>Films</h3>
                    <ul>
                        {characterData.films.map((film, index) => (
                            <li key={index}>{film.title}</li>
                        ))}
                    </ul>
                </div>
            )}
        </CharactersStyled>
    );
}
