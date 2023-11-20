import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Index from "./components/home/Index";
import List from "./components/home/List";
import HouseDetails from "./components/home/HouseDetail";
import Login from "./components/home/Header/Login";
import A from "./components/home/demo";
import BookingPage from "./components/home/BookingPage";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import VNPayPayment from "./components/home/VNPayPayment";
import CustomerForm from "./components/CustomerForm";
import OrderSuccess from "./components/home/OrderSuccess";
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
                        <Route path="/pay/:id" element={<BookingPage/>}/>
                        <Route path="/booking" element={<VNPayPayment/>}/>
                        <Route path="/userform" element={<CustomerForm/>}/>
                        <Route path="/ordersuccess" element={<OrderSuccess/>}/>
                    </Routes>
                </Router>
                <ToastContainer />
            </>
        </>
    );
}

export default App;
