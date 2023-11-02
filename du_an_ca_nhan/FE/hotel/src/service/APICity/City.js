import axios from "axios";

export const getList = async (pageSize, currentPage, numberOfGuests, endDate, startDate, selectedLocation) => {
    const requestConfig = {
        params: {
            pageSize,
            currentPage,
            numberOfGuests,
            endDate,
            startDate,
            selectedLocation
        }
    };

    try {
        const res = await axios.get(`http://localhost:8080/api/list`,requestConfig);
        console.log(res)
        return res.data.content;
    } catch (e) {
        return [];
    }
};

export const getCity = async () => {
    try {
        const res = await axios.get(`https://provinces.open-api.vn/api/`);
        console.log(res)
        return res.data;
    } catch (e) {

        return [];
    }
};