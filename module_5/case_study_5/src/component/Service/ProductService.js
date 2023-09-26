import axios from "axios";




export const edit = async (param) => {
    try {
       const res =await axios.put("http://localhost:8080/product/" + param.id, param)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const byIdProduct = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/product/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteProduct = async (id) => {
    try {
        await axios.delete("http://localhost:8080/product/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const create = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/product", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAll = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/product?_page=${page}&_limit=${pageSize}`);
        console.log(res.data)
        return res.data;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};