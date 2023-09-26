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
    console.log(contracts)
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
            console.error('Error:', error);
        }
    };

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
        id:contracts?.id,
        contractNumber: contracts?.contractNumber,
        startDate: dateStart,
        endDate: dateEnd,
        advanceDeposit: contracts?.advanceDeposit ,
        totalPayment: contracts?.totalPayment ,
    };

    const editCustomer = async (values) => {
        try {
            const res = await ContractService.edit(values);
            if (res.status === 200) {
                await Swal.fire('Edited!', 'Your contract has been edited successfully.', 'success');
                navigate('/contract');
            } else {
                await Swal.fire('Error!', 'An error occurred while editing the contract.', 'error');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        contracts &&
        <div className="edit-contract">
            <h1>Edit Contract</h1>
            <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={editCustomer}>
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
                                selected={dateStart}
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
                                selected={dateEnd}
                                dateFormat="dd/MM/yyyy"
                                minDate={dateStart || new Date()}
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
                            type="submit">Save
                        </button>
                    </Form>
            </Formik>
        </div>
    );
}

export default EditContract;
