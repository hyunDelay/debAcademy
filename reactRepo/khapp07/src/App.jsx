import { useEffect, useState, useRef } from 'react';
import './App.css';

function App() {

  const x = useRef();
  console.log(x);

  useEffect( () => {
    const timer = setInterval(() => {
      console.log('안녕하세요');
    }, 3000);
    return () => {
      clearInterval(timer);
    }
  } );
  
  const [data, setDate] = useState(1);

  function f01(){
    setDate(data + 1);
  }
  function printSomething() {
    console.log(x);
    xy(x);
  }
  
  const xy = useEffect((param) => {
    const f = document.querySelector('#f');
    console.log(param + ' 확인');
  }); 

  return (
    <>
      <h1 ref={x}>안녕</h1>
      <button onClick={printSomething}>x 출력하기</button>
      <div id='f'></div>
      <hr />
      <button onClick={f01}>플러스</button>
      <h2>{data}</h2>
    </>
  );
}

export default App;
