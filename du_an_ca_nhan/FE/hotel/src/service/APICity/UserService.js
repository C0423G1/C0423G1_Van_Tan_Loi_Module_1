import axios from "axios";
import loginForm from "../../components/home/Header/LoginForm";

export const loginUser = async (appUser) => {
    console.log(appUser)
    const result = await axios.post(`http://localhost:8080/api/user/login-by-username`, appUser)
    return result;
}

export const addJwtTokenToLocalStorage = (jwtToken) => {
    localStorage.setItem("JWT", jwtToken);
}

export const registerUser = async (appUser) => {
    console.log(appUser)
    const result = await axios.post(`http://localhost:8080/api/user/register-by-customer`, appUser)
    return result;
}