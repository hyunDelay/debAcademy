
function f01(){

    const x = {
        name: '피카츄',
        hp: 100,
        atk: 30,
        skill: () => {
            console.log('몸통박치기');
        }
    };

    console.log(x);
    console.log(x.name);
    console.log(x.hp);
    console.log(x.atk);
    console.log(x.skill());

}

// f01();

function f02(){
    const x = {};
    // x.name = '사과';
    // x.color = '빨간색';
    // x.price = 50000;

    // console.log(x);
    // console.log(x.name);
    // console.log(x.price);

    x["name"] = '사과';
    x["price"] = 50000;

    console.log(x['name']);
    console.log(x['price']);

}

// f02();

function f03(){

    const x = {
        name: '아이폰13',
        price: 1000000,
        brand: '애플',
        color: 'green'
    };

    for(temp in x){
        console.log(temp);
        console.log(x[temp]);
    }

}

// f03();

function f04(){

    const x = {
        name: '피카츄',
        hp: 100
    };

    console.log(x);

    delete(x.hp);

    console.log(x);

}

// f04();

function f05(){
    const student01 = {name: '1지연', score: 100};
    const student02 = {name: '2지연', score: 50};
    const student03 = {name: '3지연', score: 90};
    const student04 = {name: '4지연', score: 80};
    const student05 = {name: '5지연', score: 77};

    const stdArr = [student01, student02, student03];

    stdArr.push(student04);
    stdArr.push(student05);

    console.log(stdArr);

    // for(let i = 0; i < stdArr.length; ++i){
    //     console.log(stdArr[i].name);
    // }

    for(idx in stdArr){
        console.log(stdArr[idx].name);
    }

}

f05();
