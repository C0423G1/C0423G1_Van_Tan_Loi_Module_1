import React, {useEffect, useState} from 'react';
import * as RauCuService from "../../service/RauCuService";
import {Link} from "react-router-dom";

function RauCu() {
    const [rauCu, setRauCu] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(5);

    const getRauCu = async () => {
        setRauCu(await RauCuService.getAll(currentPage, pageSize));
    };

    useEffect(() => {
        getRauCu();
    }, [currentPage, pageSize]);

    return (
        <>

            <div className="body">
                <h1> Danh Sách Rau Củ</h1>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Tên Hàng Hoá</th>
                        <th>Đơn vị tính</th>
                        <th>Giá</th>
                        <th>Loại hàng hoá</th>
                        <th>Ngày thu hoạch</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    {rauCu.map((rauCu, index) => (
                        <tr key={rauCu.id}>
                            <th scope="row">{index + 1}</th>
                            <td>{rauCu.tenHangHoa}</td>
                            <td>{rauCu.donViTinh}</td>
                            <td>{rauCu.gia}</td>
                            <td>{rauCu.loaiHangHoa.name}</td>
                            <td>{rauCu.ngayThuHoach}</td>
                            <td>
                                <button type="button" className="btn btn-warning">Edit</button>
                            </td>
                            <td>
                                <Link to={`/delete/${rauCu.id}`}>
                                    <button type="button" className="btn btn-danger">Xoá</button>
                                </Link>
                            </td>
                        </tr>
                    ))}
                </table>
                <div className="pagination-buttons">
                    <button
                        onClick={() => setCurrentPage(currentPage - 1)}
                        disabled={currentPage === 1 || rauCu.length === 0}
                        className="pagination-button">
                        Trang Trước
                    </button>
                    <button
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={rauCu.length < pageSize}
                        className="pagination-button">
                        Trang Tiếp Theo
                    </button>
                </div>
            </div>
        </>
    );
}

export default RauCu;