import React, { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faTwitter, faYoutube, faInstagram, faLinkedin ,faXing} from '@fortawesome/free-brands-svg-icons';
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import './style.css';


function Login() {
    const [isLoginForm, setIsLoginForm] = useState(true);

    const toggleForm = () => {
        setIsLoginForm(!isLoginForm);
    };

    return (
        <div className="A">
            <div className="background"></div>
            <div className="container">
                <div className="item">
                    <h2 className="logo"><FontAwesomeIcon icon={faXing} />Hash Techie</h2>
                    <div className="text-item">
                        <h2>Welcome! <br/><span>To Our Channel</span></h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, repellendus?</p>
                        <div className="social-icon">
                            <a href="#"><FontAwesomeIcon icon={faFacebook} /></a>
                            <a href="#"><FontAwesomeIcon icon={faTwitter} /></a>
                            <a href="#"><FontAwesomeIcon icon={faYoutube} /></a>
                            <a href="#"><FontAwesomeIcon icon={faInstagram} /></a>
                            <a href="#"><FontAwesomeIcon icon={faLinkedin} /></a>
                        </div>
                    </div>
                </div>
                <div className={`login-section ${isLoginForm ? 'active' : ''}`}>
                    {isLoginForm ? (
                        <LoginForm toggleForm={toggleForm} />
                    ) : (
                        <RegisterForm toggleForm={toggleForm} />
                    )}
                </div>
            </div>
        </div>
    );}
export default Login;