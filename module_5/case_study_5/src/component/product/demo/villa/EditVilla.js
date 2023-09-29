import React, { useEffect, useState } from 'react';
import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import * as VillaService from '../../../Service/demo/VillaService';
import { useNavigate, useParams } from 'react-router-dom';
import Swal from 'sweetalert2';

function EditVilla() {
    const navigate = useNavigate();
    const param = useParams();
    const [villa, setVilla] = useState(null);

    useEffect(() => {
        if (param.id) {
            getHouseById();
        }
    }, [param.id]);

    const getHouseById = async () => {
        try {
            setVilla(await VillaService.byIdVilla(param.id));
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const validationSchema = Yup.object().shape({
        serviceName: Yup.string().required('Tên dịch vụ là bắt buộc'),
        area: Yup.number().required('Diện tích là bắt buộc').positive().integer(),
        rentalCost: Yup.number().required('Chi phí thuê là bắt buộc').positive().integer(),
        maximumOccupancy: Yup.number().required('Số lượng người tối đa là bắt buộc').positive().integer(),
        rentalType: Yup.string().required('Kiểu thuê là bắt buộc'),
        imageSrc: Yup.string().required('Ảnh là bắt buộc'),
        roomStandard: Yup.string().required('Tiêu chuẩn phòng là bắt buộc'),
        otherAmenitiesDescription: Yup.string().required('Mô tả tiện nghi khác là bắt buộc'),
        numberOfFloors: Yup.number().required('Số tầng là bắt buộc').positive().integer(),
    });

    const editRoom = async (values) => {
        try {
            const res = await VillaService.edit(values);
            if (res.status === 200) {
                await Swal.fire('Sửa thành công!', 'Villa của bạn đã được sửa thành công.', 'success');
                navigate('/villa');
            } else {
                await Swal.fire('Lỗi!', 'Đã xảy ra lỗi trong quá trình sửa villa.', 'error');
            }

        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        villa && (
            <div className="create-product">
                <h1>Sửa dịch vụ</h1>
                <Formik
                    initialValues={{
                        id: villa?.id,
                        serviceType: villa?.serviceType,
                        serviceName: villa?.serviceName,
                        area: villa?.area,
                        rentalCost: villa?.rentalCost,
                        maximumOccupancy: villa?.maximumOccupancy,
                        rentalType: villa?.rentalType,
                        imageSrc: villa?.imageSrc,
                        roomStandard: villa?.roomStandard,
                        otherAmenitiesDescription: villa?.otherAmenitiesDescription,
                        numberOfFloors: villa?.numberOfFloors,
                        poolArea: villa?.poolArea

                    }}
                    onSubmit={editRoom}
                    validationSchema={validationSchema}
                >
                    <Form className="form-create">
                        <div>
                            <label>Tên dịch vụ:</label>
                            <Field type="text" name="serviceName" className="form-control" />
                            <ErrorMessage name="serviceName" component="div" className="error" />
                        </div>

                        <div>
                            <label>Diện tích sử dụng:</label>
                            <Field type="number" name="area" className="form-control" />
                            <ErrorMessage name="area" component="div" className="error" />
                        </div>

                        <div>
                            <label>Chi phí thuê:</label>
                            <Field type="number" name="rentalCost" className="form-control" />
                            <ErrorMessage name="rentalCost" component="div" className="error" />
                        </div>
                        <div>
                            <label>Link ảnh:</label>
                            <Field type="text" name="imageSrc" className="form-control" />
                            <ErrorMessage name="imageSrc" component="div" className="error" />
                        </div>

                        <div>
                            <label>Số lượng người tối đa:</label>
                            <Field type="number" name="maximumOccupancy" className="form-control" />
                            <ErrorMessage name="maximumOccupancy" component="div" className="error" />
                        </div>
                        <div>
                            <label>Kiểu thuê:</label>
                            <Field as="select" name="rentalType" className="form-control">
                                <option value="">Chọn kiểu thuê</option>
                                <option value="Yearly">Theo năm</option>
                                <option value="Monthly">Theo tháng</option>
                                <option value="Daily">Theo ngày</option>
                                <option value="Hourly">Theo giờ</option>
                            </Field>
                            <ErrorMessage name="rentalType" component="div" className="error" />
                        </div>
                        <div>
                            <label>Tiêu chuẩn phòng:</label>
                            <Field
                                type="text"
                                name="roomStandard"
                                className="form-control"
                            />
                            <ErrorMessage
                                name="roomStandard"
                                component="div"
                                className="error"
                            />
                        </div>

                        <div>
                            <label>Mô tả tiện nghi khác:</label>
                            <Field
                                type="text"
                                name="otherAmenitiesDescription"
                                className="form-control"
                            />
                            <ErrorMessage
                                name="otherAmenitiesDescription"
                                component="div"
                                className="error"
                            />
                        </div>

                        <div>
                            <label>Diện tích hồ bơi:</label>
                            <Field
                                type="number"
                                name="poolArea"
                                className="form-control"
                            />
                            <ErrorMessage name="poolArea" component="div" className="error"/>
                        </div>

                        <div>
                            <label>Số tầng:</label>
                            <Field type="number" name="numberOfFloors" className="form-control"/>
                            <ErrorMessage
                                name="numberOfFloors"
                                component="div"
                                className="error"
                            />
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
                </Formik>
            </div>
        )
    );
}

export default EditVilla;
