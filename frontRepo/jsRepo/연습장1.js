
console.log('로딩끝');

// function fff(){
//     return {
//         name: '피카츄',
//         hp: 100
//     };
// }
// const result = fff();
// console.log(result);

// function Pokemon(name, hp){
//     this.name = name;
//     this.hp = hp;
//     this.attack = function(){
//         console.log('백만볼트!!!');
//     }
// }

// const pika = new Pokemon('피카츄', 100);
// console.log(pika);
// pika.attack();


// ===========================================================

class Person {
    name = '홍길동';
    age = 20;
    sayHello(){
        console.log('안녕하세요');
    }
}

const p = new Person();
console.log(p);
p.sayHello();


// ===========================================================
function f01(){
    const cnt = 123;
    const obj = {};
    obj.printCnt = function(){
        console.log(cnt);
    }
    return obj;
}

const obj = f01();
// console.log(obj);
obj.printCnt();
// 누군가 기억하고있으면 없어질 변수도 사라지지 않는다.















