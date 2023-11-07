import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Index from "./components/home/Index";
import List from "./components/home/List";
import HouseDetails from "./components/home/HouseDetail";
import LoginModal from "./components/home/Login/ModalLogin";

function App() {
    return (
        <>
            <>
                <Router>
                    <Routes>
                        <Route path="/" element={<Index/>}/>
                        <Route path="/list" element={<List/>}/>
                        <Route path="/detail" element={<HouseDetails/>}/>
                        <Route path="/login" element={<LoginModal/>}/>
                    </Routes>
                </Router>
            </>
        </>
    );
}

export default App;
