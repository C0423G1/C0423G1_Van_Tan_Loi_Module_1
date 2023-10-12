import React, {useEffect, useState} from 'react';
import {Formik, Form, Field, validateYupSchema, ErrorMessage} from "formik";
import * as RauCuService from "../../service/RauCuService"
import {useNavigate} from "react-router-dom";
import * as Yup from "yup";


function Create() {
    const [loai, setLoai] = useState([])
    const navigate = useNavigate()
    const getLoai = async () => {
        setLoai(await RauCuService.getAllType())
    }
    useEffect(() => {
        getLoai()
    }, [])

    const createLoai = async (values) => {
        let object = {
            ...values,
            loaiHangHoa: JSON.parse(values.loaiHangHoa)
        }
        const res = await RauCuService.create(object);
        navigate("/")
    }
    const validateYupSchema = Yup.object().shape({
        maHangHoa: Yup.string().required("Vui lòng nhập"),
        tenHangHoa: Yup.string().required("Vui lòng nhập"),
        gia: Yup.number().required("Vui lòng nhập").min(1000, "Giá tối thiểu 1000"),
        ngayThuHoach: Yup.date().required("Vui lòng nhập").min(new Date(), "Ngày phải là hôm nay")
    })

    return (
        <>
            <Formik initialValues={{
                maHangHoa: "",
                tenHangHoa: "",
                donViTinh: "kg",
                gia: 1000,
                ngayThuHoach: new Date(),
                "loaiHangHoa": JSON.stringify(
                    {
                        id: 1,
                        name: "rau"
                    }
                )
            }} validationSchema={validateYupSchema} onSubmit={createLoai}>
                <Form>
                    <label>Mã Hàng Hoá</label>
                    <Field type="text" name="maHangHoa"></Field>
                    <ErrorMessage name="maHangHoa"></ErrorMessage>
                    <label>Tên hàng hoá</label>
                    <Field type="text" name="tenHangHoa"></Field>
                    <Field as="select" name="donViTinh">
                        <option value="Kg">Kg</option>
                        <option value="Túi">Túi</option>
                        <option value="Bó">Bó</option>
                    </Field>
                    <label>Giá</label>
                    <Field name="gia" type="number"></Field>
                    <label>Loại Hàng Hoá</label>
                    <Field name="loaiHangHoa" as="select">
                        {loai.map((loai) => (
                            <option key={loai.id} value={JSON.stringify(loai)}>{loai.name}</option>
                        ))}
                    </Field>
                    <label>Ngày Thu Hoạch</label>
                    <Field type="date" name="ngayThuHoach"></Field>
                    <ErrorMessage name="ngayThuHoach"></ErrorMessage>
                    <button type="submit">Submit</button>
                </Form>
            </Formik>
        </>
    );
}

export default Create;