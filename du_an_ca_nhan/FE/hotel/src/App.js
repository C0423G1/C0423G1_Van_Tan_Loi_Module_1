import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
 import KitchenSinkExample from "./components/home/Card";


function App() {
  return (
      <>
        <>
          <Router>
            <Routes>
              <Route path="/" element={<KitchenSinkExample/>}/>
            </Routes>
          </Router>
        </>
      </>
  );
}

export default App;
