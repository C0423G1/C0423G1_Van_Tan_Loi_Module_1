import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import * as CustomerService from "../Service/CustomerService";

function formatDate(dateString) {
    const options = { year: "numeric", month: "2-digit", day: "2-digit" };
    return new Date(dateString).toLocaleDateString(undefined, options);
}

function BodyCustomer() {
    const [customers, setCustomer] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);

    const getProduct = async () => {
        setCustomer(await CustomerService.getAll(currentPage, pageSize));
    };

    useEffect(() => {
        console.log(`currentPage: ${currentPage}, pageSize: ${pageSize}`);
        getProduct();
    }, [currentPage, pageSize]);

    return (
        <>
            <div className="body">
                <h2>Customer List</h2>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Full Name</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
                        <th>ID Card Number</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Customer Type</th>
                        <th>Address</th>
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
                <div className="pagination-buttons">
                    <button
                        onClick={() => setCurrentPage(currentPage - 1)}
                        disabled={currentPage === 1 || customers.length === 0}
                        className="pagination-button"
                    >
                        Trang Trước
                    </button>
                    <button
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={customers.length < pageSize}
                        className="pagination-button"
                    >
                        Trang Tiếp Theo
                    </button>
                </div>

                <Link to="/createCustomer">
                    <button
                        // style={buttonStyle}
                        type="button"
                        className="btn btn-outline-info float-end"
                    >
                        +
                    </button>
                </Link>
            </div>
        </>
    );
}

export default BodyCustomer;
