import './App.css';
import Body from "./component/product/body";
import Footer from "./component/common_parts/footer/footer";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import BodyCustomer from "./component/customer/bodyCustomer";
import React from "react";
import Header from "./component/common_parts/header/header";
import BodyContract from "./component/contract/BodyContract";
import CreateCustomer from "./component/customer/createCustomer";

function App() {
    return (
        <Router>
            <Header/>
            <Routes>
                <Route path="/">
                    <Route index element={<Body/>}/>
                    <Route path="customer" element={<BodyCustomer/>}/>
                    <Route path="contract" element={<BodyContract/>}/>
                    <Route path="createCustomer" element={<CreateCustomer/>}/>
                </Route>
            </Routes>
            <Footer/>
        </Router>
    );
}

export default App;
