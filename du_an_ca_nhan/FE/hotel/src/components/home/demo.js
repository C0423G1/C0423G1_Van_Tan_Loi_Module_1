import React, {useRef, useState} from 'react';
// Import Swiper React components
import {Swiper, SwiperSlide} from 'swiper/react';

// Import Swiper styles
import 'swiper/css';
import 'swiper/css/free-mode';
import 'swiper/css/navigation';
import 'swiper/css/thumbs';

import './style.css';

import {FreeMode, Navigation, Thumbs} from 'swiper/modules';

export default function A() {
    const [thumbsSwiper, setThumbsSwiper] = useState(null);
    const [thumbsSwiper2, setThumbsSwiper2] = useState(null);

    return (
        <>
            <Swiper
                style={{
                    '--swiper-navigation-color': '#fff',
                    '--swiper-pagination-color': '#fff',
                }}
                loop={true}
                spaceBetween={10}
                navigation={true}
                thumbs={{swiper: thumbsSwiper && !thumbsSwiper.destroyed ? thumbsSwiper : null}}
                modules={[FreeMode, Navigation, Thumbs]}
                className="mySwiper2 top-swiper"
            >
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>

            </Swiper>
            <Swiper
                onSwiper={setThumbsSwiper}
                loop={true}
                spaceBetween={10}
                slidesPerView={4}
                freeMode={true}
                watchSlidesProgress={true}
                modules={[FreeMode, Navigation, Thumbs]}
                className="mySwiper bottom-swiper"
            >

                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
            </Swiper>


            <Swiper
                style={{
                    '--swiper-navigation-color': '#fff',
                    '--swiper-pagination-color': '#fff',
                }}
                loop={true}
                spaceBetween={10}
                navigation={true}
                thumbs={{swiper: thumbsSwiper2 && !thumbsSwiper2.destroyed ? thumbsSwiper2 : null}}
                modules={[FreeMode, Navigation, Thumbs]}
                className="mySwiper2 top-swiper"
            >

                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
            </Swiper>
            <Swiper
                onSwiper={setThumbsSwiper2}
                loop={true}
                spaceBetween={10}
                slidesPerView={4}
                freeMode={true}
                watchSlidesProgress={true}
                modules={[FreeMode, Navigation, Thumbs]}
                className="mySwiper bottom-swiper"
            >

                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
                <SwiperSlide>
                    <div className="cus-img">
                        <img src="https://swiperjs.com/demos/images/nature-1.jpg"/>
                    </div>
                </SwiperSlide>
            </Swiper>
        </>
    );
}
