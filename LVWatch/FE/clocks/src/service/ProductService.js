import axios from "axios";
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