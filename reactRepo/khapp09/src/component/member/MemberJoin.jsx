import React, { useState } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const StyledJoinDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form {
        width: 100%;
        height: 100%;
        margin: auto;
        border: 5px solid #333;
        & > table {
            table-layout: fixed;
            width: 100%;
            height: 100%;
        }
    }
`;

const MemberJoin = () => {

    const navigate = useNavigate();

    let isFetching = false;
    const [vo, setVo] = useState({
        id: '',
        pwd: '',
        nick: ''
    });

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setVo({
            ...vo,
            [name]: value,
        });
    }

    const handleJoinSubmit = (e) => {
        e.preventDefault();

        // 이미 작업중일 때 검증
        if(isFetching){
            return;
        }

        // 작업 시작
        isFetching = true;


        fetch('http://127.0.0.1:8888/app/rest/member/join', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(vo)
        })
        .then( resp => {
            if(!resp.ok){
                throw new Error('회원가입 fetch 실패');
            }
            return resp.json();
        } )
        .then( data => {
            if(data.msg === 'good'){
                alert('회원가입이 완료되었습니다.');
                navigate("/");
            } else {
                alert('회원가입이 실패하였습니다.');
                navigate("/");
            }
        } )
        .catch((e) => {
            console.log(e);
            alert('회원가입 실패');
        })
        .finally(() => {
            isFetching = false;
        })
        ;
    }

    return (
        <StyledJoinDiv>
            <form onSubmit={ handleJoinSubmit }>
                <table>
                    <tbody>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name='id' onChange={handleInputChange}/></td>
                        </tr>
                        <tr>
                            <td>패스워드</td>
                            <td><input type="password" name='pwd' onChange={handleInputChange}/></td>
                        </tr>
                        <tr>
                            <td>닉네임</td>
                            <td><input type="text" name='nick' onChange={handleInputChange}/></td>
                        </tr>
                        <tr>
                            <td><input type="reset" /></td>
                            <td><input type="submit" value="회원가입"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </StyledJoinDiv>
    );
};

export default MemberJoin;