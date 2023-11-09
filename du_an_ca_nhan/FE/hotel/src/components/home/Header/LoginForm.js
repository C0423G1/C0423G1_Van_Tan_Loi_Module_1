import React, { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';

import * as UserService from '../../../service/APICity/UserService';

function LoginForm({ toggleForm }) {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        userName: '',
        pass: '',
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const result = await UserService.loginUser(formData);
            UserService.addJwtTokenToLocalStorage(result.data.jwtToken);
            const { userName, pass } = formData;
            console.log('Đăng nhập thành công với các giá trị sau:');
            console.log('Email:', userName);
            console.log('Mật khẩu:', pass);
            console.log(localStorage.getItem('JWT'));
            console.log('---------------------------------');
            console.log(jwtDecode(localStorage.getItem('JWT')));
            setFormData({
                userName: '',
                pass: '',
            });

            Swal.fire({
                icon: 'success',
                title: 'Đăng nhập thành công!',
                showConfirmButton: false,
                timer: 1500,
            });
            navigate('/');
        } catch (error) {
            console.log("-------------")
            Swal.fire({
                icon: 'error',
                title: 'Đăng nhập thất bại',
                text: 'Vui lòng kiểm tra lại email và mật khẩu.',
            });
            navigate('/login');
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
        <div className="form-box login">
            <form onSubmit={handleSubmit}>
                <h2>Sign In</h2>
                <div className="input-box">
                    <span className="icon"><FontAwesomeIcon icon={faEnvelope} /></span>
                    <input
                        type="string"
                        id="userName"
                        name="userName"
                        value={formData.userName}
                        onChange={handleChange}
                        required
                    />
                    <label>Email</label>
                </div>
                <div className="input-box">
                    <span className="icon"><FontAwesomeIcon icon={faLock} /></span>
                    <input
                        type="password"
                        id="pass"
                        name="pass"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                    <label>Password</label>
                </div>
                <div className="remember-password">
                    <label htmlFor="remember"><input type="checkbox" id="remember" />Remember Me</label>
                    <a href="#">Forget Password</a>
                </div>
                <button className="btn" type="submit">Login In</button>
                <div className="create-account">
                    <p>Create A New Account? <a href="#" className="register-link" onClick={toggleForm}>Sign Up</a></p>
                </div>
            </form>
        </div>
    );
}

export default LoginForm;
