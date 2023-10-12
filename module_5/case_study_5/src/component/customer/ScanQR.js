import React, {useState} from 'react';
import {QrReader} from 'react-qr-reader';

const QRScanner = () => {
    const [result, setResult] = useState(null);

    const handleScan = (data) => {
        if (data) {
            setResult(data);
        }
    };

    const handleError = (error) => {
        console.error('Lỗi khi quét mã QR:', error);
    };

    return (
        <div>
            <QrReader
                delay={300}
                onError={handleError}
                onScan={handleScan}
                style={{width: '50%', maxWidth: '50%', margin: '0 auto'}}
            />
            {result && (
                <div style={{marginTop: '20px', fontSize: '18px'}}>
                    <p>Kết quả quét:</p>
                    <p>{result}</p>
                </div>
            )}
        </div>
    );
}

export default QRScanner;
