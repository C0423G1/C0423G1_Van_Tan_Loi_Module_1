import axios from "axios";

export const edit = async (ContractData) => {
    console.log(ContractData)
    try {
        const res = await axios.put("http://localhost:8080/api/contract/" + ContractData.id, ContractData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdContract = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/api/contract/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteContract = async (id) => {
    try {
        await axios.delete("http://localhost:8080/api/contract/" + id)
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const create = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/api/contract", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAll = async (page, pageSize) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/contract?_page=${page}&_limit=${pageSize}`);
        console.log(res.data.content)
        return res.data.content;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};