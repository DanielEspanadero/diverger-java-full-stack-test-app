import styled from "styled-components";

export const CharactersStyled = styled.div`
    background-image: url("/images/characters.png");
    background-size: cover;
    background-attachment: fixed;
    width: 100%;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 1rem;
    box-sizing: border-box;
    overflow: auto;
    .characters-header {
        display: flex;
        justify-content: flex-start;
        align-items: center;
        width: 100%;
        height: 5rem;
        padding: 0 1rem;
        background-color: rgba(0, 0, 0, 0.5);
        position: absolute;
        top: 0;
        left: 0;
        z-index: 10;

        .logo {
            height: 80%;
            margin-left: 1rem;
        }
    }

    .characters-title {
        color: #fff;
        margin: 6rem 0 2rem;
    }

    .search-input {
        display: block;
        margin-bottom: 10px;
        padding: 10px;
        font-size: 16px;
        width: 80%;
        max-width: 400px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .search-button {
        display: block;
        margin-bottom: 2rem;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        box-sizing: border-box;
    }

    .search-button:hover {
        background-color: #0056b3;
    }

    .characters-card-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
        width: 100%;
        max-width: 1200px;
        padding: 0 1rem;
        box-sizing: border-box;
        margin-top: 4rem;
    }

    .character-card {
        background: #fffe;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 250px;
        box-sizing: border-box;
    }

    .character-card h2 {
        margin-top: 0;
        color: #333;
    }

    .character-card p {
        margin: 5px 0;
        color: #555;
    }

    .character-card ul {
        padding-left: 20px;
        list-style-type: disc;
    }

    .character-card li {
        margin: 5px 0;
        color: #555;
    }

    .error-message {
        color: #f00;
        font-size: 1rem;
        background-color: #fffe;
        padding: 1rem;
    }

    .no-character {
        font-size: 2rem;
        background-color: #fffe;
        padding: 1rem;
    }
`;
