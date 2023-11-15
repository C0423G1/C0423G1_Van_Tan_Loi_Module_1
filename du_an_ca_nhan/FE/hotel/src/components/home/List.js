import React, {useEffect, useState} from 'react';
import Header from './Header';
import {Link} from 'react-router-dom';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faMapMarkerAlt} from '@fortawesome/free-solid-svg-icons';
import * as City from '../../service/APICity/City';
import ReactPaginate from 'react-paginate';
import '../../App.css';

function truncateString(str) {
    return str.length > 25 ? str.slice(0, 25) + '...' : str;
}

const List = () => {
    const [city, setCity] = useState([]);
    const [currentPage, setCurrentPage] = useState(0);
    const itemsPerPage = 10;
    const handlePageClick = (data) => {
        setCurrentPage(data.selected);
    };

    const displayedCity = city.slice(
        currentPage * itemsPerPage,
        (currentPage + 1) * itemsPerPage
    );

    useEffect(() => {
        const fetchData = async () => {
            await City.getList(JSON.parse(localStorage.getItem('HOTEL')));
            setCity(JSON.parse(localStorage.getItem('LIST')));
        };
        fetchData();
        document.title = "Catland Booking - Khách sạn ở " + JSON.parse(localStorage.getItem('HOTEL')).selectedLocation
    }, [city]);

    return (
        <>
            <Header/>
            <div className="container">
                <div className="list-container">
                    <div className="left-col">
                        <h1>Thành phố bạn lưu trú : {JSON.parse(localStorage.getItem('HOTEL')).selectedLocation}</h1>
                        {displayedCity.map((hotel) => (
                            <Link to={`/detail/${hotel.idHotel}`} key={hotel.idHotel}>
                                <div className="house">
                                    <div className="house-img">
                                        <img src={hotel.urlImage} alt="House Image"/>
                                    </div>
                                    <div className="house-info">
                                        <p>
                                            <FontAwesomeIcon icon={faMapMarkerAlt}/> {hotel.addressHotel}
                                        </p>
                                        <h3>{truncateString(hotel.nameHotel)}</h3>
                                        <p>{hotel.descriptionHotel}</p>
                                        <div className="house-price">
                                            <h6>{(hotel.minPriceTypeHotel * 5.82573).toLocaleString('vi-VN')} VND</h6>
                                            <h4>{hotel.minPriceTypeHotel.toLocaleString('vi-VN')} VND<span></span></h4>
                                            <button>Xem ngay</button>
                                        </div>
                                    </div>
                                </div>
                            </Link>
                        ))}
                    </div>
                    <div className="right-col">
                        <div className="sidebar">
                            <h2>Select filters</h2>
                            <h3>Property Type</h3>
                            <div className="filter">
                                <input type="checkbox"/>
                                <p>House</p> <span>(0)</span>
                            </div>
                            <div className="filter">
                                <input type="checkbox"/>
                                <p>Villa</p> <span>(0)</span>
                            </div>
                            <div className="filter">
                                <input type="checkbox"/>
                                <p>Room</p> <span>(0)</span>
                            </div>
                            <div className="filter">
                                <input type="checkbox"/>
                                <p>Hostel</p> <span>(0)</span>
                            </div>
                        </div>
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
        </>
    );
};

export default List;
