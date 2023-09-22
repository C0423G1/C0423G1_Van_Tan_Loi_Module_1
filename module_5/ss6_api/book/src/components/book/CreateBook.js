import React from "react";
import {Formik, Field, Form} from 'formik';
import * as BookService from "../service/BookService";
import {useNavigate} from "react-router";


function CreateBook() {
    const navigate = useNavigate()
    const createBook = async (data) => {
        const res = await BookService.create(data);
        if (res.status === 201) {
            navigate("/");
            alert("Thêm mới thành công");
        } else {
            alert("Thêm mới thất bại");
        }
    }

    return (
        <>
            <Formik initialValues={{
                title: "",
                quantity: 0,
            }} onSubmit={(values) => {
                createBook(values);
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

export default CreateBook;

