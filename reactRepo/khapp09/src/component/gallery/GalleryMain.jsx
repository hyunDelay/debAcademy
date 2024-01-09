import React from 'react';
import { Routes, Route } from 'react-router-dom';
import GalleryWrite from './GalleryWrite';
import GalleryList from './GalleryList';

const GalleryMain = () => {
    return (
        <Routes>
            <Route path='write' element={<GalleryWrite />} />
            <Route path='list' element={<GalleryList />} />
        </Routes>
    );
};

export default GalleryMain;