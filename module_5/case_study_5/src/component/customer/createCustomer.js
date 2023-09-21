import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './Create.css';

function CreateCustomer() {
    const [customerName, setCustomerName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [idCardNumber, setIdCardNumber] = useState('');
    const [email, setEmail] = useState('');
    const [birthDate, setBirthDate] = useState(null);
    const [nameError, setNameError] = useState('');
    const [phoneError, setPhoneError] = useState('');
    const [idCardError, setIdCardError] = useState('');
    const [emailError, setEmailError] = useState('');
    const [birthDateError, setBirthDateError] = useState('');

    const handleFormSubmit = (e) => {
        e.preventDefault();

        const nameRegex = /^[A-Z][a-z]*( [A-Z][a-z]*)*$/;
        const phoneRegex = /^(0[9][0-9]{8}|\(84\)\+0[9][0-9]{8})$/;
        const idCardRegex = /^[0-9]{9,12}$/;
        const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

        const isNameValid = nameRegex.test(customerName);
        const isPhoneValid = phoneRegex.test(phoneNumber);
        const isIdCardValid = idCardRegex.test(idCardNumber);
        const isEmailValid = emailRegex.test(email);

        if (!isNameValid) {
            setNameError('Invalid name');
        } else {
            setNameError('');
        }

        if (!isPhoneValid) {
            setPhoneError('Invalid phone number');
        } else {
            setPhoneError('');
        }

        if (!isIdCardValid) {
            setIdCardError('Invalid ID card number');
        } else {
            setIdCardError('');
        }

        if (!isEmailValid) {
            setEmailError('Invalid email');
        } else {
            setEmailError('');
        }

        if (!birthDate) {
            setBirthDateError('Please select a valid birth date');
        } else {
            setBirthDateError('');
        }
    };

    return (
        <div className="container">
            <h1>Customer Form</h1>
            <form onSubmit={handleFormSubmit}>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        value={customerName}
                        onChange={(e) => setCustomerName(e.target.value)}
                    />
                    {nameError && <div className="error-message">{nameError}</div>}
                </div>
                <div>
                    <label>Phone Number:</label>
                    <input
                        type="text"
                        value={phoneNumber}
                        onChange={(e) => setPhoneNumber(e.target.value)}
                    />
                    {phoneError && <div className="error-message">{phoneError}</div>}
                </div>
                <div>
                    <label>ID Card Number:</label>
                    <input
                        type="text"
                        value={idCardNumber}
                        onChange={(e) => setIdCardNumber(e.target.value)}
                    />
                    {idCardError && <div className="error-message">{idCardError}</div>}
                </div>
                <div>
                    <label>Email:</label>
                    <input
                        type="text"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    {emailError && <div className="error-message">{emailError}</div>}
                </div>
                <div>
                    <label>Birth Date:</label>
                    <DatePicker selected={birthDate} onChange={(date) => setBirthDate(date)} />
                    {birthDateError && <div className="error-message">{birthDateError}</div>}
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default CreateCustomer;
