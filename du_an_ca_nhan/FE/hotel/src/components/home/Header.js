import React, {useEffect, useState} from 'react';
import "../../App.css";
import {Link, useNavigate} from "react-router-dom";
import {DateRangePicker} from "react-dates";
import * as City from "../../service/APICity/City";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt} from "@fortawesome/free-solid-svg-icons";
import {jwtDecode} from "jwt-decode";

const Header = () => {
    const navigate = useNavigate()
    const [city, setCity] = useState([]);
    const [searchTerm, setSearchTerm] = useState("");
    const [selectedLocation, setSelectedLocation] = useState("");
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [focusedInput, setFocusedInput] = useState(null);
    const [numberOfGuests, setNumberOfGuests] = useState(1);
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [username, setUsername] = useState("");
    const getCity = async () => {
        setCity(await City.getCity());
    };

    const handleSearch = () => {
        console.log("Search Term:", searchTerm);
        console.log("Selected Location:", selectedLocation);
        if (startDate && endDate && numberOfGuests >= 0) {
            console.log("Check-In Date:", startDate);
            console.log("Check-Out Date:", endDate);
            console.log("Number of Guests:", numberOfGuests);
            navigate("/list")
        } else {
            alert("Vui lòng kiểm tra ngày và số lượng khách.");
        }
    };

    useEffect(() => {
        const today = new Date();
        const checkIn = new Date(today);
        const checkOut = new Date(today);
        checkOut.setDate(checkOut.getDate() + 2);
        getCity();
        if (localStorage.getItem("JWT")) {
            setIsLoggedIn(true);
            setUsername(jwtDecode(localStorage.getItem("JWT")).sub);
        }
    }, []);
    const handleRegister = () => {
        navigate("/login");
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        localStorage.removeItem("JWT");
        setUsername("");
    };

    return (
        <nav id="navBar" className="nav-white-listing">
            <Link to={"/"}><img src={"/images/logo-red.png"} className="logo"/></Link>
            <div className="container">
                <div className="search-bar-listing">
                    <form>
                        <div className="location-input-listing">
                            <label>Location</label>
                            <input
                                type="text"
                                placeholder="Where are you going"
                                value={selectedLocation}
                                onChange={(e) => setSelectedLocation(e.target.value)}
                                list="search-options"
                            />
                            <datalist id="search-options">
                                {city.map((city) => (
                                    <option key={city.id} value={city.name}/>
                                ))}
                            </datalist>
                        </div>
                        <div className="location-input-listing">
                            <label>Check
                                in &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Check
                                out</label>
                            <DateRangePicker
                                startDate={startDate}
                                startDateId="your_unique_start_date_id"
                                endDate={endDate}
                                endDateId="your_unique_end_date_id"
                                onDatesChange={({startDate, endDate}) => {
                                    setStartDate(startDate);
                                    setEndDate(endDate);
                                }}
                                focusedInput={focusedInput}
                                onFocusChange={(focusedInput) => {
                                    setFocusedInput(focusedInput);
                                }}
                            />
                        </div>
                        <div>
                            <label>Guest</label>
                            <input
                                type="number"
                                value={numberOfGuests}
                                onChange={(e) => setNumberOfGuests(Math.max(0, parseInt(e.target.value, 10)))}
                            />
                        </div>
                        {startDate && endDate && numberOfGuests && <button type="button" onClick={handleSearch}>
                            <img src="/images/search.png" alt="Search"/>
                        </button>}
                    </form>
                </div>
            </div>
            {isLoggedIn ? (
                <div className="user-info">
                    <span>Xin chào, {username}</span>
                    <a href="#" className="logout-btn" onClick={handleLogout}>
                        <FontAwesomeIcon icon={faSignInAlt} /> Đăng xuất
                    </a>
                </div>
            ) : (
                <a href="#" className="register-btn" onClick={handleRegister}>
                    <FontAwesomeIcon icon={faSignInAlt} /> Đăng nhập / Đăng Kí
                </a>
            )}

        </nav>
    );
};

export default Header;
