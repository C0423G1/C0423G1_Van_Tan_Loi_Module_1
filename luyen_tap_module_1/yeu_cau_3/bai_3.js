function taskThreeThree() {
    let a = prompt('Nhập phần tử của số thập phân lần lượt vào đây cách nhau bằng dấu ,');
    let b = prompt('Nhập phần mẫu của số thập phân lần lượt vào đây cách nhau bằng dấu ,');
    let c = a.split(',');
    let d = b.split(',');
    let maxFraction = (c[0] / d[0]);
    let index = 0;
    for (let i = 1; i < c.length; i++) {
        if (maxFraction < (c[i] / d[i])) {
            maxFraction = (c[i] / d[i]);
            index = i;
        }
    }
    document.write('Phân số lớn nhất là ' + maxFraction + ' có chỉ số là  : ' + index)
}