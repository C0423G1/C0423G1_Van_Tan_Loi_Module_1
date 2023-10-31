import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import * as CustomerService from "../Service/CustomerService";

function formatDate(dateString) {
    const options = {year: "numeric", month: "2-digit", day: "2-digit"};
    return new Date(dateString).toLocaleDateString(undefined, options);
}

function BodyCustomer() {
    const [customers, setCustomers] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(5);
    const [search, setSearch] = useState("");
    const styleSearch = {
        width: "252px",
        marginLeft: "76%"
    }
    const getCustomers = async () => {
        setCustomers(await CustomerService.getAll(currentPage, pageSize, search));
    };


    useEffect(() => {
        getCustomers();
    }, [currentPage, pageSize]);

    return (
        <>
            <div className="body">
                <Link to={'/qr'}>
                    <button>Scan QR</button>
                </Link>
                <h2>Danh sách Khách hàng</h2>
                <div style={styleSearch} className="input-group mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Tìm kiếm..."
                        aria-label="Tìm kiếm..."
                        aria-describedby="search-button"
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                    <button
                        onClick={() => setCurrentPage(1)}
                        className="btn btn-outline-search"
                        type="button"
                        id="search-button">Tìm
                    </button>
                </div>

                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Họ và Tên</th>
                        <th>Ngày sinh</th>
                        <th>Giới tính</th>
                        <th>Số CMND</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <th>Loại khách hàng</th>
                        <th>Địa chỉ</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {customers.map((customer) => (
                        <tr key={customer.id}>
                            <th scope="row">{customer.id}</th>
                            <td>{customer.fullName}</td>
                            <td>{formatDate(customer.dateOfBirth)}</td>
                            <td>{customer.gender}</td>
                            <td>{customer.idCardNumber}</td>
                            <td>{customer.phoneNumber}</td>
                            <td>{customer.email}</td>
                            <td>{customer.customerType}</td>
                            <td>{customer.address}</td>
                            <td>
                                <Link to={`/editCustomer/${customer.id}`}>
                                    <i className="fa">&#xf044;</i>
                                </Link>
                            </td>
                            <td>
                                <Link to={`/deleteCustomer/${customer.id}`}>
                                    <i className="material-icons">&#xe872;</i>
                                </Link>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <div className="pagination-buttons"
                     style={{display: 'flex', justifyContent: 'center', margin: '20px 0'}}>
                    <button
                        onClick={() => setCurrentPage(currentPage - 1)}
                        disabled={currentPage === 1 || customers.length === 0}
                        className="btn btn-primary mx-2"
                    >
                        Trang Trước
                    </button>
                    <button
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={customers.length < pageSize}
                        className="btn btn-primary mx-2"
                    >
                        Trang Tiếp Theo
                    </button>
                </div>

                <Link to="/createCustomer">
                    <button
                        type="button"
                        className="btn btn-outline-primary float-end"
                    >
                        +
                    </button>
                </Link>
            </div>
        </>
    );
}

export default BodyCustomer;
