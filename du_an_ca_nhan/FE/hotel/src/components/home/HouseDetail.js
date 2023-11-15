import React, {useEffect, useState} from 'react';
import Header from "./Header";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {
    faBed,
    faCar,
    faClock,
    faElevator,
    faMapMarkerAlt,
    faSnowflake, faUser,
    faUtensils,
    faWifi
} from '@fortawesome/free-solid-svg-icons';
import "../../App.css";
import {Link, useNavigate, useParams} from "react-router-dom";
import * as City from "../../service/APICity/City";


// Import Swiper styles
import 'swiper/css';
import 'swiper/css/free-mode';
import 'swiper/css/navigation';
import 'swiper/css/thumbs';
import './style.css';
import {Swiper, SwiperSlide} from "swiper/react";
import {FreeMode, Navigation, Thumbs} from "swiper/modules";
import {jwtDecode} from "jwt-decode";
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const HouseDetails = () => {
    const navigate = useNavigate()
    const [thumbsSwiper, setThumbsSwiper] = useState(null);
    const {id} = useParams()
    const [hotel, setHotel] = useState(null)
    const [typeHotel, setTypeHotel] = useState([])
    const [imageHotel, setImageHotel] = useState([])
    const [applications, setApplications] = useState([])
    const handleAddRoomClick = async (idTypeHotel, nameTypeHotel) => {
        try {
            const a = await City.checkRoom(idTypeHotel, jwtDecode(localStorage.getItem("JWT")).sub,JSON.parse(localStorage.getItem("HOTEL")).startDate, JSON.parse(localStorage.getItem("HOTEL")).endDate);
            console.log("kieerm tar : " + a)
            if (a > 0) {
                await City.checkAddRoom(idTypeHotel, jwtDecode(localStorage.getItem("JWT")).sub, JSON.parse(localStorage.getItem("HOTEL")).startDate, JSON.parse(localStorage.getItem("HOTEL")).endDate)
                toast.success(`Thêm phòng ${nameTypeHotel}`, {
                    autoClose: 1000,
                })
            } else {
                toast.error(`Phòng ${nameTypeHotel} bạn chọn đã đạt số lượng tối đa`);
            }
        } catch (error) {
            toast.error(`Vui lòng đăng nhập`);
            navigate("/login")
        }
    };
    const handlePaymentClick = async () => {
        try {
            const check = await City.checkPay(id, jwtDecode(localStorage.getItem("JWT")).sub, JSON.parse(localStorage.getItem("HOTEL")).startDate, JSON.parse(localStorage.getItem("HOTEL")).endDate)
            if (check == 0) {
                toast.error(`Mời bạn vui lòng chọn phòng trước khi thanh toán`)
            } else {
                navigate(`/pay/${id}`)
            }
        } catch (error) {
            toast.error(`Mời bạn vui lòng chọn phòng trước khi thanh toán`)
        }
    };
    const getAll = async () => {
        try {
            const hotelData = await City.getHotel(id);
            const typeHotelData = await City.getTypeHotel(id, JSON.parse(localStorage.getItem("HOTEL")).startDate, JSON.parse(localStorage.getItem("HOTEL")).endDate);
            const imageHotelData = await City.getImageHotel(id);
            const applications = await City.getApplications(id);
            setHotel(hotelData);
            setTypeHotel(typeHotelData);
            setImageHotel(imageHotelData);
            setApplications(applications);
            document.title = "Catland Booking - " + hotelData.nameHotel;

        } catch (error) {
            console.error("Error fetching data:", error);
        }
    }
    useEffect(() => {
        getAll();
    }, []);

    return (
        hotel &&
        <>
            <Header/>
            <div className="house-details">
                <div className="house-title">
                    <h1>{hotel.nameHotel}</h1>
                    <div className="row">
                        <div>
                            <p><FontAwesomeIcon icon={faMapMarkerAlt}/>{hotel.addressHotel}</p>
                        </div>
                    </div>
                </div>
                <div className="gallery">
                    <div className="gallery-img-1">
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[0].urlImageAvatar} alt="Hotel Avatar"/>
                        )}
                    </div>
                    <div>
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[1].urlImageAvatar} alt="Hotel Avatar"/>
                        )}
                    </div>
                    <div>
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[2].urlImageAvatar} alt="Hotel Avatar"/>
                        )}                    </div>
                    <div>
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[3].urlImageAvatar} alt="Hotel Avatar"/>
                        )}
                    </div>
                    <div>
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[4].urlImageAvatar} alt="Hotel Avatar"/>
                        )}
                    </div>
                </div>
                <div className="small-details">
                    <h2>{hotel.descriptionHotel}</h2>
                    <p>Giá phòng mỗi đêm từ </p>
                    <h4>{hotel.minPriceTypeHotel.toLocaleString('vi-VN')} VND </h4>
                    <button onClick={handlePaymentClick}>Thanh toán</button>
                </div>
                <hr className="line"/>
                <ul className="details-list">
                    {applications.map((application) => {
                        if (application.idApplicationsHotel === 6) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon class="icon-font" icon={faWifi}/> Wifi miễn phí trong tất cả các
                                    phòng
                                </li>
                            );
                        } else if (application.idApplicationsHotel === 2) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon icon={faUtensils}/> Nhà hàng
                                </li>
                            );
                        } else if (application.idApplicationsHotel === 3) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon icon={faClock}/> Lễ tân phục vụ 24/7
                                </li>
                            );
                        } else if (application.idApplicationsHotel === 4) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon icon={faCar}/> Bãi đậu xe miễn phí
                                </li>
                            );
                        } else if (application.idApplicationsHotel === 5) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon icon={faElevator}/> Thay máy riêng
                                </li>
                            );
                        } else if (application.idApplicationsHotel === 1) {
                            return (
                                <li key={application.id}>
                                    <FontAwesomeIcon icon={faSnowflake}/> Máy Lạnh
                                </li>
                            );
                        } else {
                            // Nếu có thêm các điều kiện khác, bạn có thể thêm ở đây
                            return null;
                        }
                    })}

                </ul>
                <p className="home-desc">
                    Add peace of mind with Hilton CleanStay when you book your stay here.
                    Centrally located in New York (NY)'s Financial District, this property
                    places you close to exciting attractions and dining options. Don't leave
                    before visiting famous Central Park. Rated 4 stars, this high-quality
                    property offers access to an on-site restaurant and gym.
                </p>
                <hr className="line"/>
                {typeHotel.map((typeHotel) => (
                    <div className="house" key={typeHotel.idTypeHotel}>
                        <div className="house-img">
                            <Swiper
                                style={{
                                    '--swiper-navigation-color': '#fff',
                                    '--swiper-pagination-color': '#fff',
                                }}
                                spaceBetween={10}
                                navigation={true}
                                // thumbs={{swiper: thumbsSwiper && !thumbsSwiper.destroyed ? thumbsSwiper : null}}
                                modules={[FreeMode, Navigation, Thumbs]}
                                className="mySwiper2"
                            >
                                {imageHotel
                                    .filter((image) => image.typeRoomHotel?.idTypeHotel === typeHotel?.idTypeHotel)
                                    .map((filteredImage) => (
                                        <SwiperSlide key={filteredImage.id}>
                                            {filteredImage && (
                                                <img src={filteredImage.urlImageAvatar} alt="Image"/>
                                            )}
                                        </SwiperSlide>
                                    ))}
                            </Swiper>
                            <Swiper
                                // onSwiper={setThumbsSwiper}
                                spaceBetween={10}
                                slidesPerView={4}
                                freeMode={true}
                                watchSlidesProgress={true}
                                modules={[FreeMode, Navigation, Thumbs]}
                                className="mySwiper"
                            >
                                {imageHotel
                                    .filter((image) => image.typeRoomHotel?.idTypeHotel === typeHotel?.idTypeHotel)
                                    .map((filteredImage) => (
                                        <SwiperSlide key={filteredImage.id}>
                                            {filteredImage && (
                                                <img src={filteredImage.urlImageAvatar} alt="Image"/>
                                            )}
                                        </SwiperSlide>
                                    ))}
                            </Swiper>
                        </div>
                        <div className="house-infoo">
                            <h3>{typeHotel.nameTypeHotel}</h3>
                            <p><FontAwesomeIcon icon={faBed}/> {typeHotel.quantityBed} Giường &nbsp;&nbsp;
                                <FontAwesomeIcon icon={faUser}/>{typeHotel.numberGuests} khách</p>
                            <i className="fas fa-star-half-alt"></i>
                            <div className="house-price">
                                <p className="room">(Chỉ còn {typeHotel.available} phòng )</p>
                                <h6>{(typeHotel.priceTypeHotel * 5.82573).toLocaleString('vi-VN')} VND</h6>
                                <h4>{typeHotel.priceTypeHotel.toLocaleString('vi-VN')} <span> VND </span></h4>
                                <p>/ phòng / đêm </p>
                                <button
                                    onClick={() => handleAddRoomClick(typeHotel.idTypeHotel, typeHotel.nameTypeHotel)}>Thêm
                                    phòng
                                </button>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </>
    );
};


export default HouseDetails;
