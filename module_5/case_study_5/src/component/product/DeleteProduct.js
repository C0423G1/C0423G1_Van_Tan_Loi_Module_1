import React, {useEffect} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import * as ProductService from '../Service/ProductService';
import Swal from 'sweetalert2';
import Body from "./Body";

function DeleteProduct() {
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
                    await ProductService.deleteProduct(id);
                    await Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    );
                    navigate("/");
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
                navigate("/");
            }
        };

        confirmDelete();
    }, [id, navigate]);

    return (
        <>
            <Body/>
        </>
    );
}

export default DeleteProduct;
