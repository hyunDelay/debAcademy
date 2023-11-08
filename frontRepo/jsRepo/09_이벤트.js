
function f02(){
    console.log('f02 called...');
}

window.onload = () => {
    const btn03 = document.querySelector('#btn03');
    btn03.addEventListener('click', () => {
        console.log('f03 called...');
    });

    const btn01 = document.querySelector('#btn01');
    btn01.onclick = () => {
        console.log('f01 called...');
    };
};

function f04(){
    alert('a태그 클릭, 네이버로 이동');
}

function f05(){
    
    const memberIdInput = document.querySelector('input[name=memberId]');
    const memberPwdInput = document.querySelector('input[name=memberPwd]');
    const memberPwd2Input = document.querySelector('input[name=memberPwd2]');
    const memberNickInput = document.querySelector('input[name=memberNick]');
    
    if(memberIdInput.value.length < 1){
        alert('아이디를 입력해주세요.');
        memberIdInput.focus();
        return false; // 회원가입 ㄴㄴ 아이디 이상
    } 

    if(memberPwdInput.value.length < 1){
        alert('비밀번호를 입력해주세요.')
        memberPwdInput.focus();
        return false;
    }

    if(memberPwd2Input.value.length < 1){
        alert('비밀번호 확인을 입력해주세요.')
        memberPwd2Input.focus();
        return false;
    }

    if(memberNickInput.value.length < 1){
        alert('닉네임을 입력해주세요.')
        memberNickInput.focus();
        return false;
    }

    if(memberPwdInput.value !== memberPwd2Input.value){
        alert('비밀번호와 비밀번호 확인을 동일하게 작성하세요')
        return false;
    }

    return true; // 회원가입 진행
}