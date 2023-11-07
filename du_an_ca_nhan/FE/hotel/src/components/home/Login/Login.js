import React, { useState } from "react";
import "./modal.css";
import * as UserService from "../../../service/APICity/UserService";
import * as userService from "../../../service/APICity/UserService";
import Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";

function Login() {
    const navigate = useNavigate()
    const [formData, setFormData] = useState({
        userName: "",
        pass: "",
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const result = await UserService.loginUser(formData);
            userService.addJwtTokenToLocalStorage(result.data.jwtToken);
            const { userName, pass } = formData;
            console.log("Đăng nhập thành công với các giá trị sau:");
            console.log("Tên người dùng:", userName);
            console.log("Mật khẩu:", pass);
            setFormData({
                userName: "",
                pass: "",
            });
            Swal.fire({
                icon: 'success',
                title: 'Đăng nhập thành công!',
                showConfirmButton: false,
                timer: 1500
            });
            navigate("/")
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Đăng nhập thất bại',
                text: 'Vui lòng kiểm tra lại tên người dùng và mật khẩu.',
            });
            navigate("/")
        }
    };


    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    return (
        <div className="tabcontent">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label htmlFor="userName">Tên người dùng</label>
                    <input
                        type="text"
                        id="userName"
                        name="userName"
                        placeholder="Nhập tên người dùng"
                        value={formData.userName}
                        onChange={handleChange}
                    />
                </div>
                <div className="input-container">
                    <label htmlFor="pass">Mật khẩu</label>
                    <input
                        type="password"
                        id="pass"
                        name="pass"
                        placeholder="Nhập mật khẩu"
                        value={formData.password}
                        onChange={handleChange}
                    />
                    <a href="#" className="forgot-password">
                        Quên mật khẩu?
                    </a>
                </div>
                <button type="submit">Đăng nhập</button>
            </form>
        </div>
    );
}

export default Login;
