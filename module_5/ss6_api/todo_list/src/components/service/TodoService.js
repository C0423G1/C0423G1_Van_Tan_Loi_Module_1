import axios from "axios";

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
        const res = await axios.get("  http://localhost:8080/item");
        return res.data;
    } catch (e) {
        alert("Không có dữ liệu")
    }
};