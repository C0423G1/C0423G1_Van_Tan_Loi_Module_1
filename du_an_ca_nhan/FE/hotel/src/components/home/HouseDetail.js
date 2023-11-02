import React from 'react';
import Header from "./Header";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faStar, faStarHalfAlt} from '@fortawesome/free-solid-svg-icons';
import "../../App.css";


const HouseDetails = () => {
    return (
        <>
            <Header/>
            <div className="house-details">
                <div className="house-title">
                    <h1>Wenge House</h1>
                    <div className="row">
                        <div>
                            <FontAwesomeIcon icon={faStar}/>
                            <FontAwesomeIcon icon={faStar}/>
                            <FontAwesomeIcon icon={faStar}/>
                            <FontAwesomeIcon icon={faStar}/>
                            <FontAwesomeIcon icon={faStarHalfAlt}/>
                            <span>245 Review</span>
                        </div>
                        <div>
                            <p>Location : San Francisco , California , United States</p>
                        </div>
                    </div>
                </div>
                <div className="gallery">
                    <div className="gallery-img-1">
                        <img src="/images/house-1.png"/>
                    </div>
                    <div>
                        <img src="/images/house-2.png"/>
                    </div>
                    <div>
                        <img src="/images/house-3.png"/>
                    </div>
                    <div>
                        <img src="/images/house-4.png"/>
                    </div>
                    <div>
                        <img src="/images/house-5.png"/>
                    </div>
                </div>
                <div className="small-details">
                    <h2>Entire rental unit hosted by Brandon</h2>
                    <p>2 Guest &nbsp;&nbsp; 2 beds &nbsp;&nbsp; 1 bathroom </p>
                    <h4>$100 /day</h4>
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
                <div className="house">
                    <div className="house-img">
                        <img src="/images/image-s1.png"/>
                    </div>
                    <div className="house-info">
                        <p>Private Villa in San Francisco</p>
                        <h3>Deluxe Queen Room With Street View</h3>
                        <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star-half-alt"></i>
                        <div className="house-price">
                            <p>2 Guest</p>
                            <h4>$100 <span>/ day </span></h4>
                        </div>
                    </div>
                </div>
                <div className="house">
                    <div className="house-img">
                        <img src="/images/image-s1.png"/>
                    </div>
                    <div className="house-info">
                        <p>Private Villa in San Francisco</p>
                        <h3>Deluxe Queen Room With Street View</h3>
                        <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star-half-alt"></i>
                        <div className="house-price">
                            <p>2 Guest</p>
                            <h4>$100 <span>/ day </span></h4>
                        </div>
                    </div>
                </div>
                <div className="house">
                    <div className="house-img">
                        <img src="/images/image-s1.png"/>
                    </div>
                    <div className="house-info">
                        <p>Private Villa in San Francisco</p>
                        <h3>Deluxe Queen Room With Street View</h3>
                        <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star-half-alt"></i>
                        <div className="house-price">
                            <p>2 Guest</p>
                            <h4>$100 <span>/ day </span></h4>
                        </div>
                    </div>
                </div>
                <div className="house">
                    <div className="house-img">
                        <img src="/images/image-s1.png"/>
                    </div>
                    <div className="house-info">
                        <p>Private Villa in San Francisco</p>
                        <h3>Deluxe Queen Room With Street View</h3>
                        <p>1 Bedroom / 1 Bathroom / Wifi / Kitchen</p>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star"></i>
                        <i className="fas fa-star-half-alt"></i>
                        <div className="house-price">
                            <p>2 Guest</p>
                            <h4>$100 <span>/ day </span></h4>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default HouseDetails;
