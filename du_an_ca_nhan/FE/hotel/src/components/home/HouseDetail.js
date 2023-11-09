import React, {useEffect, useState} from 'react';
import Header from "./Header";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faMapMarkerAlt} from '@fortawesome/free-solid-svg-icons';
import "../../App.css";
import {useParams} from "react-router-dom";
import * as City from "../../service/APICity/City";


// Import Swiper styles
import 'swiper/css';
import 'swiper/css/free-mode';
import 'swiper/css/navigation';
import 'swiper/css/thumbs';
import './style.css';
import {Swiper, SwiperSlide} from "swiper/react";
import {FreeMode, Navigation, Thumbs} from "swiper/modules";


const HouseDetails = () => {
    const [thumbsSwiper, setThumbsSwiper] = useState(null);
    const {id} = useParams()
    const [hotel, setHotel] = useState(null)
    const [typeHotel, setTypeHotel] = useState([])
    const [imageHotel, setImageHotel] = useState([])
    const getAll = async () => {
        setHotel(await City.getHotel(id))
        setTypeHotel(await City.getTypeHotel(id))
        setImageHotel(await City.getImageHotel(id))
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
                        {/*{imageHotel.map((imageHotel)=>(*/}
                        {imageHotel && imageHotel.length > 0 && (
                            <img src={imageHotel[0].urlImageAvatar} alt="Hotel Avatar"/>
                        )}
                        {/*// ))}*/}
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
                    <p>2 Guest &nbsp;&nbsp; 2 beds &nbsp;&nbsp; 1 bathroom </p>
                    <h4>${hotel.minPriceTypeHotel} /day</h4>
                </div>
                <hr className="line"/>
                <ul className="details-list">
                    <li>
                        <i className="fas fa-heart"></i>Entire Home
                        <span> You will have the entire flat for you</span>
                    </li>
                    <li>
                        <i className="fas fa-home"></i>Entire Home
                        <span> You will have the entire flat for you</span>
                    </li>
                    <li>
                        <i className="fas fa-home"></i>Entire Home
                        <span> You will have the entire flat for you</span>
                    </li>
                    <li>
                        <i className="fas fa-home"></i>Entire Home
                        <span> You will have the entire flat for you</span>
                    </li>
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
                                thumbs={{swiper: thumbsSwiper && !thumbsSwiper.destroyed ? thumbsSwiper : null}}
                                modules={[FreeMode, Navigation, Thumbs]}
                                className="mySwiper2"
                            >
                                {imageHotel
                                    .filter((image) => image.typeRoomHotel?.idTypeHotel === typeHotel?.idTypeHotel)
                                    .map((filteredImage) => (
                                        <SwiperSlide key={filteredImage.id}>
                                            {filteredImage && (
                                                <img src={filteredImage.urlImageAvatar} alt="Image" />
                                            )}
                                        </SwiperSlide>
                                    ))}
                            </Swiper>
                            <Swiper
                                onSwiper={setThumbsSwiper}
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
                                                <img src={filteredImage.urlImageAvatar} alt="Image" />
                                            )}
                                        </SwiperSlide>
                                    ))}
                            </Swiper>
                        </div>
                        <div className="house-info">
                            <p>Private Villa in San Francisco</p>
                            <h3>{typeHotel.nameTypeHotel}</h3>
                            <p>{typeHotel.quantityBed} Giường / 1 Bathroom / Wifi / Kitchen</p>
                            <i className="fas fa-star-half-alt"></i>
                            <div className="house-price">
                                <p>{typeHotel.numberGuests} Guest</p>
                                <h4>{typeHotel.priceTypeHotel} <span>/ day </span></h4>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </>
    );
};


export default HouseDetails;
