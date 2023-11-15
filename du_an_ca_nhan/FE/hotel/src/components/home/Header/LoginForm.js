import React, {useEffect, useState} from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faLock, faUser} from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import {useNavigate} from 'react-router-dom';
import {jwtDecode} from 'jwt-decode';
import * as UserService from '../../../service/APICity/UserService';
import FacebookLogin from 'react-facebook-login';
import {gapi} from 'gapi-script';
import {GoogleLogin, GoogleLogout} from "react-google-login";

function formatName(originalName) {
    const words = originalName.toLowerCase().split(' ');
    const formattedWords = words.map((word) => word.charAt(0).toUpperCase() + word.slice(1));
    return formattedWords.join(' ');
}

function LoginForm({toggleForm}) {
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
            const {userName, pass} = formData;
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
            console.log('-------------');
            Swal.fire({
                icon: 'error',
                title: 'Đăng nhập thất bại',
                text: 'Vui lòng kiểm tra lại email và mật khẩu.',
            });
            navigate('/login');
        }
    };

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const responseFacebook = async (response) => {
        try {
            const loginResult = await UserService.loginUser({
                userName: formatName(response.name),
                pass: response.id,
            });
            UserService.addJwtTokenToLocalStorage(loginResult.data.jwtToken);
            Swal.fire({
                icon: 'success',
                title: 'Đăng nhập thành công!',
                showConfirmButton: false,
                timer: 1500,
            });
            navigate('/');
        } catch (error) {
            console.log(error.response.data);
            Swal.fire({
                icon: 'error',
                title: 'Đăng ký thất bại',
                text: 'Có lỗi xảy ra khi đăng ký hoặc đăng nhập. Vui lòng thử lại sau.',
            });
            navigate('/login');
        }
    };
    const [isGoogleSignedIn, setIsGoogleSignedIn] = useState(false);

    const onSuccess = async (res) => {
        console.log("LOGIN SUCCESS", res.profileObj)
        try {
            const loginResult = await UserService.loginUser({
                userName: formatName(res.profileObj.name),
                pass: res.googleId,
            });
            UserService.addJwtTokenToLocalStorage(loginResult.data.jwtToken);
            Swal.fire({
                icon: 'success',
                title: 'Đăng nhập thành công!',
                showConfirmButton: false,
                timer: 1500,
            });
            navigate('/');
        } catch (error) {
            console.log(error.response.data);
            Swal.fire({
                icon: 'error',
                title: 'Đăng ký thất bại',
                text: 'Có lỗi xảy ra khi đăng ký hoặc đăng nhập. Vui lòng thử lại sau.',
            });
            navigate('/login');
        }
    }

    const onFailure = (res) => {
        console.log("LOGIN FAILED", res)
    }

    useEffect(() => {
        function start() {
            gapi.client.init({
                clientId: "",
                scope: ""
            }).then(() => {
                if (isGoogleSignedIn) {

                }
            });
        }

        gapi.load('client:auth2', start);
    }, [isGoogleSignedIn]);
    return (
        <div className="form-box login">
            <form onSubmit={handleSubmit}>
                <h2>Đăng Nhập </h2>
                <div className="input-box">
          <span className="icon">
            <FontAwesomeIcon icon={faUser}/>
          </span>
                    <input
                        type="string"
                        id="userName"
                        name="userName"
                        value={formData.userName}
                        onChange={handleChange}
                        required
                    />
                    <label>Tài Khoản</label>
                </div>
                <div className="input-box">
          <span className="icon">
            <FontAwesomeIcon icon={faLock}/>
          </span>
                    <input
                        type="password"
                        id="pass"
                        name="pass"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                    <label>Mật khẩu</label>
                </div>
                <div className="remember-password">
                    <label htmlFor="remember">
                        <input type="checkbox" id="remember"/>
                        Lưu mật khẩu{' '}
                    </label>
                    <a href="#">Quên mật khẩu </a>
                </div>
                <button className="btn" type="submit">
                    Đăng nhập
                </button>
                <hr></hr>
                <div className="fb-gg-container">

                    <FacebookLogin
                        appId="893376725832823"
                        autoLoad={false}
                        fields="name,email,picture"
                        callback={responseFacebook}
                        icon="fa-facebook"
                        textButton="Facebook"
                        className="fb-button"
                    />
                    <GoogleLogin
                        clientId="373552425846-n9so298q7fo3cvul1kvslmgafhkrao0c.apps.googleusercontent.com"
                        buttonText="GOOGLE"
                        onSuccess={onSuccess}
                        onFailure={onFailure}
                        cookiePolicy={'single_host_origin'}
                        isSignedIn={false}
                        className="google"
                    />
                </div>

                <div className="create-account">
                    <p>
                        Bạn chưa có tài khoản?{' '}
                        <a href="#" className="register-link" onClick={toggleForm}>
                            Đăng kí
                        </a>
                    </p>
                </div>
            </form>
        </div>
    );
}

export default LoginForm;
