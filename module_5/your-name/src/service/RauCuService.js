import axios from "axios";

export const create = async (data) => {
    console.log(data)
    const res = await axios.post("http://localhost:8080/rauCu", data)
    return res
}


export const getAllType = async () => {
    const res = await axios.get("http://localhost:8080/loaiHangHoa")
    return res.data
}


export const deleteId = async (id) => {
    const res = await axios.delete("http://localhost:8080/rauCu/" + id)
}


export const getAll = async (page, pageSize, search, searchId) => {
    console.log(searchId)
    console.log(search)
    if (searchId !== 0) {
        console.log(`http://localhost:8080/rauCu?_page=${page}&_limit=${pageSize}&tenHangHoa_like=${search}&loaiHangHoa.id=${searchId}`)
        const res = await axios.get(`http://localhost:8080/rauCu?_page=${page}&_limit=${pageSize}&tenHangHoa_like=${search}&loaiHangHoa.id=${searchId}`)
        console.log(res)
        return res.data;
    }
    const res = await axios.get(`http://localhost:8080/rauCu?_page=${page}&_limit=${pageSize}&tenHangHoa_like=${search}`)
    console.log(res)
    return res.data;
}
