function taskOneOne() {
    let tienLuong = +prompt('Tiền lương nhân viên :');
    let tienThue;
    if (tienLuong < 7000000) {
        tienThue = tienLuong * 0.05;
    } else if (tienLuong < 15000000) {
        tienThue = tienLuong * 0.1;
    } else {
        tienThue = tienLuong * 0.2;
    }
    document.getElementById("one").innerHTML= 'Số tiền bạn nhận được sau khi thu thuế là :' + (tienLuong - tienThue) + ' VND'

}