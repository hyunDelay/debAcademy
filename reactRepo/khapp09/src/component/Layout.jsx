import React from 'react';
import styled from 'styled-components';
import Header from './Header';
import Main from './Main';
import Footer from './Footer';
import Navigator from './Navigator';

const StyledLayoutDiv = styled.div`
    width: 100%;
    height: 100vh;
    background-color: ${ (props) => {return props.abc ? props.abc : 'black'}};
    display: grid;
    grid-template-rows: 1.5fr 1fr 6fr 1.5fr;
    grid-template-columns: 1fr;
    place-items: center center;
`;

const Layout = ({color, atk}) => {
    
    return (
        <StyledLayoutDiv abc={color}>
            <Header />
            <Navigator />
            <Main />
            <Footer />
        </StyledLayoutDiv>
    );
};

export default Layout;