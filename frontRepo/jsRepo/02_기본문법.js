

function f01(){
    console.log(x);
    let x = 10;
}
// f01();

function f02(){
    const x = '10';
    console.log(typeof(parseInt(x)));

    if(10 !== '10'){
        console.log('if');
    } else {
        console.log('else');
    }
}
f02();

