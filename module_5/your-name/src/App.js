// import './App.css';
// import RauCu from "./component/rauCu/RauCu";
// import React from "react";
// import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
//
// function App() {
//     return (
//         <>
//             <Router>
//                 <Routes>
//                     <Route path="/" element={<RauCu />} />
//                 </Routes>
//             </Router>
//         </>
//     );
// }
//
// export default App;
import './App.css';
import RauCu from "./component/rauCu/RauCu";
import React from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import DeleteRauCu from "./component/rauCu/DeleteRauCu";
import CreateRauCu from "./component/rauCu/CreateRauCu";
import Create from "./component/rauCu/create";
import RauCuList from "./component/rauCu/RauCuList";
import C from "./component/rauCu/c";

function App() {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/" element={<RauCuList/>}></Route>
                </Routes>
            </Router>
        </>
    );
}

export default App;

