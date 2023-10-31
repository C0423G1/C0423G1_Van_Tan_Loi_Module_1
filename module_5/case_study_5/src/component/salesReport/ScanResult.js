import React from 'react';
import ScanQR from "./ScanQR";
import * as SalesService from "../Service/SalesService";

function ScanResult() {
    const [productId, setProduct] = useState()

    const findProduct = async (id) => {
        console.log("ré", id);
        setProduct(id)
    }
    const handleDataByChooseProduct = (data) => {
        findProduct(data);
    }

    return (
        <>
            <p>Success: <a href={`http://${productId}`}>{productId}</a></p>
            <ScanQR resultt={handleDataByChooseProduct}></ScanQR>
        </>
    );
}

export default ScanResult;
