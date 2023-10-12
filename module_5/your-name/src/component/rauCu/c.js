import React, {useEffect, useState} from 'react';
import * as RauCuService from "../../service/RauCuService"

function C() {
    const [raucu, setraucu] = useState([]);
    const [page, setpage] = useState(1);
    const [pageSize, setPageSize] = useState(5);
    const [sreach, setsreach] = useState("");
    const getList = async () => {
        setraucu(await RauCuService.getAll(page, pageSize, sreach))
    }
    useEffect(() => {
        getList()
    }, [page, pageSize, sreach])

    return (
        <>
            <input onChange={(e) => setsreach(e.target.value)}/>
            <table>
                <tr>
                    <td>#</td>
                    <td>Mã hàng hoá</td>
                    <td>Tên hàng hoá</td>
                    <td>Đơn vị tính</td>
                    <td>Giá</td>
                    <td>Loại Hàng hoá</td>
                    <td>Ngày thu hoạch</td>
                </tr>
                {raucu.map((rauCu) => (
                    <tr key={rauCu.id}>
                        <td>{rauCu.id}</td>
                        <td>{rauCu.tenHangHoa}</td>
                        <td>{rauCu.donViTinh}</td>
                        <td>{rauCu.gia}</td>
                        <td>{rauCu.loaiHangHoa.name}</td>
                        <td>{rauCu.ngayThuHoach}</td>
                    </tr>
                ))}
            </table>
            <button onClick={() => setpage(page - 1)}>Trang Trước</button>
            <button onClick={() => setpage(page + 1)}>Trang Trước</button>
        </>
    );
}

export default C;