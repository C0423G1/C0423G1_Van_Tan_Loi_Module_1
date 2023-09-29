import React, { useEffect } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import * as CustomerService from '../Service/CustomerService';
import Swal from 'sweetalert2';
import BodyCustomer from "./BodyCustomer";

function DeleteCustomer() {
    const { id } = useParams();
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
                    await CustomerService.deleteCustomer(id);
                    await Swal.fire(
                        'Đã xóa!',
                        'Tệp của bạn đã được xóa.',
                        'success'
                    );
                    navigate("/customer");
                } catch (error) {
                    await Swal.fire(
                        'Lỗi!',
                        'Đã xảy ra lỗi trong quá trình xóa khách hàng.',
                        'error'
                    );
                }
            } else {
                Swal.fire(
                    'Đã hủy',
                    'Tệp ảo của bạn vẫn an toàn :)',
                    'error'
                )
                navigate("/customer");
            }
        };

        confirmDelete();
    }, [id, navigate]);

    return (
        <>
            <BodyCustomer/>
        </>
    );
}

export default DeleteCustomer;
