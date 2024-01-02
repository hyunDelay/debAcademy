import React from 'react';
import { useNavigate } from 'react-router-dom'
import styled from 'styled-components';

const StyledHeaderDiv = styled.div`
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-rows: 1fr;

    & > .logoArea {
        background: url(https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png) no-repeat center;
        cursor: pointer;
    }
`;
const StyledLoginAreaDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form {
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: repeat(3 , 1fr);
        place-items: center center;
        box-sizing: border-box;
        & > input {
            width: 100%;
            height: 100%;
        box-sizing: border-box;
        }
        & > input:nth-child(1),
        & > input:nth-child(2) {
            grid-column: span 2;
        }
    }
`;

const Header = () => {
    
    const navigate = useNavigate();
    const handleClickJoin = () => {
        console.log('확인');
        navigate('/member/join');
    }
    const handleClickHome = () => {
        navigate('/');
    }

    return (
        <StyledHeaderDiv>
            <div></div>
            <div className='logoArea' onClick={ handleClickHome }></div>
            <StyledLoginAreaDiv>
                <form action=''>
                    <input type="text" name='id' placeholder='아이디'/>
                    <input type="password" name='pwd' placeholder='패스워드'/>
                    <input type="button" value="회원가입" onClick={ handleClickJoin }/>
                    <input type="submit" value="로그인" />
                </form>
            </StyledLoginAreaDiv>
        </StyledHeaderDiv>
    );
};

export default Header;