
import './App.css';

function KhHeader(){
  return <h1>헤더 ㅋㅋ</h1>
}
function KhNavi(){
  return <div className="naviWrap">
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
  </div>
}
function KhNaviItem(){
  return <span>공지사항</span>
}

function App() {
  return (
    <>

      <KhHeader />
      <KhNavi />
    </>
  );
}

export default App;
