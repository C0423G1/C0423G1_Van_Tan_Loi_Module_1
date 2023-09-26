import React, {useEffect, useState} from 'react';
import {Form, Button} from 'react-bootstrap';
import {Field, Formik, ErrorMessage} from 'formik';
import * as Yup from 'yup';
import * as ProductService from '../Service/ProductService';
import Body from './Body';
import {useNavigate, useParams} from 'react-router-dom';
import Swal from 'sweetalert2';

function EditProduct() {
    const param = useParams()
    const [product, setProduct] = useState()
    const navigate = useNavigate();
    useEffect(() => {
        if (param.id) {
            getProductById();
        }
    }, []);
    const getProductById = async () => {
        const product = await ProductService.byIdProduct(param.id);
        console.log(product)
        setProduct(product);
    }

    const initialValues = {
        id: product?.id,
        title: product?.title,
        roomSize: product?.roomSize,
        imageSrc: product?.imageSrc,
        floor: product?.floor,
        areaOfPool: product?.areaOfPool,
    };

    const validationSchema = Yup.object().shape({
        title: Yup.string()
            .required('Title is required')
            .test('no-numbers', 'Title cannot contain numbers', function (value) {
                if (!value) return true;
                return !/\d/.test(value);
            }), roomSize: Yup.number()
            .required('Room Size is required')
            .positive('Room Size must be a positive number')
            .integer('Room Size must be an integer'),
        imageSrc: Yup.string().required('Image Src is required'),
        floor: Yup.number()
            .required('Floor is required')
            .positive('Floor must be a positive number')
            .integer('Floor must be an integer'),
        areaOfPool: Yup.number()
            .required('Swimming Pool Area is required')
            .positive('Swimming Pool Area must be a positive number')
            .integer('Swimming Pool Area must be an integer'),
    });


    const editRoom = async (values) => {
        try {
            console.log(values)
            const res = await ProductService.edit(values);
            if (res.status == 200) {
                await Swal.fire('Created!', 'Your room has been created successfully.', 'success');
                navigate('/');
            } else {
                await Swal.fire('Error!', 'An error occurred while creating the room.', 'error');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };
    if (!product) {
        return null
    }

    return (
        <>
            <div className="edit-product">
                <h2>Create Room</h2>
                <Formik
                    initialValues={initialValues}
                    validationSchema={validationSchema}
                    onSubmit={(values) => {
                        editRoom(values);
                    }}
                >
                    {({handleSubmit}) => (
                        <Form onSubmit={handleSubmit}>
                            <div className="mb-3">
                                <label htmlFor="title" className="form-label">
                                    Title
                                </label>
                                <Field name="title" type="text" className="form-control"/>
                                <ErrorMessage name="title" component="div" className="error"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="roomSize" className="form-label">
                                    Room Size
                                </label>
                                <Field name="roomSize" type="number" className="form-control"/>
                                <ErrorMessage name="roomSize" component="div" className="error"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="imageSrc" className="form-label">
                                    Image Src
                                </label>
                                <Field name="imageSrc" type="text" className="form-control"/>
                                <ErrorMessage name="imageSrc" component="div" className="error"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="floor" className="form-label">
                                    Floor
                                </label>
                                <Field name="floor" type="text" className="form-control"/>
                                <ErrorMessage name="floor" component="div" className="error"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="areaOfPool" className="form-label">
                                    Swimming Pool Area
                                </label>
                                <Field name="areaOfPool" type="number" className="form-control"/>
                                <ErrorMessage name="areaOfPool" component="div" className="error"/>
                            </div>
                            <Button type="submit" variant="primary">
                                Submit
                            </Button>
                        </Form>
                    )}
                </Formik>
            </div>
        </>
    );
}

export default EditProduct;
