
function f01(){
    const result = document.querySelector('#result');
    const x = document.createTextNode('글자노드 생성');
    
    result.appendChild(x);
}

function f02(){
    const result = document.querySelector('#result');
    const x = document.createElement('h1');
    const t = document.createTextNode('JS로 만든 텍스트노드');
    x.appendChild(t);

    result.appendChild(x);
}

function f03(){
    const elemArr = document.querySelectorAll('h1');
    elemArr[0].remove();
}