import React, {useEffect} from 'react';
import RauCu from "./RauCu";
import Swal from "sweetalert2";
import * as RauCuService from "../../service/RauCuService";
import {useNavigate, useParams} from "react-router-dom";

function DeleteRauCu(props) {
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const confirmDelete = async () => {
            const result = await Swal.fire({
                title: 'Bạn có chắc chắn?',
                text: 'Bạn sẽ không thể hoàn tác điều này!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Có, xóa nó!',
            });
            if (result.isConfirmed) {
                try {
                    await RauCuService.deleteId(id);
                    await Swal.fire(
                        'Đã xóa!',
                        'Tệp của bạn đã được xóa.',
                        'success'
                    );
                    navigate('/');
                } catch (error) {
                    await Swal.fire(
                        'Lỗi!',
                        'Đã xảy ra lỗi khi xóa sản phẩm.',
                        'error'
                    );
                }
            } else {
                Swal.fire(
                    'Hủy bỏ',
                    'Tệp ảo của bạn an toàn :)',
                    'error'
                );
                navigate('/');
            }
        };
        confirmDelete();
    }, [id, navigate]);
    return (
        <>
            <RauCu/>
        </>
    );
}

export default DeleteRauCu;