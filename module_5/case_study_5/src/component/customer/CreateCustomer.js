import React, { useEffect } from 'react';
import { ErrorMessage, Field, Formik, Form } from 'formik';
import * as Yup from 'yup';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '@fortawesome/fontawesome-free/css/all.css';
import * as CustomerService from '../Service/CustomerService';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router';

function CreateCustomer() {
    const navigate = useNavigate();

    const validationSchema = Yup.object().shape({
        fullName: Yup.string()
            .matches(/^[A-Za-z\s]*$/, 'Tên không hợp lệ')
            .required('Tên không được để trống'),
        phoneNumber: Yup.string()
            .matches(/^(0[0-9]{9}|\(84\)\+0[0-9]{9})$/, 'Số điện thoại không hợp lệ')
            .required('Số điện thoại không được để trống'),
        idCardNumber: Yup.string()
            .matches(/^[0-9]{9,12}$/, 'Số CMND không hợp lệ')
            .required('Số CMND không được để trống'),
        email: Yup.string()
            .matches(/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/, 'Email không hợp lệ')
            .required('Email không được để trống'),
        dateOfBirth: Yup.string().required('Ngày sinh không được để trống'),
        gender: Yup.string().required('Giới tính không được để trống'),
        customerType: Yup.string().required('Loại khách hàng không được để trống'),
        address: Yup.string().required('Địa chỉ không được để trống'),
    });

    const initialValues = {
        fullName: '',
        phoneNumber: '',
        idCardNumber: '',
        email: '',
        dateOfBirth: new Date(),
        gender: "",
        customerType: "",
        address: ""
    };

    const createCustomer = async (values) => {
        try {
            const res = await CustomerService.create(values);
            if (res.status === 201) {
                await Swal.fire('Đã tạo!', 'Khách hàng của bạn đã được tạo thành công.', 'success');
                navigate('/customer');
            } else {
                await Swal.fire('Lỗi!', 'Đã xảy ra lỗi trong quá trình tạo khách hàng.', 'error');
            }
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

    return (
        <div className="create-product">
            <h1>Tạo Khách hàng</h1>
            <Formik initialValues={initialValues} validationSchema={validationSchema}
                    onSubmit={(values) => createCustomer(values)}>
                <Form className="form-create">
                    <div>
                        <label>Tên:</label>
                        <Field type="text" name="fullName" className="form-control"/>
                        <ErrorMessage name="fullName" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Số điện thoại:</label>
                        <Field type="text" name="phoneNumber" className="form-control"/>
                        <ErrorMessage name="phoneNumber" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Số CMND:</label>
                        <Field type="text" name="idCardNumber" className="form-control"/>
                        <ErrorMessage name="idCardNumber" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Email:</label>
                        <Field type="text" name="email" className="form-control"/>
                        <ErrorMessage name="email" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label>Ngày sinh:</label>
                        <div className="input-group">
                            <DatePicker
                                className="form-control"
                                id="birthDate"
                                name="dateOfBirth"
                                selected={new Date()}
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
                        <label>Giới tính:</label>
                        <Field as="select" name="gender" className="form-select">
                            <option value="">Giới tính</option>
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                        </Field>
                        <ErrorMessage name="gender" component="div" className="error"/>
                    </div>
                    <div>
                        <label>Loại khách hàng:</label>
                        <Field as="select" name="customerType" className="form-select">
                            <option value="">Loại khách hàng</option>
                            <option value="Diamond">Diamond</option>
                            <option value="Platinium">Platinium</option>
                            <option value="Gold">Gold</option>
                            <option value="Member">Member</option>
                            <option value="Silver">Silver</option>
                        </Field>
                        <ErrorMessage name="customerType" component="div" className="error"/>
                    </div>

                    <div>
                        <label>Địa chỉ:</label>
                        <Field type="text" name="address" className="form-control"/>
                        <ErrorMessage name="address" component="div" className="error"/>
                    </div>
                    <button className="btn btn-outline-primary" style={{ marginTop: "10px" }} variant="primary" type="submit">
                        Lưu
                    </button>
                </Form>
            </Formik>
        </div>
    );
}

export default CreateCustomer;
