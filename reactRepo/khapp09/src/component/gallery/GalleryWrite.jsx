import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledGalleryWriteDiv = styled.div`
    width: 100%;
    height: 100%;
    padding: 30px;
    box-sizing: border-box;
    & form {
        display: flex;
        flex-direction: column;
        gap: 10px;
        width: 100%;
        height: 100%;
        & input {
            border: 1px solid #ddd;
            padding: 6px 10px;
            &[type=submit] {
                cursor: pointer;
            }
        }
    }
`;

const GalleryWrite = () => {

    const [title, setTitle] = useState();
    const [fileObj, setFileObj] = useState();

    const handleChangeTitle = (e) => {
        setTitle(e.target.value);
    }
    const handleChangeFile = (e) => {
        setFileObj(e.target.files[0]);
    }
    
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const fd = new FormData();
        fd.append('title', title);
        fd.append('f', fileObj);
        fd.append('writerNo', 1); // sessionStorege.getItem('loginMemberVo')

        fetch('http://localhost:8888/app/api/gallery', {
            method: 'post',
            body: fd,
        })
        .then(resp => resp.json())
        .then(data => {
            if(data.msg === 'good'){
                alert('갤러리 작성 완료');
                navigate('/gallery/list');
            } else {
                alert('갤러리 작성 실패')
            }
        })
        ;
    }

    return (
        <StyledGalleryWriteDiv>
            <form onSubmit={handleSubmit}>
                <input type="text" name='title' placeholder='제목을 작성하세요' onChange={handleChangeTitle}/>
                <input type="file" name='f' onChange={handleChangeFile}/>
                <input type="submit" value='작성하기' />
            </form>
        </StyledGalleryWriteDiv>
    );
};

export default GalleryWrite;