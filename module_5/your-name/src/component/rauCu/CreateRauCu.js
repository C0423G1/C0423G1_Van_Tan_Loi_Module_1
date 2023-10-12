import React, {useEffect, useState} from 'react';
import {ErrorMessage, Field, Formik, Form} from 'formik';
import * as RauCuService from '../../service/RauCuService';
import Swal from 'sweetalert2';
import {useNavigate} from 'react-router-dom';
import * as Yup from 'yup';

function CreateRauCu() {
    const navigate = useNavigate();
    const [rauCu, setRauCu] = useState([]);

    const validationSchema = Yup.object().shape({
        tenHangHoa: Yup.string().required('Vui lòng nhập Tên Hàng Hoá'),
        donViTinh: Yup.string().required('Vui lòng chọn Đơn vị tính'),
        gia: Yup.number()
            .positive('Giá phải là số nguyên dương')
            .min(1000, 'Giá phải lớn hơn hoặc bằng 1.000 VNĐ')
            .required('Vui lòng nhập Giá'),
        ngayThuHoach: Yup.date()
            .min(new Date(), 'Ngày thu hoạch phải sau Ngày hiện tại')
            .required('Vui lòng chọn Ngày Thu hoạch'),
        loaiHangHoa: Yup.string().required('Vui lòng chọn Loại Hàng Hoá'),
    });

    const getRauCu = async () => {
        try {
            const response = await RauCuService.getAllType();
            setRauCu(response);
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

    const createRauCu = async (values) => {
        try {
            let object = {
                ...values,
                loaiHangHoa: JSON.parse(values.loaiHangHoa),
            };
            console.log(object);
            const res = await RauCuService.create(object);
            if (res.status === 201) {
                await Swal.fire('Tạo thành công!', ' đã được tạo thành công.', 'success');
                navigate('/');
            } else {
                await Swal.fire('Lỗi!', 'Đã xảy ra lỗi khi tạo .', 'error');
            }
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

    useEffect(() => {
        getRauCu();
    }, []);

    return (
        <>
            <Formik
                initialValues={{
                    tenHangHoa: '',
                    donViTinh: 'Kg',
                    gia: 0,
                    ngayThuHoach: new Date(),
                    loaiHangHoa: JSON.stringify({
                        id: 1,
                        name: 'rau',
                    }),
                }}
                onSubmit={createRauCu}
                validationSchema={validationSchema}
            >
                <Form>
                    <label>Tên Hàng Hoá</label>
                    <Field type="text" name="tenHangHoa"/>
                    <ErrorMessage name="tenHangHoa" component="span"/>
                    <label>Đơn vị tính</label>
                    <Field as="select" name="donViTinh">
                        <option value="Kg">Kg</option>
                        <option value="Túi">Túi</option>
                        <option value="Bó">Bó</option>
                    </Field>
                    <ErrorMessage name="donViTinh" component="div"/>
                    <label>Giá</label>
                    <Field type="number" name="gia"/>
                    <ErrorMessage name="gia" component="div"/>
                    <label>Loại Hàng Hoá</label>
                    <Field as="select" name="loaiHangHoa">
                        {rauCu.map((rau) => (
                            <option key={rau.id} value={JSON.stringify(rau)}>
                                {rau.name}
                            </option>
                        ))}
                    </Field>
                    <ErrorMessage name="loaiHangHoa" component="div"/>

                    <label>Ngày Thu hoạch</label>
                    <Field type="date" name="ngayThuHoach"/>
                    <ErrorMessage name="ngayThuHoach" component="div"/>

                    <button type="submit">Thêm mới</button>
                </Form>
            </Formik>
        </>
    );
}

export default CreateRauCu;
