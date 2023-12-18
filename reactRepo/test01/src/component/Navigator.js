
import { NavLink } from "react-router-dom";

export default function Navigator(){
    return (<>
        <nav>
            <NavLink to="/movie/list">List</NavLink>
            <NavLink to="/movie/add">Add New Movie</NavLink>
        </nav>
    </>);
}