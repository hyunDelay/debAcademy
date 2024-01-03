import React, { useState } from 'react';
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
    
    let isFetching = false;
    const [loginMemberVo, setLoginMemberVo] = useState(null); // 로그인멤버 객체 준비
    // navi 객체 준비
    const navigate = useNavigate();
    // 이 함수를 호출하면 브라우저의 주소가 변경
    const handleClickJoin = () => {
        navigate('/member/join');
    }
    const handleClickHome = () => {
        navigate('/');
    }

    // 랜더링을 위한 vo객체 생성
    const [vo, setVo] = useState({
        id: '',
        pwd: ''
    });
    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setVo({
            ...vo,
            [name]: value
        });
    };

    // fetch로 요청보내기
    const handleClickLogin = (e) => {
        e.preventDefault();

        // 이미 작업중일 때 검증
        if(isFetching){
            return;
        }
        // 작업 시작
        isFetching = true;
        const htt = 'http://127.0.0.1:8888';
        fetch(htt + '/app/rest/member/login', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(vo)
        })
        .then((resp) => {
            if(!resp.ok){
                throw new Error('회원가입 fetch 실패');
            }
            return resp.json()
        })
        .then((data) => {
            if(data.msg === 'good'){
                alert('로그인 성공!');
                setLoginMemberVo(data.loginMember);
            } else {
                alert('로그인 실패');
            }
        })
        .catch((e) => {
            console.log(e);
            alert('로그인 실패');
        })
        .finally(() => {
            console.log('로그인 fetch 끝');
            isFetching = false;
        })
        ;
    }

    return (
        <StyledHeaderDiv>
            <div></div>
            <div className='logoArea' onClick={ handleClickHome }></div>
            {
                loginMemberVo === null 
                ? 
                <StyledLoginAreaDiv>
                    <form onSubmit={handleClickLogin}>
                        <input type="text" name='id' placeholder='아이디' onChange={handleInputChange}/>
                        <input type="password" name='pwd' placeholder='패스워드' onChange={handleInputChange}/>
                        <input type="button" value="회원가입" onClick={ handleClickJoin }/>
                        <input type="submit" value="로그인" />
                    </form>
                </StyledLoginAreaDiv>
                : 
                <div>
                    <h3>{loginMemberVo.nick}님 환영합니다.</h3>
                    <button>로그아웃</button>
                </div>
            }
            
            
        </StyledHeaderDiv>
    );
};

export default Header;