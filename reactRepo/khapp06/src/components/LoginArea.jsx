import React from 'react';
import styled from 'styled-components';

const StyledLoginAreaDiv = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    gap: 5px;
    width: 200px;
    position: absolute;
    top: 50%;
    right: 10px;
    transform: translateY(-50%);
    
    & form {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        gap: 5px;

        & input {
            border: 1px solid #ddd;
            background-color: #fff;
            box-sizing: border-box;
            padding: 6px 15px;
            font-size: 14px;
        }
        & input:focus {
            outline: none;
            border-color: #333;
        }
        & button {
            width: calc(50% - 5px);
            padding: 0 15px;
            height: 30px;
            box-sizing: border-box;
            border: none;
            background-color: #333;
            color: #fff;
            cursor: pointer;
        }
    }

    
`;

const LoginArea = () => {
    return (
        <StyledLoginAreaDiv>
            <form action="127.0.0.1:8888/app/member/login" method='post'>
                <input type="text" name="id" placeholder="아이디를 입력해주세요." />
                <input type="password" name="pwd" placeholder="비밀번호를 입력해주세요." />
                <button>로그인</button>
                <button type="button">회원가입</button>
            </form>
        </StyledLoginAreaDiv>
    );
};

export default LoginArea;