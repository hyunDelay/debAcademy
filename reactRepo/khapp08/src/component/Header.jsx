import React from 'react';
import { useKhMemory } from '../context/KhContext';

const Header = () => {

    // const obj = useKhMemory();
    // const cnt = obj.cnt;
    // const setCnt = obj.setCnt();

    const {cnt, plus} = useKhMemory();

    return (
        <>
            <h1>Header</h1>
            <h3>{cnt}</h3>
            <button onClick={plus}>카운트++</button>
        </>
    );
};

export default Header;