import React  from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faLock, faUser } from '@fortawesome/free-solid-svg-icons';
function RegisterForm({ toggleForm }) {
    return (
        <div className="form-box register">
            <form action="">
                <h2>Sign Up</h2>
                <div className="input-box">
                    <span className="icon"><FontAwesomeIcon icon={faUser} /></span>
                    <input type="text" required />
                    <label>Username</label>
                </div>
                <div className="input-box">
                    <span className="icon"><FontAwesomeIcon icon={faEnvelope} /></span>
                    <input type="email" required />
                    <label>Email</label>
                </div>
                <div className="input-box">
                    <span className="icon"><FontAwesomeIcon icon={faLock} /></span>
                    <input type="password" required />
                    <label>Password</label>
                </div>
                <div className="remember-password">
                    <label htmlFor=""><input type="checkbox" />I agree with this statement</label>
                </div>
                <button className="btn">Register</button>
                <div className="create-account">
                    <p>Already Have An Account? <a href="#" className="login-link" onClick={toggleForm}>Sign In</a></p>
                </div>
            </form>
        </div>
    );
}
export default RegisterForm;