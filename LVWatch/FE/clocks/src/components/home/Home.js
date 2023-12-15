import Header from "./Header";
import Footer from "./Footer";
import {useEffect, useState} from "react";
import axios from "axios";
import "./Home.css";
import 'bootstrap-icons/font/bootstrap-icons.css';
import Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";
import jwt_decode from "jwt-decode";
import React from 'react';
import {Carousel} from 'react-bootstrap';
import * as ProductService from "../../service/ProductService"


export default function Home() {
    const navigate = useNavigate();
    const [products, setProducts] = useState([]);
    const [productsMale, setProductsMale] = useState([]);
    const [productsFemale, setProductsFeMale] = useState([]);
    const getProducts = async () => {
        try {
            const product = await axios.get("http://localhost:8080/api/product?page=3&size=4")
            setProducts(product?.data.content);
        }catch (e) {
            console.log(e)
        }
    }
    const getProductsMale = async () => {
        try {
            const product = await  ProductService.getMaleWatch()
            setProductsMale(product?.data);
            console.log(product)
        }catch (e) {
            console.log(e)
        }
    }
    const getProductsFeMale = async () => {
        try {
            const product = await ProductService.getFemaleWatch()
            setProductsFeMale(product?.data);
        }catch (e) {
            console.log(e)
        }
    }
    useEffect(() => {
        getProducts();
    }, [])
    useEffect(() => {
        getProductsMale();
        getProductsFeMale();
    }, [])
    function calculateDiscountPercentage(originalPrice, salePrice) {
        const discount = originalPrice - salePrice;
        const discountPercentage = (discount / originalPrice) * 100;
        return Math.round(discountPercentage);
    }

    function formatPrice(price) {
        const formatter = new Intl.NumberFormat('vi-VN');
        return formatter.format(price);
    }
    useEffect(() => {
        document.title = "VL Watch - Trang chủ";
    }, []);

    const infoAppUserByJwtToken = () => {
        const jwtToken = localStorage.getItem("JWT");
        if (jwtToken) {
            const result = jwt_decode(jwtToken);
            return result;
        }
    };
    const addToCart = async (cartId) => {
        const isLoggedIn = infoAppUserByJwtToken();
        if (!isLoggedIn) {
            Swal.fire("Vui lòng đăng nhập tài khoản!", "", "warning");
            navigate("/");
        } else {
            try {
                const id = await axios.get(`http://localhost:8080/api/user/getId?userName=${isLoggedIn.sub}`);
                const cart = {
                    quantity: 1,
                    products: {
                        productId: cartId
                    },
                    accounts: {
                        accountId: id.data
                    }
                }
                await axios.post(
                    `http://localhost:8080/api/cart/add`, cart);
                // await axios.post(
                //     `http://localhost:8080/api/cart/${cartId}`);
                Swal.fire("Thêm sản phẩm vào giỏ hàng thành công", "", "success");
            }catch (e){
                Swal.fire("Sản phẩm đã tồn tại trong giỏ hàng! ", "", "warning");
            }
        }
    };
    return (
        <>
            <Header/>
            {/* #header */}
            {/* start banner Area */}
            <section className="banner-area" id="home" style={{textAlign: "center"}}>
                <div className="container">
                    <div className="row fullscreen d-flex align-items-center justify-content-center">
                        <div className="banner-content col-lg-10">
                            {/*                <h5 class="text-white text-uppercase">Now you can feel the Heat</h5>*/}
                            <h1>Đồng hồ hiện đại và cổ điển</h1>
                            <a href="#" className="primary-btn text-uppercase"
                               style={{
                                   textDecoration: "none",
                                   background: "#fff",
                                   border: "1px solid transparent",
                                   color: "#222",
                                   paddingLeft: "40px",
                                   paddingRight: "40px",
                                   borderRadius: "50px",
                                   marginBottom:"15px"
                               }}
                            >
                                Mua ngay
                            </a>
                        </div>
                    </div>
                </div>
            </section>
            <section className="unique-feature-area section-gap" id="unique">
                <div className="container">
                    <div className="row d-flex justify-content-center">
                        <div className="menu-content pb-60 col-lg-10">
                            <div className="title text-center">
                                <h1 className="mb-10 text-white">ĐỒNG HỒ NAM</h1>
                            </div>
                        </div>
                    </div>
                    {productsMale.length > 0 ? (
                        <div className="row">
                            {productsMale.map((product, index) => (
                                <div key={index} className="col-3">
                                    <div className="single-unique-product">
                                        <a href={`product/${product.watchId}`}>
                                            <img className="image-home img-fluid" src={product?.imageUrl} alt=""/>
                                        </a>
                                        <div className="desc">
                                            <h6 style={{height:"30px"}}>{product?.nameWatch}</h6>
                                            <p>
                                                 <span style={{textDecoration: "line-through", color:"#999999", fontSize:"15px"}}>
                                                    {formatPrice(product?.price * 1.87)} đ
                                                </span>
                                                <span style={{background: "#f9e9e2",
                                                    borderRadius:" 2px",
                                                    color: "#ef5555",
                                                    marginLeft: "10px",
                                                    padding: "2px 2px",
                                                    fontSize: "12px"}}>
                                                    -{calculateDiscountPercentage(product?.price * 1.87,product?.price)}%
                                                </span>{" "}
                                            </p>
                                            <h6 style={{color:"red"}}>
                                                {formatPrice(product?.price)} đ
                                            </h6>
                                            <button onClick={() => addToCart(product.watchId)} className="text-uppercase primary-btn" style={{textDecoration: "none"}}>
                                                Thêm vào giỏ hàng
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    ) : (
                        <p style={{color: "red"}}>Không có sản phẩm nào!</p>
                    )}
                </div>
                <div className="container">
                    <div className="row d-flex justify-content-center">
                        <div className="menu-content pb-60 col-lg-10">
                            <div className="title text-center">
                                <h1 className="mb-10 text-white">ĐỒNG HỒ NỮ</h1>
                            </div>
                        </div>
                    </div>
                        {productsFemale.length > 0 ?(
                                <div className="row">
                                    {productsFemale.map((product, index) => (
                                            <div key={index} className="col-3">
                                                <div className="single-unique-product">
                                                    <a href={`product/${product.watchId}`}>
                                                    <img className="image-home img-fluid" src={product?.imageUrl} alt=""/>
                                                    </a>
                                                    <div className="desc">
                                                        <h6 style={{height:"30px"}}>{product?.nameWatch}</h6>
                                                        <p>
                                                             <span style={{textDecoration: "line-through", color:"#999999", fontSize:"15px"}}>
                                                                {formatPrice(product?.price * 1.87)} đ
                                                            </span>
                                                                        <span style={{background: "#f9e9e2",
                                                                            borderRadius:" 2px",
                                                                            color: "#ef5555",
                                                                            marginLeft: "10px",
                                                                            padding: "2px 2px",
                                                                            fontSize: "12px"}}>
                                                                -{calculateDiscountPercentage(product?.price * 1.87,product?.price)}%
                                                            </span>{" "}
                                                        </p>
                                                        <h6 style={{color:"red"}}>{formatPrice(product?.price)} đ</h6>
                                                        <button onClick={() => addToCart(product.watchId)} className="text-uppercase primary-btn" style={{textDecoration: "none"}}>
                                                            Thêm vào giỏ hàng
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        ))}
                                </div>
                            ):(
                                <p style={{color: "red"}}>Không có sản phẩm nào!</p>
                            )
                        }
                </div>
            </section>
            {/* End faq Area */}
            <Footer/>
        </>
    )
}