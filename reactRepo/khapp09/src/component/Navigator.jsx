import React from 'react';
import styled from 'styled-components';

const StyledNaviDiv = styled.div`
    width: 100%;
    height: 58px;
    display: grid;
    grid-template-rows: 1fr;
    grid-auto-columns: 1fr;
    grid-auto-flow: column;
    place-items: center center;
    background-color: #333;
    color: #fff;
    font-size: 1.5;
    border-top: 3px solid #fff;
`;

const Navigator = () => {
    return (
        <StyledNaviDiv>
            <div>게시판</div>
            <div>공지사항</div>
            <div>갤러리</div>
            <div>게시판</div>
            <div>공지사항</div>
            <div>갤러리</div>
        </StyledNaviDiv>
    );
};

export default Navigator;