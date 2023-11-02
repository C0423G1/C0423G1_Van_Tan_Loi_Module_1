import React, {useState} from "react";
import "./modal.css";

function ModalLogin(props) {
    const [activeTab, setActiveTab] = useState("Login");

    const openTab = (tabName) => {
        setActiveTab(tabName);
    };

    const closeModal = () => {
        props.closeModal();
    };

    return (
        <>
            <div id="abc"></div>
            <div className="modal">
                <div className="modal-content">
                    <span className="close" onClick={closeModal}>&times;</span>
                    <div className="tabs">
                        <button
                            className={`tablinks ${activeTab === "Login" ? "active" : ""}`}
                            onClick={() => openTab("Login")}
                        >
                            Login
                        </button>
                        <button
                            className={`tablinks ${activeTab === "Register" ? "active" : ""}`}
                            onClick={() => openTab("Register")}
                        >
                            Register
                        </button>
                    </div>

                    {activeTab === "Login" && (
                        <div className="tabcontent">
                            <form>
                                <div className="input-container">
                                    <label htmlFor="username">Username</label>
                                    <input type="text" id="username" placeholder="Enter your username"/>
                                </div>
                                <div className="input-container">
                                    <label htmlFor="password">Password</label>
                                    <input type="password" id="password" placeholder="Enter your password"/>
                                    <a href="#" className="forgot-password">
                                        Forgot Password?
                                    </a>
                                </div>
                                <button type="submit">Login</button>
                            </form>
                        </div>
                    )}
                    {activeTab === "Register" && (
                        <div className="tabcontent">
                            <form>
                                <div className="input-container">
                                    <label htmlFor="username">Username</label>
                                    <input type="text" id="username" placeholder="Choose a username"/>
                                </div>
                                <div className="input-container">
                                    <label htmlFor="email">Email</label>
                                    <input type="email" id="email" placeholder="Enter your email"/>
                                </div>
                                <div className="input-container">
                                    <label htmlFor="password">Password</label>
                                    <input type="password" id="password" placeholder="Choose a password"/>
                                </div>
                                <button type="submit">Register</button>
                            </form>
                        </div>
                    )}
                </div>
            </div>
        </>
    );
}

export default ModalLogin;
