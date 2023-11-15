// import React from 'react';
// import { GoogleOAuthProvider, GoogleLogin, useGoogleOneTapLogin } from '@react-oauth/google';
//
// const GoogleAuthComponent = () => {
//     const handleLoginSuccess = (credentialResponse) => {
//         console.log(credentialResponse);
//     };
//
//     const handleOneTapLoginSuccess = (credentialResponse) => {
//         console.log(credentialResponse);
//     };
//
//     const handleClick = () => {
//         useGoogleOneTapLogin({
//             onSuccess: handleOneTapLoginSuccess,
//         });
//     };
//
//     return (
//         <GoogleOAuthProvider clientId="109721738080989898540">
//             <GoogleLogin
//                 onSuccess={handleLoginSuccess}
//             />
//             <button onClick={handleClick}>
//                 Đăng nhập bằng Google 🚀
//             </button>
//         </GoogleOAuthProvider>
//     );
// };
//
// export default GoogleAuthComponent;
