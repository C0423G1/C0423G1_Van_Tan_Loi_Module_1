import axios from "axios";

export const getImageHotel = async (id) => {
    console.log(id)
    try {
        const res = await axios.get(`http://localhost:8080/api/imageHotel/${id}`);
        console.log(res.data)
        return res.data;
    } catch (e) {
        return [];
    }
};

export const getTypeHotel = async (id) => {
    console.log(id)
    try {
        const res = await axios.get(`http://localhost:8080/api/typeHotel/${id}`);
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
            ...hotel, endDate: hotel.endDate.substring(0,10),startDate : hotel.startDate.substring(0,10)
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