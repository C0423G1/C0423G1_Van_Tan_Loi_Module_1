import React from "react";
import {Formik, Form, Field, ErrorMessage} from "formik";
import * as Yup from 'yup';
import "./modal.css";
import * as UserService from "../../../service/APICity/UserService";
import Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";

function Register() {
    const navigate = useNavigate()
    const initialValues = {
        userName: "",
        email: "",
        pass: "",
    };

    const validationSchema = Yup.object({
        userName: Yup.string()
            .required("Không để trống tên người dùng")
            .min(3, "Tên người dùng phải có ít nhất 3 ký tự"),
        email: Yup.string()
            .email("Email không hợp lệ")
            .required("Không để trống email"),
        pass: Yup.string()
            .required("Không để trống mật khẩu")
            .min(6, "Mật khẩu phải có ít nhất 6 ký tự"),
    });

    const onSubmit = async (values, actions) => {
        try {
            await UserService.registerUser(values);
            console.log("Đăng ký thành công với các giá trị sau:");
            console.log("Tên người dùng:", values.userName);
            console.log("Email:", values.email);
            console.log("Mật khẩu:", values.pass);
            actions.resetForm();
            Swal.fire({
                icon: 'success',
                title: 'Đăng ký thành công!',
                showConfirmButton: false,
                timer: 1500
            });
            navigate("/login")
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Đăng ký thất bại',
                text: 'Có lỗi xảy ra khi đăng ký. Vui lòng thử lại sau.',
            });
            navigate("/login")
        }
    };


    return (
        <div className="tabcontent">
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}
            >
                <Form>
                    <div className="input-container">
                        <label htmlFor="userName">Tên người dùng</label>
                        <Field type="text" id="userName" name="userName" placeholder="Chọn tên người dùng"/>
                        <ErrorMessage name="userName" component="div" className="error"/>
                    </div>
                    <div className="input-container">
                        <label htmlFor="email">Email</label>
                        <Field type="email" id="email" name="email" placeholder="Nhập địa chỉ email của bạn"/>
                        <ErrorMessage name="email" component="div" className="error"/>
                    </div>
                    <div className="input-container">
                        <label htmlFor="pass">Mật khẩu</label>
                        <Field type="password" id="pass" name="pass" placeholder="Chọn mật khẩu"/>
                        <ErrorMessage name="pass" component="div" className="error"/>
                    </div>
                    <button type="submit">Đăng ký</button>
                </Form>
            </Formik>
        </div>
    );
}

export default Register;
