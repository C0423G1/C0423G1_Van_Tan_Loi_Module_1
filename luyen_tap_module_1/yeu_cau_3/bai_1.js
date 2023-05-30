function taskThreeOne() {
    let a = prompt('nhập cái số nguyên vào đây vui lòng cách nhau bằng dấu (space)');
    let b = a.split(' ');
    alert(b)
    let c = [];
    let sum = 0;
    for (let i = 0; i < b.length; i++) {
        sum = sum + parseInt(b[i]);
        c.push(sum);
    }
    document.write(c)
}