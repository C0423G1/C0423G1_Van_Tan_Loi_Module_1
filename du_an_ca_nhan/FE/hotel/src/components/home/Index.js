import React, {useEffect, useState} from "react";
import "../../App.css";
import {Link, useNavigate, useParams} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt} from "@fortawesome/free-solid-svg-icons";
import ModalLogin from "./Login/ModalLogin";
import * as City from "../../service/APICity/City";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-dates/initialize"
import "react-dates/lib/css/_datepicker.css";
import {DateRangePicker} from "react-dates";
import {jwtDecode} from "jwt-decode";

function Index() {
    const navigate = useNavigate()
    const [isModalOpen, setModalOpen] = useState(false);
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

    const closeModal = () => {
        setModalOpen(false);
    };

    const openModal = () => {
        setModalOpen(true);
    };
    const handleRegister = () => {
        navigate("/login");
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        localStorage.removeItem("JWT");
        setUsername("");
    };
    const addSreach = () => {
        console.log("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
        console.log(startDate)
        const hotel = {
            numberOfGuests: numberOfGuests,
            startDate: startDate._d,
            endDate: endDate,
            selectedLocation: selectedLocation
        }
        City.addSreach(hotel);
    }

    const handleSearch = () => {
        localStorage.removeItem("HOTEL")
        console.log("Search Term:", searchTerm);
        console.log("Selected Location:", selectedLocation);
        if (startDate && endDate && numberOfGuests >= 0) {
            console.log("Check-In Date:", startDate);
            console.log("Check-Out Date:", endDate);
            console.log("Number of Guests:", numberOfGuests);
            addSreach()
            navigate(`/list`);
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
        document.title = 'Catland Booking - Trang Chủ';
    }, []);

    return (
        <div className="App">
            <div className="header">
                <nav>
                    <Link to={"/"}>
                        <img src={"/images/snapedit_1699853351032.png"} className="logo" alt="Logo"/>
                    </Link>
                    {isLoggedIn ? (
                        <div className="user-info">
                            <span>Xin chào, {username}</span>
                            <a href="#" className="logout-btn" onClick={handleLogout}>
                                <FontAwesomeIcon icon={faSignInAlt}/> Đăng xuất
                            </a>
                        </div>
                    ) : (
                        <a href="#" className="register-btn" onClick={handleRegister}>
                            <FontAwesomeIcon icon={faSignInAlt}/> Đăng nhập / Đăng Kí
                        </a>
                    )}
                </nav>
                <div className="container">
                    <h1>Tìm kỳ nghỉ của bạn</h1>
                    <div className="search-bar">
                        <form>
                            <div className="location-input">
                                <label>Thành phố</label>
                                <input
                                    type="text"
                                    placeholder="Bạn muốn đến ?"
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
                            <div className="location-input">
                                <label>Nhận
                                    phòng &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Trả
                                    phòng</label>
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
                                <label>Khách</label>
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
            </div>
            {isModalOpen && <ModalLogin closeModal={closeModal}/>}
        </div>
    );
}

export default Index;
