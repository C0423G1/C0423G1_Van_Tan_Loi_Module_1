import React, { useEffect, useState } from "react";
import "../../App.css";
import {Link, useNavigate} from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import ModalLogin from "./ModalLogin";
import * as City from "../../service/APICity/City";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-dates/initialize"
import "react-dates/lib/css/_datepicker.css";
import { DateRangePicker } from "react-dates";

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

    const getCity = async () => {
        setCity(await City.getCity());
    };

    const closeModal = () => {
        setModalOpen(false);
    };

    const openModal = () => {
        setModalOpen(true);
    };

    const handleSearch = () => {
        console.log("Search Term:", searchTerm);
        console.log("Selected Location:", selectedLocation);
        if (startDate && endDate && numberOfGuests >= 0) {
            console.log("Check-In Date:", startDate);
            console.log("Check-Out Date:", endDate);
            console.log("Number of Guests:", numberOfGuests);
            navigate(`/list?searchTerm=${searchTerm}&selectedLocation=${selectedLocation}&startDate=${startDate}&endDate=${endDate}&numberOfGuests=${numberOfGuests}`);
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
    }, []);

    return (
        <div className="App">
            <div className="header">
                <nav>
                    <Link to={"/"}>
                        <img src={"/images/logo.png"} className="logo" alt="Logo" />
                    </Link>
                    <button className="register-btn" onClick={openModal}>
                        <FontAwesomeIcon icon={faUser} />
                    </button>
                </nav>
                <div className="container">
                    <h1>Find Your Next Stay</h1>
                    <div className="search-bar">
                        <form>
                            <div className="location-input">
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
                                        <option key={city.id} value={city.name} />
                                    ))}
                                </datalist>
                            </div>
                            <div className="location-input">
                                <label>Check in &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Check out</label>
                                <DateRangePicker
                                    startDate={startDate}
                                    startDateId="your_unique_start_date_id"
                                    endDate={endDate}
                                    endDateId="your_unique_end_date_id"
                                    onDatesChange={({ startDate, endDate }) => {
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
                                    onChange={(e) => setNumberOfGuests(Math.max(0, parseInt(e.target.value, 10)))} // Giới hạn số lượng khách tối thiểu là 0
                                />
                            </div>
                            {startDate && endDate && numberOfGuests && <button type="button" onClick={handleSearch}>
                                <img src="/images/search.png" alt="Search" />
                            </button>}
                        </form>
                    </div>
                </div>
            </div>
            {isModalOpen && <ModalLogin closeModal={closeModal} />}
        </div>
    );
}

export default Index;
