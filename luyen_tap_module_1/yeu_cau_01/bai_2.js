function taskOneTwo() {
    let a = prompt('Nhập kí tự vào đây để kiểm tra :')
    switch (a) {
        case 'o' :
        case 'u' :
        case 'i' :
        case 'a' :
        case 'e' :
            document.write('là kí tự nguyên âm ');
            break;
        case 'c' :
        case 'b' :
        case 'l' :
        case 'm' :
        case 'n' :
            document.write('là kí tự phụ âm');
            break;
    }

}