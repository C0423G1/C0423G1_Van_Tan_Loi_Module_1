import React from 'react';
import './Footer.css';

const Footer = () => {
    return (
        <footer className="footer-container">
            <div className="footer-content">
                <div className="footer-section">
                    <h2>Thông tin liên hệ</h2>
                    <p>Địa chỉ: 123 Đường ABC, Thành phố XYZ</p>
                    <p>Email: example@email.com</p>
                </div>
                <div className="footer-section">
                    <h2>Danh mục</h2>
                    <ul>
                        <li><a href="/">Trang chủ</a></li>
                        <li><a href="/about">Giới thiệu</a></li>
                        <li><a href="/contact">Liên hệ</a></li>
                    </ul>
                </div>
            </div>
            <div className="footer-bottom">
                <p>&copy; 2023 Tên Công Ty. Catland Booking.</p>
            </div>
        </footer>
    );
};

export default Footer;
