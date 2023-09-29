import axios from "axios";

export const edit = async (VillaData) => {
    console.log(VillaData)
    try {
        const res = await axios.put("http://localhost:8080/api/villa/" + VillaData.id, VillaData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdVilla = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/api/villa/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteVilla = async (id) => {
    try {
        await axios.delete("http://localhost:8080/api/villa/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const createVilla = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/api/villa", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAllVilla = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/villa?_page=${page}&_limit=${pageSize}`);
        console.log(res.data.content)
        return res.data.content;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};