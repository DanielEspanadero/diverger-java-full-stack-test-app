import { Route, Routes, BrowserRouter as Router, Navigate } from "react-router-dom";
import { Home } from "../pages/home/Home";
import {Characters} from "../pages/characters/Characters.tsx";

export const MainRoutes = () => {
    return (
        <Router>
            {/*<Navbar />*/}
            <div className="container">
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/characters" element={<Characters />} />
                    <Route path="*" element={<Navigate to="/" replace />} />
                    {/* <Route path="*" element={<Error404 />} /> */}
                </Routes>
            </div>
            {/*<Footer />*/}
        </Router>
    );
};