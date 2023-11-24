import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faMapMarkerAlt} from "@fortawesome/free-solid-svg-icons";
import ReactPaginate from "react-paginate";
import React, {useEffect, useState} from "react";
import * as City from "../../service/APICity/City";
import {jwtDecode} from "jwt-decode";
import {differenceInDays, format, parseISO} from "date-fns";
import Header from "./Header";
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
const OrderSuccess = () => {
    const [city, setCity] = useState([]);
    const [currentPage, setCurrentPage] = useState(0);
    const itemsPerPage = 10;
    const displayedCity = city.slice(
        currentPage * itemsPerPage,
        (currentPage + 1) * itemsPerPage
    );
    useEffect(() => {
        const fetchData = async () => {
            try {
                const hotel = await City.OrderSuccess(jwtDecode(localStorage.getItem('JWT')).sub);
                setCity(hotel);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        fetchData();
        document.title = "Catland Booking - Chuyến đi của bạn ";
    }, []);
    const handlePageClick = (data) => {
        setCurrentPage(data.selected);
    };
    return (
        <>
            <Header/>
            <h1 style={{textAlign: "center",marginTop: "2%"}}>Đơn đặt chỗ </h1>
            <div className="order-success">
                <div className="container">
                    <div >
                        <div className="left-col">
                            {displayedCity && displayedCity.length > 0 ? (
                                displayedCity.map((hotel) => (
                                    <div className="house">
                                        <div className="house-img" style={{paddingTop:"2%"}}>
                                            <img src={hotel.urlImage} alt="House Image"/>
                                        </div>
                                        <div className="house-info"  style={{paddingTop:"2%"}}>
                                            <p>
                                                <FontAwesomeIcon icon={faMapMarkerAlt}/> {hotel.nameHotel}
                                            </p>
                                            <h3>{hotel.quantity} x {hotel.nameTypeHotel}</h3>
                                            <p>
                                                {formatDate(hotel.dateStart)} - {formatDate(hotel.dateEnd)}
                                            </p>
                                            <div className="house-price">
                                                <h4>{(hotel.sumPrice * hotel.quantity * (quantityDate(hotel.dateStart,hotel.dateEnd))).toLocaleString('vi-VN')} VND<span></span>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                ))
                            ) : (
                                <h4>Không có sản phẩm nào đã được thanh toán </h4>
                            )}
                        </div>
                        <div className="right-col">

                        </div>
                    </div>
                    <div className="pagination">
                        <ReactPaginate
                            previousLabel={<img src="/images/arrow.png" alt="Left Arrow"/>}
                            nextLabel={<img src="/images/arrow.png" alt="Right Arrow" className="right-arrow"/>}
                            breakLabel={'...'}
                            breakClassName={'break-me'}
                            pageCount={Math.ceil(city.length / itemsPerPage)}
                            marginPagesDisplayed={2}
                            pageRangeDisplayed={5}
                            onPageChange={handlePageClick}
                            containerClassName={'pagination'}
                            subContainerClassName={'pages pagination'}
                            activeClassName={'current'}
                            forcePage={currentPage}
                        />
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}
export default OrderSuccess;