import axios from "axios";

export const checkRoom = async (idTypeHotel, userName,startDate, endDate)=> {
    const a ={
        idTypeHotel, userName,startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10)
    }
    console.log(a)
    try {
        const res = await axios.post(`http://localhost:8080/api/check-room`, a);
        console.log(res)
        return res.data;
    } catch (e) {
        return [];
    }
}


export const pay = async (fullName, phoneNumber, idTypeHotel, startDate, endDate, userName) => {
    const a ={
        fullName,phoneNumber,idTypeHotel, startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10),userName
    }
    try {
        const res = await axios.post(`http://localhost:8080/api/pay`, a);
        return res.data;
    } catch (e) {
        return [];
    }
}


export const checkPayRoom = async (id, nameUser, startDate, endDate) => {
    const a = {
        id, nameUser, startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10)
    }
    try {
        const res = await axios.post(`http://localhost:8080/api/checkpayroom`, a);
        console.log(res.data)
        return res.data;
    } catch (e) {
        return false;
    }
};

export const checkPay = async (id, nameUser, startDate, endDate) => {
    const a = {
        id, nameUser, startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10)
    }
    try {
        const res = await axios.post(`http://localhost:8080/api/checkpay`, a);
        return res.data;
    } catch (e) {
        return false;
    }
};

export const checkAddRoom = async (idTypeHotel, nameUser, startDate, endDate) => {
    const a = {
        idTypeHotel, nameUser, startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10)
    }
    console.log(a)
    try {
        const res = await axios.post(`http://localhost:8080/api/checktype`, a);
        console.log(res.data)
        return res.data;
    } catch (e) {
        return [];
    }
};

export const getApplications = async (id) => {
    console.log(id)
    try {
        const res = await axios.get(`http://localhost:8080/api/applications/${id}`);
        console.log(res.data)
        return res.data;
    } catch (e) {
        return [];
    }
};

export const getImageHotel = async (id) => {
    console.log(id)
    try {
        const res = await axios.get(`http://localhost:8080/api/imageHotel/${id}`);
        console.log("vaof")
        console.log(res.data)
        return res.data;
    } catch (e) {
        console.log("loi")
        return [];
    }
};

export const getTypeHotel = async (id, startDate, endDate) => {
    const a = {
        id, startDate: startDate.substring(0, 10), endDate: endDate.substring(0, 10)
    }
    try {
        const res = await axios.post(`http://localhost:8080/api/typeHotel`, a);
        console.log("--------")
        console.log(res)
        return res.data;
    } catch (e) {
        return [];
    }
};


export const getHotel = async (id) => {
    console.log(id)
    try {
        const res = await axios.get(`http://localhost:8080/api/detail/${id}`);
        return res.data;
    } catch (e) {
        return [];
    }
};


export const addSreach = (hotel) => {
    localStorage.setItem("HOTEL", JSON.stringify(hotel));
}


export const getList = async (hotel) => {
    try {
        console.log(hotel)
        const check = {
            ...hotel, endDate: hotel.endDate.substring(0, 10), startDate: hotel.startDate.substring(0, 10)
        }
        console.log(check)
        const res = await axios.post(`http://localhost:8080/api/list`, check);
        localStorage.setItem("LIST", JSON.stringify(res.data))
        return res.data;
    } catch (e) {
        return [];
    }
};

export const getCity = async () => {
    try {
        const res = await axios.get(`https://provinces.open-api.vn/api/`);
        return res.data;
    } catch (e) {
        return [];
    }
};