import React, { useState } from "react";
import "./modal.css";

function Login() {
    return (
        <div className="tabcontent">
            <form>
                <div className="input-container">
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" placeholder="Enter your username" />
                </div>
                <div className="input-container">
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" placeholder="Enter your password" />
                    <a href="#" className="forgot-password">
                        Forgot Password?
                    </a>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

function Register() {
    return (
        <div className="tabcontent">
            <form>
                <div className="input-container">
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" placeholder="Choose a username" />
                </div>
                <div className="input-container">
                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" placeholder="Enter your email" />
                </div>
                <div className="input-container">
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" placeholder="Choose a password" />
                </div>
                <button type="submit">Register</button>
            </form>
        </div>
    );
}

function App() {
    const [activeTab, setActiveTab] = useState("Login");
    return (
        <div>
            <div id="abc"></div>
            <div className="tabs">
                <button
                    className={`tablinks ${activeTab === "Login" ? "active" : ""}`}
                    onClick={() => setActiveTab("Login")}
                >
                    Login
                </button>
                <button
                    className={`tablinks ${activeTab === "Register" ? "active" : ""}`}
                    onClick={() => setActiveTab("Register")}
                >
                    Register
                </button>
            </div>

            {activeTab === "Login" ? <Login /> : <Register />}
        </div>
    );
}

export default App;
