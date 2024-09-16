import {Btn01Styled} from "./Btn01Styled.tsx";

export const Btn01 = () => {

    return (
        <Btn01Styled>
                <button type="button" className="btn">
                    <strong>Select Characters</strong>
                    <div id="container-stars">
                        <div id="stars"></div>
                    </div>

                    <div id="glow">
                        <div className="circle"></div>
                        <div className="circle"></div>
                    </div>
                </button>
        </Btn01Styled>
    );
}