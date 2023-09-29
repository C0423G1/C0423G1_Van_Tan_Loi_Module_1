import axios from "axios";

export const edit = async (RoomData) => {
    console.log(RoomData)
    try {
        const res = await axios.put("http://localhost:8080/api/room/" + RoomData.id, RoomData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdRoom = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/api/room/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteRoom = async (id) => {
    try {
        await axios.delete("http://localhost:8080/api/room/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const createRoom = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/api/room", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAllRoom = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/room?_page=${page}&_limit=${pageSize}`);
        console.log(res.data.content)
        return res.data.content;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};