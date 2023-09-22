import axios from "axios";

export const deleteBook = async (id) => {
        await axios.delete("http://localhost:8080/item/" + id);
};


export const edit = async (object) => {
    try {
        const res = await axios.put("http://localhost:8080/item/" + object.id, object)
        return res;
    } catch (e) {
        alert("SỬa thất bại")
    }
}


export const getById = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/item/" + id);
        console.log(id)
        return res.data;
    } catch (e) {
        alert("Không có dữ liệu")
    }
}


export const create = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/item", data)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/item");
        return res.data;
    } catch (e) {
        alert("Không có dữ liệu")
    }
};
