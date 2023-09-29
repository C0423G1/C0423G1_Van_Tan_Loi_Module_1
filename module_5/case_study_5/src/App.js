import './App.css';
import Body from "./component/product/Body";
import Footer from "./component/common_parts/footer/Footer";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import BodyCustomer from "./component/customer/BodyCustomer";
import React from "react";
import Header from "./component/common_parts/header/Header";
import BodyContract from "./component/contract/BodyContract";
import CreateProduct from "./component/product/CreateProduct";
import DeleteProduct from "./component/product/DeleteProduct";
import CreateCustomer from "./component/customer/CreateCustomer";
import EditProduct from "./component/product/EditProduct";
import EditCustomer from "./component/customer/EditCustomer";
import DeleteCustomer from "./component/customer/DeleteCustomer";
import CreateContract from "./component/contract/CreateContract";
import DeleteContract from "./component/contract/DeleteContract";
import EditContract from "./component/contract/EditContract";
import CreateService from "./component/product/demo/CreateDemo";
import HouseList from "./component/product/demo/house/HouseList";
import VillaList from "./component/product/demo/villa/VillaList";
import RoomList from "./component/product/demo/room/RoomList";
import DeleteHouse from "./component/product/demo/house/DeleteHouse";
import DeleteVilla from "./component/product/demo/villa/DeleteVilla";
import DeleteRoom from "./component/product/demo/room/DeleteRoom";
import EditHouse from "./component/product/demo/house/EditHouse";
import EditRoom from "./component/product/demo/room/EditRoom";
import EditVilla from "./component/product/demo/villa/EditVilla";

function App() {
    return (
        <Router>
            <Header/>
            <Routes>
                <Route path="/">
                    <Route index element={<Body/>}/>
                    <Route path="customer" element={<BodyCustomer/>}/>
                    <Route path="contract" element={<BodyContract/>}/>
                    <Route path="deleteProduct/:id" element={<DeleteProduct/>}/>
                    <Route path="CreateProduct" element={<CreateProduct/>}/>
                    <Route path="CreateCustomer" element={<CreateCustomer/>}/>
                    <Route path="editProduct/:id" element={<EditProduct/>}/>
                    <Route path="editCustomer/:id" element={<EditCustomer/>}/>
                    <Route path="deleteCustomer/:id" element={<DeleteCustomer/>}/>
                    <Route path="createContract" element={<CreateContract/>}/>
                    <Route path="deleteContract/:id" element={<DeleteContract/>}/>
                    <Route path="editContract/:id" element={<EditContract/>}/>
                    <Route path="createDemo" element={<CreateService/>}/>
                    <Route path="house" element={<HouseList/>}/>
                    <Route path="villa" element={<VillaList/>}/>
                    <Route path="house" element={<HouseList/>}/>
                    <Route path="room" element={<RoomList/>}/>
                    <Route path="deleteHouse/:id" element={<DeleteHouse/>}/>
                    <Route path="deleteVilla/:id" element={<DeleteVilla/>}/>
                    <Route path="deleteRoom/:id" element={<DeleteRoom/>}/>
                    <Route path="editHouse/:id" element={<EditHouse/>}/>
                    <Route path="editRoom/:id" element={<EditRoom/>}/>
                    <Route path="editVilla/:id" element={<EditVilla/>}/>
                </Route>
            </Routes>
            <Footer/>
        </Router>
    );
}

export default App;
