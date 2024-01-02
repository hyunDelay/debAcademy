import React from 'react';
import styled from 'styled-components';

const StyledAsideDiv = styled.div`
    width: 100%;
    height: 100%;
    background-image: url(${ (props) => {return props.urlstr} });
    // 이 props는 StyledAsideDiv가 만들어질때 넘겨받은 props
    background-repeat: no-repeat;
    background-position: 28% center;
    background-size: cover;
    cursor: pointer;
`;

const Aside = ( props ) => { // 이 props는 Main에서 받아온 props

    const handleClick = () => {
        window.open('http://www.naver.com');
    }

    return (
        <StyledAsideDiv urlstr={props.x} onClick={handleClick}>
            광고
        </StyledAsideDiv>
    );

};

export default Aside;