import React, {useEffect} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import * as CustomerService from '../Service/CustomerService';
import Swal from 'sweetalert2';
import BodyCustomer from "./BodyCustomer";

function DeleteCustomer() {
    const {id} = useParams()
    const navigate = useNavigate();

    useEffect(() => {
        const confirmDelete = async () => {
            const result = await Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            });

            if (result.isConfirmed) {
                try {
                    await CustomerService.deleteCustomer(id);
                    await Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    );
                    navigate("/customer");
                } catch (error) {
                    await Swal.fire(
                        'Error!',
                        'An error occurred while deleting the product.',
                        'error'
                    );
                }
            } else {
                Swal.fire(
                    'Cancelled',
                    'Your imaginary file is safe :)',
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
