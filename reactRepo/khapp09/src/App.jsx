import './App.css';
import Layout from './component/Layout';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Layout color='#f5f5f5' atk='33'/>
    </BrowserRouter>
  );
}

export default App;
