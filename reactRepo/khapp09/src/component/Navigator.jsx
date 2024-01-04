import React from 'react';
import { NavLink } from 'react-router-dom';
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
    & a {
        color: #fff;
        display: flex;
        padding: 6px 15px;
        text-decoration: none;
        &:hover {
            background-color: #fff;
            color: #333;
        }
    }
    & a.active {
        background-color: #fff;
        color: #333;
    }
`;

const Navigator = () => {
    return (
        <StyledNaviDiv>
            <div><NavLink to='/board/list'>게시판</NavLink></div>
            <div><NavLink to='/notice/list'>공지사항</NavLink></div>
            <div><NavLink to='/gallery/list'>갤러리</NavLink></div>
        </StyledNaviDiv>
    );
};

export default Navigator;