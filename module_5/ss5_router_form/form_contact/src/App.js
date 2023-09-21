import React from 'react';
import {Formik, Field, ErrorMessage, Form} from 'formik';
import './App.css';


const REGEX_EMAIL = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

function App() {
    const validate = (values) => {
        const errors = {};

        if (!values.name) {
            errors.name = 'Required';
        }

        if (!values.email) {
            errors.email = 'Required';
        } else if (!REGEX_EMAIL.test(values.email)) {
            errors.email = 'Invalid email address';
        }

        if (!values.phone) {
            errors.phone = 'Required';
        }

        return errors;
    };

    const handleSubmit = (values, {setSubmitting}) => {
        setTimeout(() => {
            alert('Thêm liên hệ thành công');
            setSubmitting(false);
        }, 500);

    };

    return (
        <>
            <Formik initialValues={{name: '', email: '', phone: ''}} validate={validate} onSubmit={handleSubmit}>
                {({isSubmitting}) => (
                    <Form>
                        <div>
                            <label>Name:</label>
                            <Field type="text" name="name" className="custom-input-error"/>
                            <ErrorMessage name="name" component="div" className="error"/>
                        </div>
                        <div>
                            <label>Email:</label>
                            <Field type="text" name="email" className="custom-input-error"/>
                            <ErrorMessage name="email" component="div" className="error"/>
                        </div>
                        <div>
                            <label>Phone:</label>
                            <Field type="text" name="phone" className="custom-input-error"/>
                            <ErrorMessage name="phone" component="div" className="error"/>
                        </div>
                        <button type="submit" disabled={isSubmitting}>Submit</button>
                    </Form>
                )}
            </Formik>
        </>
    );
}

export default App;
