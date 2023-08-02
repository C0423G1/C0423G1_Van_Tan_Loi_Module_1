package com.example.bookingtour.Model;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class VnpayPayment {
    public static <JsonObject> void main(String[] args) {
        // Các thông tin của tài khoản VNPAY
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TmnCode = "YOUR_TMN_CODE";
        String vnp_HashSecret = "YOUR_HASH_SECRET";
        String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
        String vnp_Returnurl = "YOUR_RETURN_URL";

        // Các thông tin của đơn hàng
        String vnp_OrderInfo = "YOUR_ORDER_INFO";
        String orderType = "YOUR_ORDER_TYPE";
        int amount = 100000; // Số tiền thanh toán (đơn vị: VND)

        // Tạo các tham số của request
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_TxnRef", getRandomNumber(8));
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", getIpAddress());

        // Xử lý ngày giờ
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        // Xác định phương thức thanh toán (tùy chọn)
        String bank_code = "YOUR_BANK_CODE";
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }

        // Các thông tin thanh toán khác (tùy chọn)
        vnp_Params.put("vnp_Bill_Mobile", "YOUR_BILL_MOBILE");
        vnp_Params.put("vnp_Bill_Email", "YOUR_BILL_EMAIL");
        vnp_Params.put("vnp_Bill_Address", "YOUR_BILL_ADDRESS");
        // ...

        // Xây dựng chuỗi dữ liệu cần hash và truy vấn
        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        Iterator<String> itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = itr.next();
            String fieldValue = vnp_Params.get(fieldName);
            if (fieldValue != null && fieldValue.length() > 0) {
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }

        // Tính chuỗi hash
        String vnp_SecureHash = hmacSHA512(vnp_HashSecret, hashData.toString());
        query.append("vnp_SecureHash=").append(vnp_SecureHash);

        // Tạo URL thanh toán
        String paymentUrl = vnp_PayUrl + "?" + query.toString();

        // Tạo đối tượng JsonObject để trả về kết quả
        JsonObject job = new JsonObject();
        job.addProperty("code", "00");
        job.addProperty("message", "success");
        job.addProperty("data", paymentUrl);

        // Chuyển đổi JsonObject thành chuỗi JSON và xuất kết quả
        Gson gson = new Gson();
        System.out.println(gson.toJson(job));
    }

    // Hàm sinh số ngẫu nhiên
    private static String getRandomNumber(int length) {
        // Implement your random number generation logic here
        // For example, you can use the Random class in Java
        // and generate a random number of the specified length.
    }

    // Hàm lấy địa chỉ IP của client
    private static String getIpAddress() {
        // Implement your logic to get client's IP address
    }

    // Hàm mã hóa HMAC SHA512
    private static String hmacSHA512(String key, String data) {
        // Implement your HMAC SHA512 hashing logic here
        // You can use libraries like Apache Commons Codec
        // or you can implement the hashing algorithm manually.
    }
}

