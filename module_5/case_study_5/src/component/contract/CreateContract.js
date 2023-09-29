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
        contractNumber: Yup.string().required('Số hợp đồng là bắt buộc'),
        startDate: Yup.date().required('Ngày bắt đầu là bắt buộc'),
        endDate: Yup.date()
            .required('Ngày kết thúc là bắt buộc')
            .min(Yup.ref('startDate'), 'Ngày kết thúc phải sau ngày bắt đầu'),
        advanceDeposit: Yup.number()
            .typeError('Tiền đặt cọc phải là số nguyên dương')
            .required('Tiền đặt cọc là bắt buộc')
            .integer('Tiền đặt cọc phải là số nguyên')
            .min(1, 'Tiền đặt cọc phải là số nguyên dương'),
        totalPayment: Yup.number()
            .typeError('Tổng thanh toán phải là số nguyên dương')
            .required('Tổng thanh toán là bắt buộc')
            .integer('Tổng thanh toán phải là số nguyên')
            .min(1, 'Tổng thanh toán phải là số nguyên dương'),
    });

    const initialValues = {
        contractNumber: '',
        startDate: null,
        endDate: null,
        advanceDeposit: 0,
        totalPayment: 0,
    };

    const createContract = async (values) => {
        try {
            const res = await ContractService.create(values);
            if (res.status === 201) {
                await Swal.fire('Tạo thành công!', 'Hợp đồng đã được tạo thành công.', 'success');
                navigate('/contract');
            } else {
                await Swal.fire('Lỗi!', 'Đã xảy ra lỗi khi tạo hợp đồng.', 'error');
            }
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

    return (
        <div className="create-product">
            <h1>Tạo hợp đồng</h1>
            <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={createContract}>
                {({ values, setFieldValue }) => (
                    <Form className="form-create">
                        <div>
                            <label>Số hợp đồng:</label>
                            <Field type="text" name="contractNumber" className="form-control" />
                            <ErrorMessage name="contractNumber" component="div" className="error" />
                        </div>
                        <div className="mb-3 mt-3">
                            <label>Ngày bắt đầu:</label>
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
                            <label>Ngày kết thúc:</label>
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
                            <label>Tiền đặt cọc:</label>
                            <Field type="number" name="advanceDeposit" className="form-control" />
                            <ErrorMessage name="advanceDeposit" component="div" className="error" />
                        </div>

                        <div>
                            <label>Tổng thanh toán:</label>
                            <Field type="number" name="totalPayment" className="form-control" />
                            <ErrorMessage name="totalPayment" component="div" className="error" />
                        </div>

                        <button
                            className="btn btn-outline-primary"
                            style={{ marginTop: '10px' }}
                            variant="primary"
                            type="submit"
                        >
                            Lưu
                        </button>
                    </Form>
                )}
            </Formik>
        </div>
    );
}

export default CreateContract;
