function taskTwoTwo() {
    let h = +prompt('nhập chiều cao ')
    for (let i = 0; i <= h; i++) {
        for (let j = 0; j <= h * 2; j++) {
            if (i + j > h && j - i < h) {
                document.write('*');
            } else {
                document.write('&nbsp&nbsp')
            }
        }
        document.write('<br/>')

    }

}