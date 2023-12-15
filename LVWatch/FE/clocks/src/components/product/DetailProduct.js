import Header from "../home/Header";
import Footer from "../home/Footer";
import "./DetailProduct.css";
import axios from "axios";
import {useEffect, useState} from "react";
import moment from 'moment';
import 'moment/locale/vi';
import {useNavigate, useParams} from "react-router-dom";
import Swal from "sweetalert2";
import ReactStars from "react-rating-stars-component";
import jwt_decode from "jwt-decode";
import {format} from "date-fns";
import swal from "sweetalert2"; // Set the locale to Vietnamese
import * as ProductService from "../../service/ProductService" // Import locale for Vietnamese
moment.locale('vi');


export default function DetailProduct() {
    const [beCommented, setBeCommented] = useState(false);
    const [inputValue, setInputValue] = useState('');
    const [customer, setCustomer] = useState('');
    const [iputStar, setInputStar] = useState(0);
    const navigate = useNavigate();
    const {id} = useParams();
    const [idAccount, setIdAccount] = useState('');
    const [reviews, setReviews] = useState([]);
    const [product, setProducts] = useState({});
    const [images, setImages] = useState([]);
    const [ratings, setRatings] = useState([]);
    const [activeIndex, setActiveIndex] = useState(0);
    const [showEvaluate, setShowEvaluate] = useState(false);
    useEffect(() => {
        getProducts();
        getAccount();
        // fetchReviews();
    }, [])
    const getProducts = async () => {
        console.log("huyyy")
        try {
            const product = await ProductService.ProductDetail(id)
            setProducts(product?.data);
            setImages(product.data.urlImage.split(","));
            const response = await axios.get(`http://localhost:8080/api/review/${product?.data?.product_Id}`);
            response?.data?.content?.forEach((review) => {
                if (review?.rating) {
                    ratings.push(review?.rating);
                }
            });
            setReviews(response?.data?.content);
        } catch (e) {
            console.log(e)
        }
    }

    const getAccount = async () => {
        try {
            const isLoggedIn = infoAppUserByJwtToken();
            const result = await axios.get(`http://localhost:8080/api/user?userName=${isLoggedIn.sub}`);
            setIdAccount(result?.data?.accountId)
            setCustomer(result?.data?.customers?.customerId)
        } catch (e) {
            console.log(e)
        }
    }

    async function checkQuantity(productId, inputQuantity) {
        const res = await axios.get(
            `http://localhost:8080/api/cart/check-quantity?productId=${productId}&inputQuantity=${inputQuantity}`
        );
        return res.status;
    }

    const fetchReviews = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/review/${product?.product_Id}`);
            setReviews(response?.data?.content);
        } catch (error) {
            console.error(error);
        }
    };
    useEffect(() => {
        fetchReviews();
    }, []);
    const getTimeAgo = (reviewDate) => {
        const currentTime = moment();
        const reviewTime = moment(reviewDate);
        const duration = moment.duration(currentTime.diff(reviewTime));

        const daysAgo = duration.days(); // Số ngày trước
        const hoursAgo = duration.hours(); // Số giờ trước
        const minutesAgo = duration.minutes(); // Số phút trước

        let humanizedDuration = '';

        if (daysAgo > 0) {
            humanizedDuration += `${daysAgo} ngày `;
        }

        if (hoursAgo > 0) {
            humanizedDuration += `${hoursAgo} giờ `;
        }

        if (minutesAgo > 0) {
            humanizedDuration += `${minutesAgo} phút `;
        }
        if (minutesAgo < 1) {
            humanizedDuration = `1 phút `;
        }

        return humanizedDuration + 'trước';
    };
    const handleInputChange = (event) => {
        setInputValue(event.target.value);
    };

    function calculateDiscountPercentage(originalPrice, salePrice) {
        const discount = originalPrice - salePrice;
        const discountPercentage = (discount / originalPrice) * 100;
        return Math.round(discountPercentage);
    }

    const infoAppUserByJwtToken = () => {
        const jwtToken = localStorage.getItem("JWT");
        if (jwtToken) {
            const result = jwt_decode(jwtToken);
            return result;
        }
    };
    useEffect(() => {
        document.title = "LV Shop - Chi tiết đồng hồ ";
    }, []);
    const addToCart = async (cartId) => {
        const isLoggedIn = infoAppUserByJwtToken();
        if (!isLoggedIn) {
            Swal.fire("Vui lòng đăng nhập tài khoản!", "", "warning");
            navigate("/");
        } else {
            try {
                const id = await axios.get(`http://localhost:8080/api/user/getId?userName=${isLoggedIn.sub}`);
                // setAppUserId(id.data);
                const cart = {
                    quantity: 1,
                    products: {
                        productId: cartId
                    },
                    accounts: {
                        accountId: id.data
                    }
                }
                checkQuantity(cartId, 1)
                try {
                    await axios.post(
                        `http://localhost:8080/api/cart/add`, cart);
                    // await axios.post(
                    //     `http://localhost:8080/api/cart/${cartId}`);
                    Swal.fire("Thêm sản phẩm vào giỏ hàng thành công", "", "success");
                } catch (e) {
                    Swal.fire("Sản phẩm đã tồn tại trong giỏ hàng! ", "", "warning");
                }
            } catch (e) {
                swal.fire(
                    "Sản phẩm vượt quá số lượng cho phép!",
                    // "Số lượng còn lại ở kho: " + quantityInStock,
                    "warning"
                );
            }

        }
    };
    const handleTextareaResize = (event) => {
        adjustTextareaHeight(event.target);
    };
    const adjustTextareaHeight = (element) => {
        element.style.height = 'auto';
        element.style.height = `${element.scrollHeight}px`;
    };

    function formatPrice(price) {
        const formatter = new Intl.NumberFormat('vi-VN');
        return formatter.format(price);
    }


    return (
        product &&
        <>
            <Header/>
            <div className="container-fluid" style={{marginTop: "95px"}}>
                <div style={{backgroundColor: "#f8f9fa"}}>
                    <div className="container">
                        <div className={"row"}>
                            <div className={"col-8"}><h4><b>{product?.nameWatch}</b></h4></div>
                        </div>
                        <hr/>
                        <div className="row">
                            <div className="product row">
                                <div className="product-image col-6" style={{textAlign: "center"}}>
                                    <div
                                        id="carouselExampleIndicators"
                                        className="carousel slide col col-md-6 col-auto"
                                        data-bs-ride="true"
                                        style={{height: "100%"}}
                                    >
                                        <div className="carousel-indicators">
                                            {images.length > 0 &&
                                                images.map((el, index) => {
                                                    return (
                                                        <button
                                                            type="button"
                                                            data-bs-target="#carouselExampleIndicators"
                                                            data-bs-slide-to={index}
                                                            className={index === activeIndex ? "active" : ""}
                                                            aria-current="true"
                                                            aria-label={`Slide ${index + 1}`}
                                                            style={{width: 60, height: 70}}
                                                        >
                                                            <img
                                                                src={el}
                                                                alt="..."
                                                                className="d-block w-100"
                                                                style={{border: "1px lightskyblue solid"}}
                                                            />
                                                        </button>
                                                    );
                                                })}
                                        </div>
                                        {/* ----- */}
                                        <div className="carousel-inner">
                                            {images.length > 0 &&
                                                images.map((el, index) => {
                                                    return (
                                                        <div
                                                            className={`carousel-item ${
                                                                index === activeIndex ? "active" : ""
                                                            }`}
                                                        >
                                                            <img src={el} className="d-block w-100" alt="..."/>
                                                        </div>
                                                    );
                                                })}
                                        </div>
                                        <button
                                            className="carousel-control-prev"
                                            type="button"
                                            data-bs-target="#carouselExampleIndicators"
                                            data-bs-slide="prev"
                                        >
                                        <span
                                            className="carousel-control-prev-icon"
                                            aria-hidden="true"
                                        />
                                            <span className="visually-hidden">Previous</span>
                                        </button>
                                        <button
                                            className="carousel-control-next"
                                            type="button"
                                            data-bs-target="#carouselExampleIndicators"
                                            data-bs-slide="next"
                                        >
                                        <span
                                            className="carousel-control-next-icon"
                                            aria-hidden="true"
                                        />
                                            <span className="visually-hidden">Next</span>
                                        </button>
                                    </div>
                                    {/*<img style={{width: "60%"}}*/}
                                    {/*     src={product.imageUrl}*/}
                                    {/*     alt="Phone"/>*/}
                                    <br/>

                                    {/*<h5><Link href="cart.html" className="product-button">Thêm vào giỏ hàng</Link></h5>*/}
                                </div>
                                <div className="product-details col-6">
                                    {/*// <!--                    <div class="product-title">Điện thoại XYZ</div>-->*/}
                                    {/*// <!--                    <div class="product-description">Mô tả sản phẩm điện thoại XYZ.</div>-->*/}
                                    <div className="card re-card st-card">
                                        <h5 className="card-title" style={{marginLeft: "10px", marginTop: "16px"}}><b>Thông
                                            tin sản phẩm</b></h5>
                                        <div className="card-body"
                                             style={{
                                                 backgroundColor: "#f8f9fa",
                                                 marginLeft: "10px",
                                                 marginTop: "16px"
                                             }}>
                                            <table className="st-pd-table">
                                                <tbody>
                                                <tr style={{borderSpacing: "10px;"}}>
                                                    <td style={{width: "100px"}}>Sản Phẩm</td>
                                                    <td style={{paddingLeft: "10px"}}>{product?.nameWatch}
                                                    </td>
                                                </tr>
                                                <tr style={{height: "8px"}}></tr>
                                                {/*<tr style={{paddingBottom: "20px"}}>*/}
                                                {/*    <td>Xuất xứ</td>*/}
                                                {/*    <td style={{paddingLeft: "10px"}}>{product?.origin} </td>*/}
                                                {/*</tr>*/}
                                                <tr style={{height: "8px"}}></tr>
                                                <tr style={{paddingBottom: "20px"}}>
                                                    <td>Thương Hiệu</td>
                                                    <td style={{paddingLeft: "10px"}}>{product?.tableTrademarkWatch?.nameTrademarkWatch} </td>
                                                </tr>
                                                <tr style={{height: "8px"}}></tr>
                                                <tr style={{paddingBottom: "20px"}}>
                                                    <td>Loại Đồng Hồ</td>
                                                    <td style={{paddingLeft: "10px"}}>{product?.tableTypeWatch?.nameTypeWatch}</td>
                                                </tr>
                                                <tr style={{height: "8px"}}></tr>
                                                <tr style={{paddingBottom: "20px"}}>
                                                    <td>Chức năng</td>
                                                    <td style={{paddingLeft: "10px"}}>{product.tableMachineType?.nameMachineType}</td>
                                                </tr>
                                                <tr style={{height: "8px"}}></tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div className={"row"} style={{marginLeft: "10px", marginTop: "15px"}}>
                                    <div className={"col-6"}>

                                    </div>
                                    <div className="col-3 product-price">
                                        <b><h4 style={{
                                            color: "#cb1c22", fontSizeize: "28px;",
                                            fontWeighteight: "500;",
                                            lineHeight: "36px;",
                                        }}>{formatPrice(product?.priceWatch)}₫</h4></b>
                                        <p>
                                            <span style={{
                                                textDecoration: "line-through",
                                                color: "#999999",
                                                fontSize: "15px"
                                            }}>
                                                {formatPrice(product?.priceWatch * 1.87)} đ
                                            </span>
                                            <span style={{
                                                background: "#f9e9e2",
                                                borderRadius: " 2px",
                                                color: "#ef5555",
                                                marginLeft: "10px",
                                                padding: "2px 2px",
                                                fontSize: "12px"
                                            }}>
                                                -{calculateDiscountPercentage(product?.priceWatch * 1.87, product?.priceWatch)}%
                                            </span>{" "}
                                        </p>
                                    </div>
                                    <div className={"col-3"}>
                                        <button style={{backgroundColor: "#cb1c22", color: "white"}}
                                                onClick={() => addToCart(product.product_Id)}
                                                className="btn btn-primary btn-xl btn-full" id="btn-buy-now">
                                            THÊM VÀO GIỎ HÀNG
                                        </button>
                                    </div>
                                </div>
                                <div>
                                    {product?.description}
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}