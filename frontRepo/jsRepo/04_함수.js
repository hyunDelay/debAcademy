
const testBtn = document.querySelector('#testBtn');

// function
// console.log(testBtn);
// testBtn.addEventListener('click', f01);

// function f01(){
//     alert('f01 호출됨');
// }

// 익명함수
// testBtn.addEventListener('click', function(){
//     alert('f01 호출됨!');
// });

// 화살표함수 (arrow function)
testBtn.addEventListener('click', () => {
    alert('화살표 함수 실행');
});

// 자동실행 함수
// (function hello(){
//     alert('hello!');
// })();

// 전달받은 모든 값들을 더하는 함수
function testFunc(){

    let temp = 0;
    for(let i = 0; i < arguments.length; ++i){
        temp += arguments[i];
    }
    alert(temp);

}

function testReturn(){
    const fff = (str) => {alert(str);};
    return fff;
}

function myFunc(){
    const x = testReturn();
    console.log(x);
    x('ㅋㅋㅋㅋㅋ');
}