import './App.css';
import Body from "./display/body/product/body";
import Footer from "./display/footer/footer";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import BodyCustomer from "./display/body/customer/bodyCustomer";
import React from "react";
import Header from "./display/header/header";
import {Outlet} from "react-router-dom";
import BodyContract from "./display/body/contract/bodyContract";

function App() {
    return (
        <Router>
            <Header/>
            <Routes>
                <Route path="/">
                    <Route index element={<Body/>}/>
                    <Route path="customer" element={<BodyCustomer/>}/>
                    <Route path="contract" element={<BodyContract/>}/>
                </Route>
            </Routes>
            <Footer/>
            <Outlet />
        </Router>
    );
}

export default App;
