import {HomeStyled} from "./HomeStyled.tsx";
import {Btn01} from "../../components/btn01/Btn01.tsx";
import {Link} from "react-router-dom";

export const Home = () => {
    return (
        <HomeStyled>
            <img className="logo" src="/images/Star_Wars_Logo..png" alt="star wars logo" />
            <Link
                style={{textDecoration: 'none'}}
                to="/characters"
            >
            <Btn01 />
            </Link>
        </HomeStyled>
    );
}