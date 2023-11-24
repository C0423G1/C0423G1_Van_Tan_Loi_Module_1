import React, {useEffect, useState} from 'react';
import {PayPalScriptProvider, PayPalButtons} from '@paypal/react-paypal-js';
import '../../App.css';
import Header from './Header';
import {useNavigate, useParams} from 'react-router-dom';
import * as City from '../../service/APICity/City';
import {jwtDecode} from 'jwt-decode';
import {toast} from 'react-toastify';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faBed, faUser, faUsers, faWifi} from '@fortawesome/free-solid-svg-icons';
import {differenceInDays, format, parseISO} from 'date-fns';
import {ErrorMessage, Field, Form, Formik} from 'formik';
import * as Yup from 'yup';
import Swal from "sweetalert2";
import Footer from "./Footer";

function formatDate(str) {
    const date = new Date(str);
    const formattedDate = format(date, "dd 'tháng' MM yyyy");
    return formattedDate;
}

function quantityDate(end, start) {
    const startDateObject = parseISO(start);
    const endDateObject = parseISO(end);
    const daysDifference = differenceInDays(startDateObject, endDateObject);
    return daysDifference;
}

const BookingPage = () => {
    const [paymentMethod, setPaymentMethod] = useState('');
    const navigate = useNavigate();
    const {id} = useParams();
    const [city, setCity] = useState([]);
    const [flag, setFlag] = useState(true);
    const [flagPay, setFlagPay] = useState(false);
    const quantityDatee = quantityDate(
        JSON.parse(localStorage.getItem('HOTEL')).startDate,
        JSON.parse(localStorage.getItem('HOTEL')).endDate
    );

    const sum = city.reduce((acc, current) => acc + current.priceTypeHotel * current.quantity * quantityDatee, 0);
    const sumPay = sum / 20000;
    const sumRoom = city.reduce((acc, current) => acc + current.quantity, 0);

    const validationSchema = Yup.object({
        fullName: Yup.string().required('Họ và Tên là bắt buộc'),
        phoneNumber: Yup.string().required('Số điện thoại là bắt buộc'),
        idCard: Yup.string().required('Số CMND/CCCD là bắt buộc'),
    });

    const onApprove = async (data, actions) => {
        console.log('Payment was approved!');
        try {
            Swal.fire({
                icon: 'success',
                title: 'Thanh toán thành công!',
                showConfirmButton: false,
            });
            navigate('/');
        } catch (error) {
            console.error('Error handling payment success:', error);
            console.log("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")

        }
    };

    // Hàm callback khi thanh toán thất bại
    const onError = (err) => {
        console.error('Payment failed:', err);
        console.log("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")
    };

    const createOrder = (data, actions) => {
        return actions.order.create({
            purchase_units: [
                {
                    amount: {
                        value: sumPay,
                        currency_code: 'USD',
                    },
                },
            ],
        });
    };

    const getAll = async () => {
        try {
            const check = await City.checkPayRoom(
                id,
                jwtDecode(localStorage.getItem('JWT')).sub,
                JSON.parse(localStorage.getItem('HOTEL')).startDate,
                JSON.parse(localStorage.getItem('HOTEL')).endDate
            );
            setCity(check);
        } catch (error) {
            toast.error(`Mời bạn vui lòng chọn phòng trước khi thanh toán`);
        }
    };

    useEffect(() => {
        getAll();
        document.title = "Catland Booking - Đặt phòng " ;
    }, []);

    const handleSubmit = async (values) => {
        let check = true;
        for (let i = 0; i < city.length; i++) {
            const a = await City.checkRoom(city[i].idTypeHotel, jwtDecode(localStorage.getItem("JWT")).sub, JSON.parse(localStorage.getItem("HOTEL")).startDate, JSON.parse(localStorage.getItem("HOTEL")).endDate);
            if (a < 0) {
                check = false;
                break;
            }
        }
        if (check) {
            for (let i = 0; i < city.length; i++) {
                await City.pay(
                    values.fullName,
                    values.phoneNumber,
                    city[i].idTypeHotel,
                    JSON.parse(localStorage.getItem('HOTEL')).startDate,
                    JSON.parse(localStorage.getItem('HOTEL')).endDate,
                    jwtDecode(localStorage.getItem('JWT')).sub
                );
            }
        } else {
            toast("Chậm mất rồi phòng bạn đã chọn đã hết");
            navigate("/")
        }
        setFlag(false);
        setFlagPay(true)
    };

    const checkVNPay = async () => {
        console.log(sum);
        const link = await City.checkVNPay(sum);
        console.log(link)
        window.close();
        window.location.href = link;
    }


    return (
        <>
            <Header/>
            <div className="container">
                <div className="list-container">
                    <div className="left-col">
                        {city &&
                            city.map((city) => (
                                <div className="house" key={city.idTypeHotel}>
                                    <div className="house-img">
                                        <img src="/images/image-s1.png" alt="House"/>
                                    </div>
                                    <div className="house-info">
                                        <h3>{city.nameTypeHotel}</h3>
                                        <p>
                                            <FontAwesomeIcon icon={faBed}/> {city.quantityBed} Giường &nbsp;&nbsp;
                                            <FontAwesomeIcon icon={faUser}/>
                                            {city.numberGuests} khách
                                        </p>
                                        <div className="house-price">
                                            <h6>{(city.priceTypeHotel * 5.82573).toLocaleString('vi-VN')} VND</h6>
                                            <h4>{city.priceTypeHotel.toLocaleString('vi-VN')} VND</h4>
                                        </div>
                                    </div>
                                </div>
                            ))}
                        <Formik
                            initialValues={{
                                fullName: '',
                                phoneNumber: '',
                                idCard: '',
                            }}
                            onSubmit={handleSubmit}
                            validationSchema={validationSchema}
                        >
                            <Form>
                                <div className="form-user">
                                    <div className="form-user-user">
                                        <h3>Điền thông tin khách hàng đại diện lưu trú </h3>
                                        <div>
                                            <label htmlFor="fullName">Họ và Tên :</label>
                                            <span className="error">*</span>
                                            <Field type="text" id="fullName" name="fullName"/>
                                            <ErrorMessage name="fullName" component="div" className="error"/>
                                        </div>

                                        <div>
                                            <label htmlFor="phoneNumber">Số điện thoại :</label>
                                            <span className="error">*</span>
                                            <Field type="tel" id="phoneNumber" name="phoneNumber"/>
                                            <ErrorMessage name="phoneNumber" component="div" className="error"/>
                                        </div>

                                        <div>
                                            <label htmlFor="idCard">Số CMND/CCCD :</label>
                                            <span className="error">*</span>
                                            <Field type="text" id="idCard" name="idCard"/>
                                            <ErrorMessage name="idCard" component="div" className="error"/>
                                        </div>
                                    </div>
                                    {flag && <button className="button-pay" type="submit">
                                        Thanh toán
                                    </button>}
                                </div>
                            </Form>
                        </Formik>
                    </div>

                    <div className="right-col">
                        {city.map((city) => (
                            <div className="hotel-cart" key={city.idTypeHotel}>
                                <div className="date-hotel">
                                    <h4>{formatDate(JSON.parse(localStorage.getItem('HOTEL')).startDate)} - {formatDate(JSON.parse(localStorage.getItem('HOTEL')).endDate)}</h4>
                                    <h5>{quantityDatee} đêm</h5>
                                </div>
                                <h4>
                                    {city.quantity} x {city.nameTypeHotel}
                                </h4>
                                <hr/>
                                <div className="image-hotel">
                                    <div className="image-hotel-cart">
                                        <img src="/images/dubai.png" height="536" width="536" alt="Hotel"/>
                                    </div>
                                    <div className="hotel-info">
                                        <p>
                                            <FontAwesomeIcon icon={faUser} className="pay-icon"/> &nbsp;1
                                            phòng, {city.numberGuests} người lớn
                                        </p>
                                        <p>
                                            <FontAwesomeIcon icon={faUsers} className="pay-icon"/> Tối
                                            đa: {city.numberGuests} người lớn, 1 Trẻ em
                                            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;(0-11 tuổi)
                                        </p>
                                        <p>
                                            <FontAwesomeIcon icon={faWifi} className="pay-icon"/> &nbsp;WiFi miễn phí
                                        </p>
                                    </div>
                                </div>
                            </div>
                        ))}
                        <div className="sidebar">
                            <h2>Tóm tắt đặt phòng </h2>
                            <div className="check-in">
                                <h5>Check in </h5>
                                <p>15:00</p>
                            </div>
                            <div className="check-out">
                                <h5>Check out </h5>
                                <p>12:00</p>
                            </div>
                            <hr/>
                            <div className="cart-hotel">
                                <p>Giá gốc ({sumRoom} phòng x {quantityDatee} đêm )</p>
                                <p>{(sum * 5.82573).toLocaleString('vi-VN')} đ</p>
                            </div>
                            <div className="cart-hotel">
                                <p>Giá phòng ({sumRoom} phòng x {quantityDatee} đêm )</p>
                                <p>{sum.toLocaleString('vi-VN')} đ</p>
                            </div>
                            <hr/>
                            <div className="cart-hotel">
                                <h4>Tổng tiền :</h4>
                                <p>{sum.toLocaleString('vi-VN')} đ</p>
                            </div>
                            <h6>Giá đã bao gồm : <span>Thuế 8% ,Phí dịch vụ 5 %</span></h6>
                            <div class="payment">
                                {flagPay && (
                                    <>
                                        <input
                                            type="radio"
                                            id="vnpay"
                                            name="paymentMethod"
                                            value="vnpay"
                                            checked={paymentMethod === 'vnpay'}
                                            onChange={() => setPaymentMethod('vnpay')}
                                        />
                                        Thanh toán VNPay
                                        <input
                                            type="radio"
                                            id="palpay"
                                            name="paymentMethod"
                                            value="palpay"
                                            checked={paymentMethod === 'palpay'}
                                            onChange={() => setPaymentMethod('palpay')}
                                        />
                                        Thanh toán PalPay
                                        {paymentMethod === 'palpay' && (
                                            <PayPalScriptProvider
                                                options={{"client-id": "ATVLu4Mi0WmojMeUtCh-wTtCBb37GExzwi18B7kLRGSX9bUvnLq92Rnm02UnBCRPu_KGIgnkFOCOP94E"}}
                                            >
                                                <PayPalButtons createOrder={createOrder} onApprove={onApprove}
                                                               onError={onError}/>
                                            </PayPalScriptProvider>
                                        )}

                                        {paymentMethod === 'vnpay' && (
                                            <button onClick={checkVNPay}>Ví điện tử &nbsp;&nbsp; <img
                                                src="/images/images-removebg-preview.png"/></button>
                                        )}
                                    </>
                                )}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    );
};

export default BookingPage;
