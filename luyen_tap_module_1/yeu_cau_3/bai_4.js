function taskThreeFour() {
    let sum = 0;
    do {
        let a = +prompt('1 (cafe) \n' +
            ' 2 (cam vắt)\n ' +
            '3(nước ép cà rốt)\n ' +
            '4(nước ép cà chua)\n ' +
            '5(nước lọc)\n' +
            ' 6(nước dừa)\n' +
            ' 7(thoát gọi món)');
        switch (a) {
            case 1:
                let b = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước cafe là : 20000VND ');
                alert('Tổng tiền cafe bạn phải thanh toán là ' + b * 20000 + 'VND');
                sum = sum + b * 20000;
                break;
            case 2:
                let c = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước cam Vắt là : 21000VND ');
                alert('Tổng tiền cam vắt bạn phải thanh toán là ' + c * 21000 + 'VND');
                sum = sum + c * 21000;
                break;
            case  3:
                let d = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước nước ép cà rốt là : 22000VND ');
                alert('Tổng tiền nước ép cà rốt bạn phải thanh toán là ' + d * 22000 + 'VND');
                sum = sum + d * 22000;
                break;
            case 4 :
                let e = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước ép cà chua là : 23000VND ');
                alert('Tổng tiền nước ép cà chua bạn phải thanh toán là ' + e * 23000 + 'VND');
                sum = sum + e * 23000;
                break;
            case 5:
                let f = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước nước lọc là : 24000VND ');
                alert('Tổng tiền nước lọc bạn phải thanh toán là ' + f * 24000 + 'VND');
                sum = sum + f * 24000;
                break;
            case 6:
                let h = +prompt('Nhập số lượng nước uống bạn muốn mua vào giá nước dừa là : 25000VND ');
                alert('Tổng tiền nước dừa bạn phải thanh toán là ' + h * 25000 + 'VND');
                sum = sum + h * 25000;
                break;
            case 7:
                let r = confirm('Số tiền tổng bạn phải trả là : ' + sum);
                if (r === true) {
                    alert('Cảm ơn bạn đã thanh toán .Chúng tôi sẽ ra món liền');
                } else {
                    alert('Cảm ơn bạn đã đến quán !');
                }
        }
    }

    while (true) ;

}