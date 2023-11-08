
function f01(){
    // open
    // window.open('https://www.naver.com' , 'abc', 'width=500, height=500');
    // 네임값이 같으면 기존 열린것에 열린다.

    // setTimeout
    // window.setTimeout(동작(함수), 시간);
    // window.setTimeout(() => {
    //     console.log('3초');
    // }, 3000);

    // setInterval
    // window.setInterval(함수, 시간);
    // window.setInterval(() => {
    //     console.log('인터벌');
    // }, 3000);

    const abcTab = window.open('https://www.naver.com', 'abc', 'width=500, height=500, left=300, top=300');
    const closeTimer = window.setTimeout(() => {
        abcTab.close();
    }, 3000);

    clearTimeout(closeTimer);
    // clearInterval(타이머);

    // 뒤에가서 실행되는 함수 = 콜백함수
}

function f02(){
    console.log(location);

    // location.href = 'https://www.naver.com';

    location.reload();

}

function f03(){
    console.log(history);
    history.forward();
    history.back(); // 뒤로가기
    history.go(-2); // 앞으로가기
}

function f04(){
    console.log(navigator);
    console.log(screen);
}