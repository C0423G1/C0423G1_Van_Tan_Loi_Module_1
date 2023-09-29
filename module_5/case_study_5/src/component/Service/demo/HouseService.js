import axios from "axios";

export const edit = async (HouseData) => {
    console.log(HouseData)
    try {
        const res = await axios.put("http://localhost:8080/api/house/" + HouseData.id, HouseData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdHouse = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/api/house/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteHouse = async (id) => {
    try {
        await axios.delete("http://localhost:8080/api/house/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const createHouse = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/api/house", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAllHouse = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/house?_page=${page}&_limit=${pageSize}`);
        console.log(res.data.content)
        return res.data.content;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};