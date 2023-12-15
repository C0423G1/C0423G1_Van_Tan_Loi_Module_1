import axios from "axios";
export const getCart = async (sub) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/cart`);
        return res;
    } catch (e) {
        return [];
    }
};

export const getMaleWatch = async () => {
    try {
        const res = await axios.get(`http://localhost:8080/api/male`);
        return res;
    } catch (e) {
        return [];
    }
};
export const getFemaleWatch = async () => {
    try {
        const res = await axios.get(`http://localhost:8080/api/female`);
        return res;
    } catch (e) {
        return [];
    }
};
export const ProductDetail = async (idProduct) => {
    console.log(idProduct)
    const result = await axios.get(`http://localhost:8080/api/product/${idProduct}`)
    console.log(result)
    return result;
}