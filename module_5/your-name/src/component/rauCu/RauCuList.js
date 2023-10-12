import React, {useEffect, useState} from 'react';
import * as RauCuService from "../../service/RauCuService"
import {Link} from "react-router-dom"

function RauCuList() {
    const [raucu, setraucu] = useState([]);
    const [page, SetPage] = useState(1);
    const [search, setSearch] = useState("");
    const [searchType, setSearchType] = useState(0);
    const [pageSize, setPageSize] = useState(5)
    const [loai, setLoai] = useState([])
    const getList = async () => {
        setraucu(await RauCuService.getAll(page, pageSize, search, searchType))
    }
    const getListLoai = async () => {
        setLoai(await RauCuService.getAllType())
    }
    useEffect(() => {
        getList()
    }, [page, pageSize, searchType, search])

    useEffect(() => {
        getListLoai()
    }, [])
    return (
        <>
            <input onChange={(e) => setSearch(e.target.value)}/>
            <button onClick={() => SetPage(1)}>Search</button>
            <select onChange={(e) => setSearchType(e.target.value)}>
                {loai.map((loai) => (
                    <option key={loai.id} value={loai.id}>{loai.name}</option>
                ))}
            </select>
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Mã hàng Hoá</th>
                    <th>Đơn vị tính</th>
                    <th>Giá</th>
                    <th>Loại hàng hoá</th>
                    <th>Ngày thu hoạch</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {raucu.map((raucu) => (
                    <tr key={raucu.id}>
                        <td>{raucu.id}</td>
                        <td>{raucu.tenHangHoa}</td>
                        <td>{raucu.donViTinh}</td>
                        <td>{raucu.gia}</td>
                        <td>{raucu.ngayThuHoach}</td>
                        <td>{raucu.loaiHangHoa.name}</td>
                        <td><Link to={`delete/${raucu.id}`}>
                            <button>Xoá</button>
                        </Link></td>
                    </tr>
                ))}
                </tbody>
            </table>
            <button onClick={() => SetPage(page - 1)}>Trang Sau
            </button>
            <button onClick={() => SetPage(page + 1)}>Trang Trước
            </button>
        </>
    );
}

export default RauCuList;