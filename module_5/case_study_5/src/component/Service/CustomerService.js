import axios from "axios";




export const edit = async (customerData) => {
    try {
        const res = await axios.put("http://localhost:8080/api/customer/" + customerData.id, customerData)
        return res;
    } catch (e) {
        console.log(e)
    }
}


export const byIdCustomer = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/api/customer/" + id)
        return res.data
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const deleteCustomer = async (id) => {
    try {
        await axios.delete("http://localhost:8080/api/customer/" + id)
    } catch (e) {
        alert("Xoá thất bại")
    }
}


export const create = async (data) => {
    console.log(data)
    try {
        const res = await axios.post("http://localhost:8080/api/customer", data)
        console.log(res)
        return res;
    } catch (e) {
        alert("thêm mới thất bại")
    }
}


export const getAll = async (page, pageSize,search) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/customer?_page=${page}&_limit=${pageSize}&like_full_name=${search}&like_customer_type=${search}`);
        console.log(res.data.content)
        return res.data.content;
    } catch (e) {
        alert("Không có dữ liệu");
        return [];
    }
};

// export const getAll = async () => {
//     try {
//         const res = await axios.get(`http://localhost:8080/api/customer`);
//         return res.data;
//     } catch (e) {
//         alert("Không có dữ liệu");
//         return [];
//     }
// };
