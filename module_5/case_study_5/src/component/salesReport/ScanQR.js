import React, {useEffect, useState} from 'react';
import {Html5QrcodeScanner} from "html5-qrcode";
import ScanResult from './ScanResult';

function ScanQr() {
    const [scanResult, setScanResult] = useState(null);
    const [showScanResult, setShowScanResult] = useState(false);

    useEffect(() => {
        const scanner = new Html5QrcodeScanner('reader', {
            qrbox: {
                width: 250,
                height: 250,
            },
            fps: 5,
        });

        scanner.render(success, error);

        function success(result) {
            scanner.clear();
            setScanResult(result);
            setShowScanResult(true);
        }

        function error(err) {
            console.warn(err);
        }
    }, []);

    return (
        <>
            <p style={{marginLeft: "30%", marginRight: "30%", marginTop: "2%", minHeight: "560px"}}>
                {
                    showScanResult
                        ? <ScanResult result={scanResult}/>
                        : <div style={{minHeight: "560px", textAlign: "center", border: "none"}} id="reader"></div>
                }
            </p>
        </>
    );
}

export default ScanQr;
