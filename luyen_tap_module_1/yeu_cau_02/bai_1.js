function taskTwoOne() {
    let h = +prompt('Nhập chiều cao vào đây ')
    for (let i = 0; i <= h; i++) {
        for (let j = 0; j <= i; j++) {
            if (i === j || i === h || j === 0) {
                document.write('*');
            } else {
                document.write('&nbsp&nbsp');
            }

        }
        document.write('<br/>')
    }
}