import React, { useState } from 'react';
import axios from 'axios';

const VNPayPayment = () => {
    const [orderInfo, setOrderInfo] = useState({
        vnp_TmnCode: 'P9UI0NFR', // Mã merchant của bạn
        vnp_Amount: 100000, // Số tiền cần thanh toán
        vnp_OrderInfo: 'Thanh toán đơn hàng',
        vnp_ReturnUrl: 'http://localhost:3000/', // Đường dẫn trả về sau khi thanh toán thành công
    });

    const handlePayment = async () => {
        try {
            // Gửi yêu cầu tạo đơn hàng đến server của bạn
            const response = await axios.post(' https://sandbox.vnpayment.vn/paymentv2/vpcpay.html', orderInfo);

            // Redirect đến trang thanh toán của VNPAY
            window.location.href = response.data.paymentUrl;
        } catch (error) {
            console.error('Error initiating payment:', error);
        }
    };

    return (
        <div>
            <h1>Thanh toán VNPAY</h1>
            <p>Tổng số tiền cần thanh toán: {orderInfo.vnp_Amount} VND</p>
            <button onClick={handlePayment}>Thanh toán ngay</button>
        </div>
    );
};

export default VNPayPayment;
