import axios from "axios";

export const loginUser = async (appUser) => {
    console.log(appUser)
    const result = await axios.post(`http://localhost:8080/api/user/login-by-username`, appUser)
    console.log(result)
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