import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import GalleryListItem from './GalleryListItem';
import { useNavigate } from 'react-router-dom';

const StyledGalleryListDiv = styled.div`
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 4.5fr 4fr 1fr;
    place-items: center center;
    & > button {
        grid-column: span 3;
        width: 100%;
    }
`;

const GalleryList = () => {

    const navigate = useNavigate();
    const [galleryVoList, setGalleryVoList] = useState([]);

    //let arr = [];
    useEffect(() => {
        fetch('http://localhost:8888/app/api/gallery/list')
            .then(resp => resp.json())
            .then((data) => {
                console.log(data);
                setGalleryVoList(data.voList);
            });
    }, []); // 빈 배열을 넣어서 마운트될 때 한 번만 실행

    return (
        <>
            <StyledGalleryListDiv>
                {
                    galleryVoList.map(vo => { 
                        return <GalleryListItem key={vo.no} title={vo.title} fullPath={vo.fullPath} />
                    })
                }
                <button onClick={() => {
                    navigate('/gallery/write');
                }}>작성하기</button>
            </StyledGalleryListDiv>
        </>
    );
};

export default GalleryList;