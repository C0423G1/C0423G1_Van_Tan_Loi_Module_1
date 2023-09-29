import React, {useEffect, useState} from 'react';
import {Formik, Field, Form, ErrorMessage} from 'formik';
import * as Yup from 'yup';
import * as VillaService from "../../Service/demo/VillaService";
import * as HouseService from "../../Service/demo/HouseService";
import * as RoomService from "../../Service/demo/RoomService";
import {useNavigate} from "react-router-dom";

function CreateService() {
    const [selectedService, setSelectedService] = useState('');
    const navigate = useNavigate();
    let testt = {
        serviceType: "",
        serviceName: '',
        area: '',
        rentalCost: '',
        maximumOccupancy: '',
        rentalType: '',
        roomStandard: '',
        otherAmenitiesDescription: '',
        imageSrc: '',
        poolArea: '',
        numberOfFloors: '',
        freeAmenities: '',
    }
    const handleServiceChange = (e) => {
        setSelectedService(e.target.value);
        console.log(selectedService)
    };
    useEffect(() => {
        console.log(selectedService)
    }, [selectedService])

    const validationSchema = Yup.object().shape({
        serviceName: Yup.string().required('Tên dịch vụ là bắt buộc'),
        area: Yup.number().required('Diện tích là bắt buộc').positive().integer(),
        rentalCost: Yup.number().required('Chi phí thuê là bắt buộc').positive().integer(),
        maximumOccupancy: Yup.number().required('Số lượng người tối đa là bắt buộc').positive().integer(),
        rentalType: Yup.string().required('Kiểu thuê là bắt buộc'),
        imageSrc: Yup.string().required('Ảnh là bắt buộc'),

    });


    const villaValidationSchema = validationSchema.shape({
        roomStandard: Yup.string().required('Tiêu chuẩn phòng là bắt buộc'),
        otherAmenitiesDescription: Yup.string().required('Mô tả tiện nghi khác là bắt buộc'),
        poolArea: Yup.number().required('Diện tích hồ bơi là bắt buộc').positive().integer(),
        numberOfFloors: Yup.number().required('Số tầng là bắt buộc').positive().integer(),
    });

    const houseValidationSchema = validationSchema.shape({
        roomStandard: Yup.string().required('Tiêu chuẩn phòng là bắt buộc'),
        otherAmenitiesDescription: Yup.string().required('Mô tả tiện nghi khác là bắt buộc'),
        numberOfFloors: Yup.number().required('Số tầng là bắt buộc').positive().integer(),
    });

    const roomValidationSchema = validationSchema.shape({
        freeAmenities: Yup.string().required('Dịch vụ miễn phí đi kèm là bắt buộc'),
    });

    const handleSubmit = async (values) => {
        let object = {};
        switch (selectedService) {
            case "Villa":
                object = {
                    serviceType: selectedService,
                    serviceName: values.serviceName,
                    area: values.area,
                    rentalCost: values.rentalCost,
                    maximumOccupancy: values.maximumOccupancy,
                    rentalType: values.rentalType,
                    roomStandard: values.roomStandard,
                    otherAmenitiesDescription: values.otherAmenitiesDescription,
                    imageSrc: values.imageSrc,
                    poolArea: values.poolArea,
                    numberOfFloors: values.numberOfFloors,
                }
                await VillaService.createVilla(object);
                navigate("/villa")
                break;
            case "House":
                object = {
                    serviceType: selectedService,
                    serviceName: values.serviceName,
                    area: values.area,
                    rentalCost: values.rentalCost,
                    maximumOccupancy: values.maximumOccupancy,
                    rentalType: values.rentalType,
                    roomStandard: values.roomStandard,
                    otherAmenitiesDescription: values.otherAmenitiesDescription,
                    imageSrc: values.imageSrc,
                    numberOfFloors: values.numberOfFloors,
                }
                await HouseService.createHouse(object);
                navigate("/house")
                break;
            case "Room":
                object = {
                    serviceType: selectedService,
                    serviceName: values.serviceName,
                    area: values.area,
                    rentalCost: values.rentalCost,
                    maximumOccupancy: values.maximumOccupancy,
                    rentalType: values.rentalType,
                    imageSrc: values.imageSrc,
                    freeAmenities: values.freeAmenities
                }
                await RoomService.createRoom(object);
                navigate("/room")
                break;
        }
    };

    return (
        <div className="create-product">
            <h1>Tạo mới dịch vụ</h1>
            <Formik
                initialValues={testt}
                onSubmit={handleSubmit}
                validationSchema={
                    selectedService === 'Villa' ? villaValidationSchema
                        : selectedService === 'House' ? houseValidationSchema
                        : roomValidationSchema
                }>
                {({values}) => (
                    <Form className="form-create">
                        <div>
                            <label>Loại dịch vụ:</label>
                            <select className="form-select"
                                name="selectedService"
                                value={selectedService}
                                onChange={handleServiceChange}
                            >
                                <option value="Villa">Villa</option>
                                <option value="House">House</option>
                                <option value="Room">Room</option>
                            </select>
                        </div>
                        <div>
                            <label>Tên dịch vụ:</label>
                            <Field type="text" name="serviceName" className="form-control"/>
                            <ErrorMessage name="serviceName" component="div" className="error"/>
                        </div>

                        <div>
                            <label>Diện tích sử dụng:</label>
                            <Field type="number" name="area" className="form-control"/>
                            <ErrorMessage name="area" component="div" className="error"/>
                        </div>

                        <div>
                            <label>Chi phí thuê:</label>
                            <Field type="number" name="rentalCost" className="form-control"/>
                            <ErrorMessage name="rentalCost" component="div" className="error"/>
                        </div>
                        <div>
                            <label>Link ảnh:</label>
                            <Field type="text" name="imageSrc" className="form-control"/>
                            <ErrorMessage name="imageSrc" component="div" className="error"/>
                        </div>

                        <div>
                            <label>Số lượng người tối đa:</label>
                            <Field
                                type="number"
                                name="maximumOccupancy"
                                className="form-control"
                            />
                            <ErrorMessage
                                name="maximumOccupancy"
                                component="div"
                                className="error"
                            />
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
                            <ErrorMessage name="rentalType" component="div" className="error"/>
                        </div>

                        {selectedService === 'Villa' && (
                            <>
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
                            </>
                        )}

                        {selectedService === 'House' && (
                            <>
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
                                    <label>Số tầng:</label>
                                    <Field type="number" name="numberOfFloors" className="form-control"/>
                                    <ErrorMessage
                                        name="numberOfFloors"
                                        component="div"
                                        className="error"
                                    />
                                </div>
                            </>
                        )}

                        {selectedService === 'Room' && (
                            <div>
                                <label>Dịch vụ miễn phí đi kèm:</label>
                                <Field
                                    type="text"
                                    name="freeAmenities"
                                    className="form-control"
                                />
                                <ErrorMessage
                                    name="freeAmenities"
                                    component="div"
                                    className="error"
                                />
                            </div>
                        )}

                        <button
                            className="btn btn-outline-primary"
                            style={{marginTop: '10px'}}
                            variant="primary"
                            type="submit">
                            Lưu
                        </button>
                    </Form>
                )}
            </Formik>
        </div>
    );
}

export default CreateService;
