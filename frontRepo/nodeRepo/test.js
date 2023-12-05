// const x = {
//     name: '심원용',
//     age: '20'
// };
/* 생성자 함수 */
// function Person(x, y){
//     this.name = x;
//     this.age = y;
//     this.hello = function(){
//         console.log(this.name + " : 헬로^^");
//     };
// }
// Person.prototype.hello = function(){
//     console.log('헬로~~~ ( 부모객체 ) ');
// }

/* 클래스 */
class Person {

    constructor(x, y){
        this.name = x;
        this.age = y;
    }

    hello(){
        console.log("헿ㄹ로 (생성자 밖에있는 함수)");
    }

}

class Programmer extends Person {
    constructor(x, y, z){
        super(x, y);
        this.lang = z;
    }
    coding(){
        console.log('coding 함수');
    }
}

const p1 = new Person('심원용', 20);
console.log(p1);
p1.hello();
p2 = new Programmer('심원용', 30, 'JAVA');
console.log(p2);
p2.hello();
p2.coding();

const result = Object.getOwnPropertyNames(p2.__proto__.__proto__);
console.log(result);
console.log(p2.__proto__.__proto__);