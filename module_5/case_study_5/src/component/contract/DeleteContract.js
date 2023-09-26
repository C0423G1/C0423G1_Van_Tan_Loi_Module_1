import React, {useEffect} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import * as ContractService from '../Service/ContractService';
import Swal from 'sweetalert2';
import BodyContract from "./BodyContract";

function DeleteContract() {
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
                    await ContractService.deleteContract(id);
                    await Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    );
                    navigate("/contract");
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
                navigate("/contract");
            }
        };

        confirmDelete();
    }, [id, navigate]);

    return (
        <>
            <BodyContract/>
        </>
    );
}

export default DeleteContract;
