import React, {useEffect, useState} from 'react';
import * as City from '../service/APICity/City';
import {jwtDecode} from 'jwt-decode';
import Header from "./home/Header";
import Footer from "./home/Footer";

const CustomerForm = () => {
    const [customer, setCustomer] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const user = await City.getUser(jwtDecode(localStorage.getItem('JWT')).sub);
                setCustomer(user);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        document.title = "Catland Booking - Thông tin cá nhân ";
        fetchData();
    }, []);

    return (
        customer && (
            <>
                <Header/>
                <div className="form-user-account">
                    <div className="customer-form">
                        {/*<div className="form-group">*/}
                        {/*    <label htmlFor="id_customer">ID</label>*/}
                        {/*    <div>{customer.idCustomer}</div>*/}
                        {/*</div>*/}
                        <div className="form-group">
                            <label htmlFor="name_customer">Họ Và tên</label>
                            <div>{customer.nameCustomer}</div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="address_customer">Địa Chỉ</label>
                            <div>{customer.addressCustomer}</div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="cccd_customer">CCCD/CMND</label>
                            <div>{customer.cccdCustomer}</div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="gender_customer">Giới Tính</label>
                            <div>{customer.genderCustomer}</div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="phone_customer">Số điện thoại</label>
                            <div>{customer.phoneCustomer}</div>
                        </div>
                        {/*<div className="form-group">*/}
                        {/*    <label htmlFor="stk_customer">Số T</label>*/}
                        {/*    <div>{customer.stkCustomer}</div>*/}
                        {/*</div>*/}
                    </div>
                </div>
                <Footer/>
            </>
        )
    );
};

export default CustomerForm;
