import React, {useEffect, useState} from 'react';
import "../../App.css";
import {Link, useNavigate} from "react-router-dom";
import {DateRangePicker} from "react-dates";
import * as City from "../../service/APICity/City";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt} from "@fortawesome/free-solid-svg-icons";
import {jwtDecode} from "jwt-decode";
import moment from "moment";

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
    const [customer, setCustomer] = useState(null);
    const getCity = async () => {
        setCity(await City.getCity());
    };
    const getAllStart = async () => {
        const storedHotel = JSON.parse(localStorage.getItem("HOTEL"));
        setNumberOfGuests(storedHotel.numberOfGuests)
        setSelectedLocation(storedHotel.selectedLocation)
        setStartDate(moment(storedHotel.startDate));
        setEndDate(moment(storedHotel.endDate));
    };
    const getAll = async () => {
        localStorage.removeItem("HOTEL")
        const hotel = {
            numberOfGuests: numberOfGuests,
            startDate: startDate,
            endDate: endDate,
            selectedLocation: selectedLocation
        }
        City.addSreach(hotel)
        getAllStart()
        navigate("/list")
    };


    const handleSearch = async () => {
        localStorage.removeItem("HOTEL")
        console.log("Search Term:", searchTerm);
        console.log("Selected Location:", selectedLocation);
        if (startDate && endDate && numberOfGuests >= 0) {
            console.log("Check-In Date:", startDate);
            console.log("Check-Out Date:", endDate);
            console.log("Number of Guests:", numberOfGuests);
            await getAll()
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
        getAllStart()
        if (localStorage.getItem("JWT")) {
            setIsLoggedIn(true);
            setUsername(jwtDecode(localStorage.getItem("JWT")).sub);
        }
        const fetchData = async () => {
            try {
                const user = await City.getUser(jwtDecode(localStorage.getItem('JWT')).sub);
                setCustomer(user);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };

        fetchData();
    }, []);
    const handleRegister = () => {
        navigate("/login");
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        localStorage.removeItem("JWT");
        localStorage.removeItem("HOTEL")
        setUsername("");
        navigate("/")
    };

    return (
        <nav id="navBar" className="nav-white-listing">
            <Link to={"/"}><img src={"/images/snapedit_1699853351032.png"} className="logo"/></Link>
            <div className="container">
                <div className="search-bar-listing">
                    <form>
                        <div className="location-input-listing">
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
                        <div className="location-input-listing">
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
            <div className="dropdown">
                 <span className="dropdown-btn">
                  {isLoggedIn ? `Xin chào, ${username} ` : 'Đăng nhập '}
                  </span>

                <div className="dropdown-content">
                    {isLoggedIn ? (
                        <React.Fragment>
                            <Link to="/userform">
                                <div>Thông tin cá nhân</div>
                            </Link>
                            <Link to="/ordersuccess">
                                <div>Đơn đặt chỗ</div>
                            </Link>
                            <div onClick={handleLogout}>Đăng xuất</div>
                        </React.Fragment>
                    ) : (
                        <div onClick={handleRegister}>
                            Đăng nhập
                        </div>
                    )}
                </div>
            </div>
        </nav>
    );
};

export default Header;
