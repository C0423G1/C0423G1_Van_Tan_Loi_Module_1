import Header from "../home/Header";
import Footer from "../home/Footer";
import "./CartDetail.css"
import React, {useEffect, useState} from "react";
import axios from "axios";
import Swal from "sweetalert2";
import {useParams} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup"
import swal from "sweetalert2";
import {format} from "date-fns";
import * as ProductService from "../../service/ProductService"
import jwt_decode from "jwt-decode";

export default function CartDetail() {
    const [carts, setCarts] = useState([]);
    const [customer, setCustomer] = useState({});
    const [cart2, setCart2] = useState({});
    const {id} = useParams();
    const [totalPrice, setTotalPrice] = useState(0);
    const [selectedCart, setSelectedCart] = useState([]);




    const formStyles = {
        display: "flex",
        flexDirection: "column",
        maxWidth: "806px",
        margin: "0 auto",
        border: "1px solid black",
        padding: "10px",
        borderRadius: "10px",
        marginLeft: "10px",
        marginRight: "10px",
        marginBottom: "10px",
        marginTop: "10px"
    };

    const formGroupStyles = {
        marginBottom: "1rem",
    };


    const inputStyles = {
        width: "100%",
        padding: "0.5rem",
        borderRadius: "8px",
        border: "1px solid #ccc",
    };

    const buttonStyles = {
        textAlign: "center",
        padding: "0.5rem 1rem",
        backgroundColor: "#007bff",
        width: "400px",
        background: "#007bff",
        backdropFilter: "blur(18.5px)",
        WebkitBackdropFilter: "blur(18.5px)",
        border: "1px solid rgba(255, 255, 255, 0.18)",
        outline: "none",
        height: "49px",
        borderRadius: "49px",
        color: "#fff",
        textTransform: "uppercase",
        fontWeight: "600",
        margin: "10px 0",
        cursor: "pointer",
        transition: "0.5s",
    };

    const getCart = async () => {
        setCarts(await ProductService.getCart(jwt_decode(localStorage.getItem("JWT")).sub))
    };

    useEffect(() => {
        getCart();
    }, []);

    return (
        <>
            <Header/>
            <div className="container-fluid" style={{ marginTop:"40px"}}>
                <div id={"cart"} style={{backgroundColor: "#edf0f3",}}>
                    <form action="/order?action=create">
                        <section className="h-100 h-custom" style={{backgroundColor: "#d2c9ff;"}}>
                            <div className="container-fluid py-5 h-100">
                                <div className="row d-flex justify-content-center align-items-center h-100">
                                    <div className="col-12" style={{maxWidth: "700px",}}>
                                        <div style={{display: "inline", textAlign: "center"}}
                                             className="">
                                            <a href="/home"><i style={{width: "50px", height: "20px"}}
                                                               className="fa-solid fa-arrow-left"></i></a>
                                            <h5
                                                className="fw-bold mb-0 text-black">Giỏ hàng của bạn</h5>
                                        </div>
                                        <hr className="my-4"/>
                                        <div className="card card-registration card-registration-2"
                                             style={{borderRadius: "15px;"}}>
                                            <div className="card-body p-0">
                                                <div className="row g-0">
                                                    <div className="col-lg-12">
                                                        <div className="p-5">
                                                            {
                                                                carts?.length > 0 ? (
                                                                    <div
                                                                        className="row mb-4 d-flex justify-content-between align-items-center">
                                                                        <div className={"row"}>
                                                                            <div className={"col-11"}></div>
                                                                            <div className={"col-1"}>
                                                                                <a
                                                                                    role="button"
                                                                                    className=" mx-5 p-0 text-primary"
                                                                                    style={{
                                                                                        backgroundColor: "white",
                                                                                        color: "red",
                                                                                        cursor: "pointer",
                                                                                        // fontSize: "14px",
                                                                                    }}
                                                                                >
                                                                                    <i style={{
                                                                                        backgroundColor: "white",
                                                                                        color: "red",
                                                                                        cursor: "pointer",
                                                                                        fontSize: "30px",
                                                                                    }} className="fa-solid fa-trash"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                        {carts.map((cart, index) => (
                                                                            <div key={index} className="row"
                                                                                 style={{marginBottom: "10px"}}>
                                                                                <div className="col-3 ">
                                                                        <span>
                                                                          <input
                                                                              type="checkbox"
                                                                              name="multiSelect"
                                                                              style={{marginRight: "20px"}}
                                                                          />
                                                                        </span>
                                                                                    <img
                                                                                        src={cart?.products?.imageUrl}
                                                                                        className="img-fluid rounded-3"
                                                                                        style={{
                                                                                            width: "100px",
                                                                                            height: "100px"
                                                                                        }}
                                                                                        alt="ProductList Image"
                                                                                    />
                                                                                </div>
                                                                                <div className="col-6 "
                                                                                     style={{textAlign: "center"}}>
                                                                                    <h6 className="text-muted">{cart?.products?.name}</h6>
                                                                                    <div style={{
                                                                                        fontSize: " 18px",
                                                                                        fontWeight: "700",
                                                                                        color: "#cb1c22",
                                                                                        lineHeight: "normal"
                                                                                    }}>
                                                                                        {/*<h6 className="price">{formatPrice(cart?.products?.price)} đ</h6>*/}
                                                                                    </div>
                                                                                </div>
                                                                                <div className="col-3 d-flex">
                                                                                    <a style={{
                                                                                        backgroundColor: "#f3f3f3",
                                                                                        borderEadius: "5px",
                                                                                        textAlign: "center",
                                                                                        cursor: "pointer",
                                                                                        height: "30px",
                                                                                        width: "30px"
                                                                                    }}
                                                                                       role="button"

                                                                                    >
                                                                                        <i className="fas fa-minus"></i>
                                                                                    </a>
                                                                                    <input
                                                                                        style={{
                                                                                            textAlign: "right",
                                                                                            width: "49px",
                                                                                            height: "30px"
                                                                                        }}
                                                                                        id={`input-quantity${cart.products.productId}`}
                                                                                        name="quantity"
                                                                                        value={cart?.quantity}
                                                                                        type="number"
                                                                                        readOnly
                                                                                        className="form-control form-control-sm"
                                                                                    />
                                                                                    <a style={{
                                                                                        backgroundColor: "#f3f3f3",
                                                                                        borderEadius: "4px",
                                                                                        cursor: "pointer",
                                                                                        textAlign: "center",
                                                                                        height: "30px",
                                                                                        width: "30px"
                                                                                    }}
                                                                                       role="button"
                                                                                    >
                                                                                        <i className="fas fa-plus"></i>
                                                                                    </a>
                                                                                </div>
                                                                            </div>
                                                                        ))}
                                                                    </div>
                                                                ) : (
                                                                    <p style={{color: "red"}}>Không có sản phẩm nào
                                                                        trong giỏ hàng!</p>
                                                                )
                                                            }
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </form>

                    <div className={"row"}>
                        <div className={"col-2"}></div>
                        <div className={"col-8"}>
                            <Formik
                                enableReinitialize={true}
                                initialValues={{
                                    ...customer,
                                    // customerId: customer?.customerId,
                                    // name: customer?.name,
                                    // phoneNumber: customer?.phoneNumber,
                                    // address: customer?.address,
                                    // email: customer?.email,
                                    // flagDeleted: customer?.flagDeleted
                                }}
                                validationSchema={Yup.object({
                                    name: Yup.string().required('Vui lòng nhập họ và tên'),
                                    phoneNumber: Yup.string().required('Vui lòng nhập số điện thoại'),
                                    address: Yup.string().required('Vui lòng nhập địa chỉ'),
                                    email: Yup.string().email('Email không hợp lệ').required('Vui lòng nhập email'),
                                })}
                            >
                                <Form style={formStyles}>
                                    <h5>Thông tin người đặt</h5>
                                    <div className={"row"}>
                                        <Field
                                            style={inputStyles}
                                            type="text"
                                            id="fullName"
                                            name="customerId"
                                            hidden
                                            value={customer?.customerId}
                                        />
                                        <div className={"col-6"} style={formGroupStyles}>
                                            <Field
                                                style={inputStyles}
                                                type="text"
                                                id="fullName"
                                                name="name"
                                                placeholder={"Nhập họ và tên"}
                                                required
                                            />
                                            <ErrorMessage className="text-danger" name="name" component="small"/>
                                        </div>
                                        <div className={"col-6"} style={formGroupStyles}>
                                            <Field
                                                style={inputStyles}
                                                type="text"
                                                id="phoneNumber"
                                                name="phoneNumber"
                                                placeholder={"Nhập số điện thoại"}
                                                required
                                            />
                                            <ErrorMessage className="text-danger" name="phoneNumber" component="small"/>
                                        </div>
                                    </div>
                                    <div className={"row"}>
                                        <div className={"col-6"} style={formGroupStyles}>
                                            <Field
                                                style={inputStyles}
                                                type="text"
                                                id="address"
                                                name="address"
                                                placeholder={"Nhập địa chỉ"}
                                                required
                                            />
                                            <ErrorMessage className="text-danger" name="address" component="small"/>
                                        </div>
                                        <div className={"col-6"} style={formGroupStyles}>
                                            <Field
                                                style={inputStyles}
                                                type="email"
                                                id="email"
                                                name="email"
                                                placeholder={"Nhập email"}
                                                required
                                            />
                                            <ErrorMessage className="text-danger" name="email" component="small"/>
                                        </div>
                                    </div>
                                    <div style={{textAlign: "center"}}>
                                        <button style={buttonStyles} type="submit">Xác nhận</button>
                                    </div>

                                </Form>
                            </Formik>
                        </div>
                        <div className={"col-2"}></div>
                    </div>
                    <div className="sticky bottom-0 z-[12] md:mt-4" style={{backgroundColor:"#1b2033"}}>
                        <div className="rounded-t-2xl bg-white md:rounded-t-none"
                             style={{filter: "drop-shadow(rgba(2, 11, 39, 0.08) 0px -4px 16px);"}}>
                            <div className="mx-auto w-full px-4 md:max-w-[806px] md:px-0">
                                <div className="bg-gray-1 py-3" style={{marginBottom:"35px"}}>
                                    <div className="mx-auto w-full px-4 md:max-w-[806px] md:px-0">
                                        <div className="row flex flex-col md:flex-row md:gap-6 ">
                                            <div className="col-6 hidden flex-1 flex-col justify-between md:flex">
                                                <div className="flex justify-between"  style={{ position: "absolute", left: 0, marginTop:"20px" }}>
                                                    <p
                                                    className="css-1oqd6bl text-text-secondary">Tổng
                                                    tiền:
                                                </p>
                                                </div>
                                                <div className="flex flex-1 flex-col justify-between md:flex-row" style={{ position: "absolute", right: 0, marginTop:"20px" }}>
                                                        <span style={{display: "inline"}}>
                                                            <b
                                                            ><h4
                                                                style={{
                                                                    textAlign: "center",
                                                                    color: "#cb1c22", fontSizeize: "28px;",
                                                                    fontWeighteight: "500;",
                                                                    lineHeight: "36px;"
                                                                }}>
                                                                {/*{formatPrice(totalPrice)}₫*/}
                                                            </h4></b>
                                                        </span>
                                                </div>
                                            </div>
                                            <div className="col-6 ">
                                                <div className=" w-100 d-flex justify-content-center">
                                                    {
                                                        totalPrice !==0 &&(
                                                            <button
                                                                className="btn ant-btn css-10ed4xt ant-btn-primary max-w-[147px] !rounded-full md:mt-1 md:w-full md:max-w-none estore-btn estore-btn-bg  css-1krd2ey"
                                                                style={{
                                                                }}
                                                                // onClick={handleVNPAY}
                                                            >
                                                                THANH TOÁN VỚI VNPAY
                                                            </button>
                                                        )
                                                    }
                                                </div>
                                            </div>
                                            <div className={"col-2"}>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <Footer></Footer>
        </>
    )
}