import React, {useState} from "react";
import "./modal.css";
import Login from "./Login";
import Register from "./Register";


function LoginModal() {
    const [activeTab, setActiveTab] = useState("Login");
    return (
        <div className="back-round">
            <video id="Video1" className="bgvid back" autoPlay="true" muted="muted" preload="auto" loop>
                <source src="https://cdn.pixabay.com/vimeo/256955049/saigon-14385.mp4?width=1280&hash=3e5f8905ae9db3698a79a23e073f7818717a8b4d" type="video/mp4"/>
            </video>
                <div id="abc">
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
                    {activeTab === "Login" ? <Login/> : <Register/>}
                </div>
        </div>
    );
}

export default LoginModal;
