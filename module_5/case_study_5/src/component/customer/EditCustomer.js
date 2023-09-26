import React, {useEffect, useState} from 'react';
import {ErrorMessage, Field, Formik, Form} from 'formik';
import * as Yup from 'yup';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '@fortawesome/fontawesome-free/css/all.css';
import * as CustomerService from '../Service/CustomerService';
import Swal from 'sweetalert2';
import {useNavigate, useParams} from 'react-router-dom';

function EditCustomer() {
    const navigate = useNavigate();
    const param = useParams();
    const [customer, setCustomer] = useState()
    const [birthDate, setBirthDate] = useState(new Date());

    useEffect(() => {
        if (param.id) {
            getCustomerById();
        }
    }, []);
    const getCustomerById = async () => {
        const product = await CustomerService.byIdCustomer(param.id);
        if (product) {
            setCustomer(product);
            setBirthDate(new Date(product.dateOfBirth));
        }
    }

    const validationSchema = Yup.object().shape({
        fullName: Yup.string()
            .matches(/^[A-Z][a-z]*( [A-Z][a-z]*)*$/, 'Invalid name')
            .required('Name is required'),
        phoneNumber: Yup.string()
            .matches(/^(0[9][0-9]{8}|\(84\)\+0[9][0-9]{8})$/, 'Invalid phone number')
            .required('Phone number is required'),
        idCardNumber: Yup.string()
            .matches(/^[0-9]{9,12}$/, 'Invalid ID card number')
            .required('ID card number is required'),
        email: Yup.string()
            .matches(/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/, 'Invalid email')
            .required('Email is required'),
        dateOfBirth: Yup.date().required('Birth date is required'),
        gender: Yup.string().required('Gender is required'),
        customerType: Yup.string().required('Customer Type is required'),
        address: Yup.string().required('Address is required'),
    });

    const initialValues = {
        id: customer?.id,
        fullName: customer?.fullName,
        phoneNumber: customer?.phoneNumber,
        idCardNumber: customer?.idCardNumber,
        email: customer?.email,
        dateOfBirth: birthDate,
        gender: customer?.gender,
        customerType: customer?.customerType,
        address: customer?.address
    };

    const editCustomer = async (values) => {
        try {
            const res = await CustomerService.edit(values);
            if (res.status === 200) {
                await Swal.fire('Created!', 'Your customer has been created successfully.', 'success');
                navigate('/customer');
            } else {
                await Swal.fire('Error!', 'An error occurred while creating the customer.', 'error');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        customer &&
        <div className="create-product">
            <h1>Create Customer</h1>
            <Formik initialValues={initialValues} validationSchema={validationSchema}
                    onSubmit={(values) => editCustomer(values)}>
                <Form>
                    <div>
                        <label>Name:</label>
                        <Field type="text" name="fullName" className="form-control"/>
                        <ErrorMessage name="fullName" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Phone Number:</label>
                        <Field type="text" name="phoneNumber" className="form-control"/>
                        <ErrorMessage name="phoneNumber" component="div" className="error"/>
                    </div>
                    <div>
                        <label>ID Card Number:</label>
                        <Field type="text" name="idCardNumber" className="form-control"/>
                        <ErrorMessage name="idCardNumber" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Email:</label>
                        <Field type="text" name="email" className="form-control"/>
                        <ErrorMessage name="email" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label>Birth Date:</label>
                        <div className="input-group">
                            <DatePicker
                                className="form-control"
                                id="birthDate"
                                name="dateOfBirth"
                                selected={birthDate}
                                dateFormat="dd/MM/yyyy"
                            />
                            <button className="btn btn-outline-secondary" type="button">
                                <i className="fas fa-calendar"></i>
                            </button>
                        </div>
                        <ErrorMessage name="dateOfBirth" component="div"
                                      className="invalid-feedback d-block error"/>
                    </div>
                    <div>
                        <label>Gender:</label>
                        <Field as="select" name="gender" className="form-select">
                            <option value="">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </Field>
                        <ErrorMessage name="gender" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Customer Type:</label>
                        <Field as="select" name="customerType" className="form-select">
                            <option value="">Customer Type</option>
                            <option value="Diamond">Diamond</option>
                            <option value="Platinium">Platinium</option>
                            <option value="Gold">Gold</option>
                            <option value="Member">Member</option>
                            <option value="Silver">Silver</option>
                        </Field>
                        <ErrorMessage name="customerType" component="div" className="error"/>
                    </div>

                    <div>
                        <label>Address:</label>
                        <Field type="text" name="address" className="form-control"/>
                        <ErrorMessage name="address" component="div" className="error"/>
                    </div>
                    <button style={{marginTop: "10px"}} variant="primary" type="submit" className="btn btn-outline-primary">
                        Save
                    </button>
                </Form>
            </Formik>
        </div>
    );
}

export default EditCustomer;
