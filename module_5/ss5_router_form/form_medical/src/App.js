import React from "react";
import {Formik, Form, Field, ErrorMessage} from "formik";
import * as Yup from "yup";
import './App.css';

function App() {
    const initialValues = {
        fullName: "",
        passportOrID: "",
        birthYear: "",
        gender: "male",
        nationality: "",
        company: "",
        department: "",
        hasHealthInsurance: false,
        address: {
            province: "",
            district: "",
            ward: "",
            street: "",
            phoneNumber: "",
            email: ""
        },
        recentTravel: "",
        symptoms: [],
        contactWithCovid: [],
    };

    const validationSchema = Yup.object().shape({
        fullName: Yup.string().required("Họ tên không được để trống"),
        passportOrID: Yup.string().required("Số hộ chiếu / CMND không được để trống"),
        birthYear: Yup.string().required("Năm sinh không được để trống"),
        gender: Yup.string().required("Giới tính không được để trống"),
        nationality: Yup.string().required("Quốc tịch không được để trống"),
        company: Yup.string().required("Công ty làm việc không được để trống"),
        department: Yup.string().required("Bộ phận làm việc không được để trống"),
        address: Yup.object().shape({
            province: Yup.string().required("Tỉnh thành không được để trống"),
            district: Yup.string().required("Quận Huyên không được để trống"),
            ward: Yup.string().required("Phường/xã không được để trống"),
            street: Yup.string().required("Số nhà, phố, tổ dân phố/thôn/đội không được để trống"),
            phoneNumber: Yup.string().required("Điện thoại không được để trống"),
            email: Yup.string().email("Email không hợp lệ").required("Email không được để trống"),
        }),
    });

    const onSubmit = (values) => {
        console.log("Dữ liệu đã được lưu", values);
    };

    return (
        <div className="container mt-5">
            <Formik
                initialValues={initialValues}
                onSubmit={onSubmit}
                validationSchema={validationSchema}
            >
                <Form>
                    <h1>Tờ Khai Y Tế</h1>
                    <div className="mb-3">
                        <label htmlFor="fullName" className="form-label">
                            Họ tên:
                        </label>
                        <Field type="text" id="fullName" name="fullName" className="form-control"/>
                        <ErrorMessage name="fullName" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="passportOrID" className="form-label">
                            Số hộ chiếu / CMND:
                        </label>
                        <Field type="text" id="passportOrID" name="passportOrID" className="form-control"/>
                        <ErrorMessage name="passportOrID" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="birthYear" className="form-label">
                            Năm Sinh:
                        </label>
                        <Field type="text" id="birthYear" name="birthYear" className="form-control"/>
                        <ErrorMessage name="birthYear" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label>Giới Tính:</label>
                        <div>
                            <label className="form-check-label me-3">
                                <Field type="radio" name="gender" value="male" className="form-check-input"/>
                                Nam
                            </label>
                            <label className="form-check-label">
                                <Field type="radio" name="gender" value="female" className="form-check-input"/>
                                Nữ
                            </label>
                        </div>
                        <ErrorMessage name="gender" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="nationality" className="form-label">
                            Quốc tịch:
                        </label>
                        <Field type="text" id="nationality" name="nationality" className="form-control"/>
                        <ErrorMessage name="nationality" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="company" className="form-label">
                            Công ty làm việc:
                        </label>
                        <Field type="text" id="company" name="company" className="form-control"/>
                        <ErrorMessage name="company" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="department" className="form-label">
                            Bộ phận làm việc:
                        </label>
                        <Field type="text" id="department" name="department" className="form-control"/>
                        <ErrorMessage name="department" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label className="form-check-label">Có thẻ bảo hiểm y tế:</label>
                        <Field type="checkbox" name="hasHealthInsurance" className="form-check-input"/>
                    </div>
                    <h3>Địa chỉ liên lạc tại Việt Nam</h3>
                    <div className="mb-3">
                        <label htmlFor="address.province" className="form-label">
                            Tỉnh thành:
                        </label>
                        <Field type="text" id="address.province" name="address.province" className="form-control"
                               placeholder="Tỉnh thành"/>
                        <ErrorMessage name="address.province" component="div" className="error"/>

                        {/* Repeat the same structure for other address fields */}
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address.district" className="form-label">
                            Quận Huyên:
                        </label>
                        <Field type="textarea" id="address.district" name="address.district" className="form-control"/>
                        <ErrorMessage name="address.district" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address.ward" className="form-label">
                            Phường/xã:
                        </label>
                        <Field type="text" id="address.ward" name="address.ward" className="form-control"/>
                        <ErrorMessage name="address.ward" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address.street" className="form-label">
                            Số nhà, phố , tổ dân phố/thôn/đội:
                        </label>
                        <Field type="text" id="address.street" name="address.street" className="form-control"/>
                        <ErrorMessage name="address.street" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address.phoneNumber" className="form-label">
                            Điện Thoại:
                        </label>
                        <Field type="text" id="address.phoneNumber" name="address.phoneNumber"
                               className="form-control"/>
                        <ErrorMessage name="address.phoneNumber" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address.email" className="form-label">
                            Email:
                        </label>
                        <Field type="text" id="address.email" name="address.email" className="form-control"/>
                        <ErrorMessage name="address.email" component="div" className="error"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="recentTravel" className="form-label">
                            Trong vòng 14 ngày qua, Anh/Chị có đến quốc gia/vùng lãnh thổ nào?
                        </label>
                        <Field
                            as="textarea"
                            id="recentTravel"
                            name="recentTravel"
                            className="form-control"
                        />
                        <ErrorMessage
                            name="recentTravel"
                            component="div"
                            className="error"
                        />
                    </div>

                    <div className="mb-3">
                        <label>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</label><br/>
                        <div>
                            <label className="form-check-label me-3">
                                <Field type="checkbox" name="symptoms" value="Sốt" className="form-check-input"/>
                                Sốt
                            </label><br/>
                            <label className="form-check-label me-3">
                                <Field type="checkbox" name="symptoms" value="Ho" className="form-check-input"/>
                                Ho
                            </label><br/>
                            <label className="form-check-label me-3">
                                <Field type="checkbox" name="symptoms" value="Khó thở" className="form-check-input"/>
                                Khó thở
                            </label><br/>
                            <label className="form-check-label me-3">
                                <Field type="checkbox" name="symptoms" value="Viêm phổi" className="form-check-input"/>
                                Viêm phổi
                            </label><br/>
                            <label className="form-check-label me-3">
                                <Field type="checkbox" name="symptoms" value="Đau họng" className="form-check-input"/>
                                Đau họng
                            </label><br/>
                            <label className="form-check-label">
                                <Field type="checkbox" name="symptoms" value="Mệt mỏi" className="form-check-input"/>
                                Mệt mỏi
                            </label><br/>
                        </div>
                        <ErrorMessage
                            name="symptoms"
                            component="div"
                            className="error"
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="contactWithCovid" className="form-label">
                            Trong vòng 14 ngày qua, Anh/Chị có tiếp xúc với người nhiễm COVID-19 không?
                        </label><br/>
                        <label className="form-check-label me-3">
                            <Field type="checkbox" name="contactWithCovid"
                                   value="Người bệnh hoặc nghi ngờ , mặc bệnh COVID-19" className="form-check-input"/>
                            Người bệnh hoặc nghi ngờ , mặc bệnh COVID-19
                        </label><br/>
                        <label className="form-check-label me-3">
                            <Field type="checkbox" name="contactWithCovid" value="Người từ nước có bệnh COVID-19"
                                   className="form-check-input"/>
                            Người từ nước có bệnh COVID-19
                        </label><br/>
                        <label className="form-check-label me-3">
                            <Field type="checkbox" name="contactWithCovid"
                                   value="Người có biểu hiện (Sốt, ho, khó thở, viêm phổi)"
                                   className="form-check-input"/>
                            Người có biểu hiện (Sốt, ho, khó thở, viêm phổi)
                        </label><br/>
                        <ErrorMessage
                            name="contactWithCovid"
                            component="div"
                            className="error"
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">
                        Submit
                    </button>
                </Form>
            </Formik>
        </div>
    );
}

export default App;
