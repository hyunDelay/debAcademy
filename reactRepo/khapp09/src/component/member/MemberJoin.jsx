import React from 'react';
import styled from 'styled-components';

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

    const handleJoinSubmit = (e) => {
        e.preventDefault();

        const vo = {};
        // vo.id = document.querySelector('input[name=id]').value;
        // vo.pwd = document.querySelector('input[name=pwd]').value;
        // vo.nick = document.querySelector('input[name=nick]').value;
        vo.id = 'user01023';
        vo.pwd = '1234';
        vo.nick = 'nick';

        fetch('http://127.0.0.1:8888/app/rest/member/join', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(vo)
        })
        .then( resp => resp.json() )
        .then( data => {
            console.log('서버한테 응답받은 data :::');
            console.log(data);
        } )
        ;
    }

    return (
        <StyledJoinDiv>
            <form onSubmit={ handleJoinSubmit }>
                <table>
                    <tbody>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name='id'/></td>
                        </tr>
                        <tr>
                            <td>패스워드</td>
                            <td><input type="password" name='pwd'/></td>
                        </tr>
                        <tr>
                            <td>닉네임</td>
                            <td><input type="text" name='nick'/></td>
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