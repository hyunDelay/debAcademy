import React from 'react';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import BoardWrite from './BoardWrite';
import BoardDetail from './BoardDetail';
import BoardEdit from './BoardEdit';

const BoardMain = () => {
    return (
        <Routes>
            <Route path='list' element={<BoardList />}></Route>
            <Route path='write' element={<BoardWrite />}></Route>
            <Route path='detail' element={<BoardDetail />}></Route>
            <Route path='edit' element={<BoardEdit />}></Route>
        </Routes>
    );
};

export default BoardMain;