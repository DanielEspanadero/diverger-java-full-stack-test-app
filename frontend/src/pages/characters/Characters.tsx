import { useState } from 'react';
import { CharactersStyled } from "./CharactersStyled.tsx";
import { BtnBack } from "../../components/btn-back/BtnBack.tsx";
import { Link } from "react-router-dom";
import axios from 'axios';
import { CharacterResponse } from '../../interfaces/Character'; // Ajusta la ruta según corresponda

export const Characters = () => {
    const [name, setName] = useState('');
    const [charactersData, setCharactersData] = useState<CharacterResponse[]>([]);
    const [error, setError] = useState<string | null>(null);

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value);
    };

    const handleSearch = async () => {
        try {
            const response = await axios.get<CharacterResponse[]>(`http://localhost:8080/swapi-proxy/person-info?name=${encodeURIComponent(name)}`);
            setCharactersData(response.data);
            setError(null);
        } catch (err) {
            console.error(err);
            setError('Error getting character information');
            setCharactersData([]);
        }
    };

    return (
        <CharactersStyled>
            <header className="characters-header">
                <Link
                    style={{ textDecoration: 'none' }}
                    to="/"
                >
                    <BtnBack />
                </Link>
                <img className="logo" src="/images/Star_Wars_Logo..png" alt="logo sw" />
            </header>
            <h1 className="characters-title">CHARACTERS</h1>

            <input
                type="text"
                value={name}
                onChange={handleInputChange}
                placeholder="Enter character name"
                className="search-input"
            />

            <button onClick={handleSearch} className="search-button">Search</button>

            {error && <p className="error-message">{error}</p>}
            <div className="characters-card-container">
                {charactersData.length > 0 ? (
                    charactersData.map((character, index) => (
                        <div className="character-card" key={index}>
                            <h2>{character.name}</h2>
                            <p><strong>Birth Year:</strong> {character.birth_year}</p>
                            <p><strong>Gender:</strong> {character.gender}</p>
                            <p><strong>Planet:</strong> {character.planet_name}</p>
                            <p><strong>Fastest Vehicle Driven:</strong> {character.fastest_vehicle_driven}</p>
                            <h3>Films</h3>
                            <ul>
                                {character.films.map((film, filmIndex) => (
                                    <li key={filmIndex}>{film.name}</li>
                                ))}
                            </ul>
                        </div>
                    ))
                ) : (
                    <p className="no-character">No characters found.</p>
                )}
            </div>
        </CharactersStyled>
    );
}
