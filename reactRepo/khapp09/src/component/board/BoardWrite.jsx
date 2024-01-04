import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledBoardWriteDiv = styled.div`
    width: 100%;
    height: 100%;
    & form {
        display: flex;
        width: 100%;
        height: 100%;
        justify-content: center;
        align-items: center;
        & table {

        }
    }
`;

const BoardWrite = () => {

    const [boardVo, setBoardVo] = useState({
        title: '',
        content: '',
    });
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        fetch('http://localhost:8888/app/api/board/write', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(boardVo)
        })
        .then(resp => resp.json())
        .then((data) => {
            console.log(1);
            if(data.msg === 'good'){
                alert('게시글 작성 성공');
                navigate('/board/list');
            } else {
                alert('게시글 작성 실패');
            }
        })
        ;
    };
        
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setBoardVo({
            ...boardVo,
            [name]: value
        });
    };

    return (
        <StyledBoardWriteDiv>
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>제목</td>
                            <td><input type='text' name='title' onChange={handleInputChange} /></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name='content' onChange={handleInputChange}></textarea></td>
                        </tr>
                        <tr>
                            <td colSpan={2}><button>작성하기</button></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </StyledBoardWriteDiv>
    );
};

export default BoardWrite;