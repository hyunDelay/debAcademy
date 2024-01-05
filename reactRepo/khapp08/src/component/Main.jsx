import React from 'react';
import { useKhMemory } from '../context/KhContext';

const Main = () => {

    const {cnt, plus} = useKhMemory();

    return (
        <>
            <h1>Main</h1>
            <h3>{cnt}</h3>
            <button onClick={plus}>플러스</button>
        </>
    );
};

export default Main;