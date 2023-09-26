import React, {useEffect, useState} from "react";
import * as ContractService from "../Service/ContractService";
import {Link} from "react-router-dom";

function formatDate(dateString) {
    const options = {year: "numeric", month: "2-digit", day: "2-digit"};
    return new Date(dateString).toLocaleDateString(undefined, options);
}

function BodyContract() {
    const [contracts, setContracts] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);

    const getContract = async () => {
        setContracts(await ContractService.getAll(currentPage, pageSize));
    };

    useEffect(() => {
        console.log(`currentPage: ${currentPage}, pageSize: ${pageSize}`);
        getContract();
    }, [currentPage, pageSize]);

    return (
        <>
            <div className="body">
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
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {contracts.map((contract, index) => (
                        <tr key={contract.id}>
                            <th scope="row">{contract.id}</th>
                            <td>{contract.contractNumber}</td>
                            <td>{formatDate(contract.startDate)}</td>
                            <td>{formatDate(contract.endDate)}</td>
                            <td>${contract.advanceDeposit}</td>
                            <td>${contract.totalPayment}</td>
                            <td>
                                <Link to={`/editContract/${contract.id}`}>
                                    <i className="fa">&#xf044;</i>
                                </Link>
                            </td>
                            <td>
                                <Link to={`/deleteContract/${contract.id}`}>
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
                        disabled={currentPage === 1 || contracts.length === 0}
                        className="pagination-button"
                    >
                        Trang Trước
                    </button>
                    <button
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={contracts.length < pageSize}
                        className="pagination-button"
                    >
                        Trang Tiếp Theo
                    </button>
                </div>
                <Link to="/createContract">
                    <button
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

export default BodyContract;
