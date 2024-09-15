import styled from "styled-components";

export const CharactersStyled = styled.div`
    position: fixed;
    background-image: url("/images/characters.png");
    background-size: cover;
    width: 100%;
    height: 100vh;
    .header{
        display: flex;
        justify-content: flex-start;
        align-items: center;
        width: 100%;
        height: 5rem;
        padding: 0 1rem;
        background-color: rgba(0, 0, 0, 0.5);
        .logo{
            height: 80%;
            margin-left: 1rem;
        }
    }
`;