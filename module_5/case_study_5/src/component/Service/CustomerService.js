import axios from "axios";




export const edit = async (customerData) => {
    try {
        const res = await axios.put("http://localhost:8080/customer/" + customerData.id, customerData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdCustomer = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/customer/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteCustomer = async (id) => {
    try {
        await axios.delete("http://localhost:8080/customer/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const create = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/customer", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAll = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/customer?_page=${page}&_limit=${pageSize}`);
        console.log(res.data)
        return res.data;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};

