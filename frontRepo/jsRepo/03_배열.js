function f01(){
    arr01 = new Array();
    arr02 = new Array(3);
    arr03 = new Array('핸드폰', '페브리즈', 100, true, null);
    arr04 = ['핸드폰', '페브리즈', 100, true, null];
    arr05 = [];
    arr05[0] = '하나';
    arr05[1] = '둘';
    arr05[7] = '셋';

    console.log(arr01);
    console.log(arr02);
    console.log(arr03);
    console.log(arr04);
    console.log(arr05);
}

// f01();

function f02(){

    const arr = ['사과', '귤', '파인애플', '골드키위', '파인애플'];
    const arr2 = ['사람', '동물', '갑각류'];

    // indexOf()   배열에서 요소가 위치한 인덱스를 반환한다.
    const x = arr.indexOf('파인애플');
    console.log(x);
    const lastIndexOf = arr.lastIndexOf('파인애플');
    console.log(lastIndexOf);

    // concat()    여러 개의 배열을 결합하여 새로운 배열을 리턴한다.
    const concat = arr.concat(arr2);
    console.log(concat);

    // join()      배열의 요소들을 결합해서 하나의 문자열로 반환한다.
    const join = arr.join();
    console.log(join);

    // reverse()   원본 배열의 순서를 뒤집는 메소드이다.
    const reverse = arr.reverse();
    console.log(reverse);

    // sort()      배열을 오름차순(문자기준)으로 정렬하는 메소드이다.
    const sort = arr.sort();
    console.log(sort);

    // push()      배열의 맨 뒤에 요소를 추가한다. 추가된 인덱스가 반환되는거같음
    const push = arr.push('요소', '요소');
    console.log(push);
    console.log(arr);

    // pop()       배열의 맨 뒤에 요소를 반환 후 제거한다.
    const pop = arr.pop();
    console.log(pop);
    console.log(arr);

    // shift()     배열의 맨 앞의 요소를 반환 후 제거한다.
    const shift = arr.shift();
    console.log(shift);
    console.log(arr);

    // unshift()   배열의 맨 앞의 요소를 추가한다. 인덱스로 반환되는거같다
    const unshift = arr.unshift('추가요소');
    console.log(unshift);
    console.log(arr);

    // slice()     배열의 요소를 뽑아내는 메소드이다.
    const slice = arr.slice(1, 5);
    console.log(slice);

    // splice()    배열의 특정 인덱스 위치에 요소 제거 및 추가하는 메소드이다.
    const splice = arr.splice(1, 3, "March");
    console.log(splice);

    console.log(arr);

}

f02();