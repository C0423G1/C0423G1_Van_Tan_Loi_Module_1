import React from "react";

function BodyCustomer() {
    const customers = [
        {
            id: 1,
            fullName: "Mark Otto",
            dateOfBirth: "1990-01-15",
            gender: "Male",
            idCardNumber: "123456789",
            phoneNumber: "123-456-7890",
            email: "mark@example.com",
            customerType: "Diamond",
            address: "123 Main Street, City"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },
        {
            id: 2,
            fullName: "Jacob Thornton",
            dateOfBirth: "1985-05-20",
            gender: "Male",
            idCardNumber: "987654321",
            phoneNumber: "987-654-3210",
            email: "jacob@example.com",
            customerType: "Platinum",
            address: "456 Elm Street, Town"
        },

    ];

    return (
        <div className="container">
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
                </tr>
                </thead>
                <tbody>
                {customers.map((customer) => (
                    <tr key={customer.id}>
                        <th scope="row">{customer.id}</th>
                        <td>{customer.fullName}</td>
                        <td>{customer.dateOfBirth}</td>
                        <td>{customer.gender}</td>
                        <td>{customer.idCardNumber}</td>
                        <td>{customer.phoneNumber}</td>
                        <td>{customer.email}</td>
                        <td>{customer.customerType}</td>
                        <td>{customer.address}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default BodyCustomer;
