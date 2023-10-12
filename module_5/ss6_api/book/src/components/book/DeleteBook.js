import React, {useEffect} from 'react';
import * as BookService from '../service/BookService';
import Swal from 'sweetalert2';
import 'sweetalert2/dist/sweetalert2.css';
import {useNavigate, useParams} from 'react-router-dom';

function DeleteBook() {
    const param = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        async function deleteBook() {
            try {
                await BookService.deleteBook(param.id);
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                );
                navigate('/');
            } catch (error) {
                console.error('Lỗi xoá cuốn sách:', error);
                Swal.fire(
                    'Error!',
                    'An error occurred while deleting the rauCu.',
                    'error'
                );
            }
        }

        deleteBook();
    }, [param.id, navigate]);

    return null;
}

export default DeleteBook;
