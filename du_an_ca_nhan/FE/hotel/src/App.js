import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Index from "./components/home/Index";
import List from "./components/home/List";
import HouseDetails from "./components/home/HouseDetail";
import Login from "./components/home/Header/Login";
import A from "./components/home/demo";

function App() {
    return (
        <>
            <>
                <Router>
                    <Routes>
                        <Route path="/" element={<Index/>}/>
                        <Route path="/list" element={<List/>}/>
                        <Route path="/detail/:id" element={<HouseDetails/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/check" element={<A/>}/>
                    </Routes>
                </Router>
            </>
        </>
    );
}

export default App;
