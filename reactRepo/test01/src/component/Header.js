import {BrowserRouter, Routes, Route} from "react-router-dom";
import MovieList from "./MovieList";
import MovieAdd from "./MovieAdd";
import Navigator from "./Navigator";

export default function Header(){
    return(<>
        <BrowserRouter>
            <Navigator/>
            <Routes>
                <Route path="/movie/list" element={<MovieList/>}/>
                <Route path="/movie/add" element={<MovieAdd/>}/>
            </Routes>
        </BrowserRouter>
    </>);
}