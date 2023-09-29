import React, { useEffect, useState } from 'react';
import { ErrorMessage, Field, Formik, Form } from 'formik';
import * as Yup from 'yup';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '@fortawesome/fontawesome-free/css/all.css';
import * as ContractService from '../Service/ContractService';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router';
import { useParams } from 'react-router-dom';

function EditContract() {
    const navigate = useNavigate();
    const param = useParams();
    const [contracts, setContracts] = useState(null);
    const [dateStart, setDateStart] = useState(new Date());
    const [dateEnd, setDateEnd] = useState(new Date());

    useEffect(() => {
        if (param.id) {
            getContractById();
        }
    }, [param.id]);

    const getContractById = async () => {
        try {
            const contract = await ContractService.byIdContract(param.id);
            if (contract) {
                setContracts(contract);
                setDateStart(new Date(contract.startDate));
                setDateEnd(new Date(contract.endDate));
            }
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

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
            .typeError('Tổng số tiền phải là số nguyên dương')
            .required('Tổng số tiền là bắt buộc')
            .integer('Tổng số tiền phải là số nguyên')
            .min(1, 'Tổng số tiền phải là số nguyên dương'),
    });

    const initialValues = {
        id: contracts?.id,
        contractNumber: contracts?.contractNumber,
        startDate: dateStart,
        endDate: dateEnd,
        advanceDeposit: contracts?.advanceDeposit,
        totalPayment: contracts?.totalPayment,
    };

    const editCustomer = async (values) => {
        try {
            const res = await ContractService.edit(values);
            if (res.status === 200) {
                await Swal.fire('Chỉnh sửa thành công!', 'Hợp đồng của bạn đã được chỉnh sửa thành công.', 'success');
                navigate('/contract');
            } else {
                await Swal.fire('Lỗi!', 'Đã xảy ra lỗi trong quá trình chỉnh sửa hợp đồng.', 'error');
            }
        } catch (error) {
            console.error('Lỗi:', error);
        }
    };

    return (
        contracts && (
            <div className="create-product">
                <h1>Chỉnh sửa hợp đồng</h1>
                <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={editCustomer}>
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
                                selected={dateStart}
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
                                selected={dateEnd}
                                dateFormat="dd/MM/yyyy"
                                minDate={dateStart || new Date()}
                            />
                            <ErrorMessage name="endDate" component="div" className="error" />
                        </div>
                        <div>
                            <label>Tiền đặt cọc:</label>
                            <Field type="number" name="advanceDeposit" className="form-control" />
                            <ErrorMessage name="advanceDeposit" component="div" className="error" />
                        </div>

                        <div>
                            <label>Tổng số tiền:</label>
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
                </Formik>
            </div>
        )
    );
}

export default EditContract;
