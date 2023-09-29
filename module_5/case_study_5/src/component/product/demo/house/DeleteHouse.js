import React, {useEffect} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import * as HouseService from '../../../Service/demo/HouseService';
import Swal from 'sweetalert2';
import HouseList from "./HouseList";

function DeleteHouse() {
    const {id} = useParams()
    const navigate = useNavigate();

    useEffect(() => {
        const confirmDelete = async () => {
            const result = await Swal.fire({
                title: 'Bạn có chắc chắn?',
                text: "Bạn sẽ không thể hoàn tác điều này!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Có, xóa đi!'
            });

            if (result.isConfirmed) {
                try {
                    await HouseService.deleteHouse(id);
                    await Swal.fire(
                        'Đã xóa!',
                        'Tệp của bạn đã được xóa.',
                        'success'
                    );
                    navigate("/house");
                } catch (error) {
                    await Swal.fire(
                        'Lỗi!',
                        'Đã xảy ra lỗi khi xóa sản phẩm.',
                        'error'
                    );
                }
            } else {
                Swal.fire(
                    'Đã hủy',
                    'Tệp ảo của bạn vẫn an toàn :)',
                    'error'
                )
                navigate("/house");
            }
        };

        confirmDelete();
    }, [id, navigate]);


    return (
        <>
            <HouseList/>
        </>
    );
}

export default DeleteHouse;
