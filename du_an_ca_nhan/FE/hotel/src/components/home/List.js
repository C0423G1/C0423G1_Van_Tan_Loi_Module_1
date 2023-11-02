import React, {useEffect, useState} from 'react';
import Header from "./Header";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faStar, faStarHalfAlt} from '@fortawesome/free-solid-svg-icons';
import * as City from "../../service/APICity/City";

const List = () => {
    const [city, setCity] = useState([])
    const [selectedLocation, setSelectedLocation] = useState("Thành Phố Đà Nẵng");
    const [startDate, setStartDate] = useState("2023/11/11");
    const [endDate, setEndDate] = useState("2023/11/15");
    const [numberOfGuests, setNumberOfGuests] = useState(5);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(5);
    const getAll = async () => {
        setCity(await City.getList(pageSize, currentPage, numberOfGuests, endDate, startDate, selectedLocation));
    };
    useEffect(() => {
        getAll();
    }, []);

    return (
        <>
            <Header/>
            <div className="container">
                <div className="list-container">
                    <div className="left-col">
                        <p>200+ Options</p>
                        <h1>Recommended Places In San Francisco</h1>
                        <Link to={"/detail"}>
                            <div className="house">
                                <div className="house-img">
                                    <img src="/images/image-s1.png" alt="House Image"/>
                                </div>
                                <div className="house-info">
                                    <p>Private Villa in San Francisco</p>
                                    <h3>Deluxe Queen Room With Street View</h3>
                                    <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStarHalfAlt}/>
                                    <div className="house-price">
                                        <p>2 Guest</p>
                                        <h4>$100 <span>/ day</span></h4>
                                    </div>
                                </div>
                            </div>
                        </Link>
                        <Link to={"/detail"}>
                            <div className="house">
                                <div className="house-img">
                                    <img src="/images/image-s1.png" alt="House Image"/>
                                </div>
                                <div className="house-info">
                                    <p>Private Villa in San Francisco</p>
                                    <h3>Deluxe Queen Room With Street View</h3>
                                    <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStarHalfAlt}/>
                                    <div className="house-price">
                                        <p>2 Guest</p>
                                        <h4>$100 <span>/ day</span></h4>
                                    </div>
                                </div>
                            </div>
                        </Link>
                        <Link to={"/detail"}>
                            <div className="house">
                                <div className="house-img">
                                    <img src="/images/image-s1.png" alt="House Image"/>
                                </div>
                                <div className="house-info">
                                    <p>Private Villa in San Francisco</p>
                                    <h3>Deluxe Queen Room With Street View</h3>
                                    <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStarHalfAlt}/>
                                    <div className="house-price">
                                        <p>2 Guest</p>
                                        <h4>$100 <span>/ day</span></h4>
                                    </div>
                                </div>
                            </div>
                        </Link>
                        <Link to={"/detail"}>
                            <div className="house">
                                <div className="house-img">
                                    <img src="/images/image-s1.png" alt="House Image"/>
                                </div>
                                <div className="house-info">
                                    <p>Private Villa in San Francisco</p>
                                    <h3>Deluxe Queen Room With Street View</h3>
                                    <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStar}/>
                                    <FontAwesomeIcon icon={faStarHalfAlt}/>
                                    <div className="house-price">
                                        <p>2 Guest</p>
                                        <h4>$100 <span>/ day</span></h4>
                                    </div>
                                </div>
                            </div>
                        </Link>
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
                    <img src="/images/arrow.png" alt="Left Arrow"/>
                    <span className="current">1</span>
                    <span>2</span>
                    <span>3</span>
                    <span>4</span>
                    <span>5</span>
                    <span>&middot;&middot;&middot;&middot;</span>
                    <span>20</span>
                    <img src="/images/arrow.png" alt="Right Arrow" className="right-arrow"/>
                </div>
            </div>
        </>
    );
};

export default List;
