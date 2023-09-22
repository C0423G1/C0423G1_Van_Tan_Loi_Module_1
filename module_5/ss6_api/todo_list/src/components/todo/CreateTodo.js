import React from "react";
import * as TodoService from "../service/TodoService";
import {Formik, Field, Form} from 'formik';

export function CreateTodo() {
    const createTodo = async (data) => {
        console.log(data)
        const res = await TodoService.create(data);
        if (res.status == 201) {
            alert("Thêm mới thành công");
        } else {
            alert("Thêm mới thất bại");
        }
    }

    return (
        <>
            <Formik
                onSubmit={(values) => {
                    createTodo(values);
                }}
                initialValues={{
                    userId: "1",
                    title: "",
                    completed: false
                }}
            >
                <Form>
                    <h1 className="display-4">Todo List</h1>
                    <div className="mb-3">
                        <label htmlFor="title" className="form-label">Title</label>
                        <Field type="text" className="form-control" name="title"/>
                    </div>
                    <button type="submit" className="btn btn-primary">Add</button>
                </Form>
            </Formik>
        </>
    );
}

export default CreateTodo;