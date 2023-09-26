import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router";
import {Field, Form, Formik} from "formik";
import * as BookService from "../service/BookService";
import {getById, getByName} from "../service/BookService";

function EditBook() {
    const param = useParams();
    const [book, setBook] = useState()
    const navigate = useNavigate()

    const editBook = async (data) => {
        const res = await BookService.edit(data);
        if (res.status === 201) {
            navigate("/");
            alert("Thêm mới thành công");
        } else {
            alert("Thêm mới thất bại");
        }
    }

    useEffect(() => {
        if (param.id) {
            getBookById();
        }
    }, []);

    const getBookById = async () => {
        const book = await getById(param.id);
        setBook(book);
    }
    return (
        book &&
        <>
            <Formik initialValues={{
                id: book?.id,
                title: book?.title,
                quantity: book?.quantity,
            }} onSubmit={(values) => {
                editBook(values);
            }}>
                <Form>
                    <div className="mb-3">
                        <label htmlFor="title" className="form-label">Title</label>
                        <Field name="title" id="title" className="form-control"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="quantity" className="form-label">Quantity</label>
                        <Field name="quantity" id="quantity" type="number" className="form-control"/>
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </Form>
            </Formik>
        </>
    );
}

export default EditBook;