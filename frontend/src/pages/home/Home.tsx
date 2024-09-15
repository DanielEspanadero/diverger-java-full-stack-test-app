import {HomeStyled} from "./HomeStyled.tsx";
import {Btn01} from "../../components/btn01/Btn01.tsx";

export const Home = () => {
    return (
        <HomeStyled>
            <img className="logo" src="/images/Star_Wars_Logo..png" alt="star wars logo" />
            <Btn01 />
        </HomeStyled>
    );
}