// import React  from 'react';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faEnvelope, faLock, faUser } from '@fortawesome/free-solid-svg-icons';
// function RegisterForm({ toggleForm }) {
//     return (
//         <div className="form-box register">
//             <form action="">
//                 <h2>Đăng kí</h2>
//                 <div className="input-box">
//
//                    <input type="text" required />
//                     <label>Tài Khoản</label>
//                 </div>
//                 <div className="input-box">
//                     <span className="icon"><FontAwesomeIcon icon={faEnvelope} /></span>
//                     <input type="email" required />
//                     <label>Email</label>
//                 </div>
//                 <div className="input-box">
//                     <span className="icon"><FontAwesomeIcon icon={faLock} /></span>
//                     <input type="password" required />
//                     <label>Mật khẩu </label>
//                 </div>
//                 <button className="btn">Đăng kí </button>
//                 <div className="create-account">
//                     <p>Bạn đã có tài khoản? <a href="#" className="login-link" onClick={toggleForm}>Đăng kí</a></p>
//                 </div>
//             </form>
//         </div>
//     );
// }
// export default RegisterForm;


// ------------------------------------------------------------------------------------------
import React from 'react';
import {Formik, Field, Form, ErrorMessage} from 'formik';
import * as Yup from 'yup';
import * as UserService from "../../../service/APICity/UserService";
import Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";
import {faEnvelope, faLock, faUser} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function RegisterForm({toggleForm}) {
    const navigate = useNavigate();
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
        <div className="form-box register">
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}
            >
                <Form>
                    <h2>Đăng kí</h2>
                    <div className="input-box">
                        <span className="icon"><FontAwesomeIcon icon={faUser} /></span>
                        <Field as="input" type="text" id="userName" name="userName" />
                        <label htmlFor="userName">Tên người dùng</label>
                    </div>
                    <div className="input-box">
                        <span className="icon"><FontAwesomeIcon icon={faEnvelope} /></span>
                        <Field type="email" id="email" name="email" />
                        <label htmlFor="email">Email</label>
                    </div>
                    <div className="input-box">
                        <span className="icon"><FontAwesomeIcon icon={faLock} /></span>
                        <Field type="password" id="pass" name="pass" />
                        <label htmlFor="pass">Mật khẩu</label>
                    </div>
                    <button className="btn" type="submit">Đăng ký</button>
                    <div className="create-account">
                        <p>Bạn đã có tài khoản? <a href="#" className="login-link" onClick={toggleForm}>Đăng nhập</a>
                        </p>
                    </div>
                </Form>
            </Formik>
        </div>
    );
}

export default RegisterForm;
