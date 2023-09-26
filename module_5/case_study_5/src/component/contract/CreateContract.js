import React, { useEffect, useState } from 'react';
import { ErrorMessage, Field, Formik, Form } from 'formik';
import * as Yup from 'yup';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '@fortawesome/fontawesome-free/css/all.css';
import * as ContractService from '../Service/ContractService';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router';

function CreateContract() {
    const navigate = useNavigate();

    const validationSchema = Yup.object().shape({
        contractNumber: Yup.string().required('Contract Number is required'),
        startDate: Yup.date().required('Start Date is required'),
        endDate: Yup.date()
            .required('End Date is required')
            .min(Yup.ref('startDate'), 'End Date must be later than Start Date'),
        advanceDeposit: Yup.number()
            .typeError('Advance Deposit must be a positive integer')
            .required('Advance Deposit is required')
            .integer('Advance Deposit must be an integer')
            .min(1, 'Advance Deposit must be a positive integer'),
        totalPayment: Yup.number()
            .typeError('Total Payment must be a positive integer')
            .required('Total Payment is required')
            .integer('Total Payment must be an integer')
            .min(1, 'Total Payment must be a positive integer'),

    });

    const initialValues = {
        contractNumber: '',
        startDate: null,
        endDate: null,
        advanceDeposit: 0,
        totalPayment: 0,
    };

    const createCustomer = async (values) => {
        try {
            const res = await ContractService.create(values);
            if (res.status === 201) {
                await Swal.fire('Created!', 'Your customer has been created successfully.', 'success');
                navigate('/contract');
            } else {
                await Swal.fire('Error!', 'An error occurred while creating the customer.', 'error');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <div className="create-product">
            <h1>Create Contract</h1>
            <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={createCustomer}>
                {({ values, setFieldValue }) => (
                    <Form>
                        <div>
                            <label>Contract Number:</label>
                            <Field type="text" name="contractNumber" className="form-control" />
                            <ErrorMessage name="contractNumber" component="div" className="error" />
                        </div>
                        <div className="mb-3 mt-3">
                            <label>Start Date:</label>
                            <DatePicker
                                className="form-control"
                                name="startDate"
                                selected={values.startDate}
                                onChange={(date) => setFieldValue('startDate', date)}
                                dateFormat="dd/MM/yyyy"
                                minDate={new Date()}
                            />
                            <ErrorMessage name="startDate" component="div" className="error" />
                        </div>

                        <div className="mb-3">
                            <label>End Date:</label>
                            <DatePicker
                                className="form-control"
                                name="endDate"
                                selected={values.endDate}
                                onChange={(date) => setFieldValue('endDate', date)}
                                dateFormat="dd/MM/yyyy"
                                minDate={values.startDate || new Date()}
                            />
                            <ErrorMessage name="endDate" component="div" className="error" />
                        </div>
                        <div>
                            <label>Advance Deposit:</label>
                            <Field type="number" name="advanceDeposit" className="form-control" />
                            <ErrorMessage name="advanceDeposit" component="div" className="error" />
                        </div>

                        <div>
                            <label>Total Payment:</label>
                            <Field type="number" name="totalPayment" className="form-control" />
                            <ErrorMessage name="totalPayment" component="div" className="error" />
                        </div>

                        <button
                            className="btn btn-outline-primary"
                            style={{ marginTop: '10px' }}
                            variant="primary"
                            type="submit"
                        >
                            Save
                        </button>
                    </Form>
                )}
            </Formik>
        </div>
    );
}

export default CreateContract;
