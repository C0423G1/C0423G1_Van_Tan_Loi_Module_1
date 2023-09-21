import React from "react";

function BodyContract() {
    const contracts = [
        {
            contractNumber: "HD001",
            startDate: "2023-09-01",
            endDate: "2023-09-30",
            advanceDeposit: 1000,
            totalPayment: 3000,
        },
        {
            contractNumber: "HD002",
            startDate: "2023-10-01",
            endDate: "2023-10-31",
            advanceDeposit: 1200,
            totalPayment: 3500,
        },

    ];

    return (
        <div className="container">
            <h2>Contract List</h2>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Contract Number</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Advance Deposit</th>
                    <th>Total Payment</th>
                </tr>
                </thead>
                <tbody>
                {contracts.map((contract, index) => (
                    <tr key={contract.contractNumber}>
                        <th scope="row">{index + 1}</th>
                        <td>{contract.contractNumber}</td>
                        <td>{contract.startDate}</td>
                        <td>{contract.endDate}</td>
                        <td>${contract.advanceDeposit}</td>
                        <td>${contract.totalPayment}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default BodyContract;
