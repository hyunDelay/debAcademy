import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const StyledBoardListDiv = styled.div`
    width: 100%;
    height: 100%;
    padding: 20px;
    box-sizing: border-box;
    & table {
        width: 100%;
        border-top: 1px solid #333;
        & tr th,
        & tr td {
            border-bottom: 1px solid #ddd;
        }
    }
    & button {
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 8px 15px;
        border-radius: 30px;
        background-color: #333;
        margin: 40px auto;
        border: none;
        color: #fff;
        cursor: pointer;
    }
`;

const BoardList = () => {

    console.log('컴포넌트 렌더링');

    const navigate = useNavigate();

    const [boardVoList, setBoardVoList] = useState([]);
    const loadBoardVoList = () => {
        fetch('http://localhost:8888/app/api/board/list')
        .then(resp => resp.json())
        .then((data) => {
            setBoardVoList(data);
        });
    };
    
    useEffect(() => {
        loadBoardVoList(); // 마운트될 때 한 번만 호출
    }, []); // 빈 배열을 넣어 마운트될 때만 실행 (의존성 배열)
    

    return (
        <StyledBoardListDiv>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일시</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardVoList.length === 0 
                        ?
                        <tr>
                            <td colSpan={5}>로딩중...</td>
                        </tr>
                        : 
                        boardVoList.map((vo) => (
                            <tr key={vo.no}>
                                <td>{vo.no}</td>
                                <td>{vo.title}</td>
                                <td>{vo.writer}</td>
                                <td>{vo.hit}</td>
                                <td>{vo.enrollDate}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>

            <button onClick={() => {
                    navigate('/board/write');
            }}>게시글 작성하기</button>
            
        </StyledBoardListDiv>
    );
};

export default BoardList;