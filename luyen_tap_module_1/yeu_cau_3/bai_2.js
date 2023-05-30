function taskThreeTwo() {
    let a = prompt('các số nguyên ');
    let b = prompt('các số nguyên ');
    let c = a.split(',');
    let d = b.split(',');
    for (let i = 0; i < c.length; i++) {
        let flag = true;
        for (let j = 0; j < d.length; j++) {
            if (c[i] === d[j]) {
                flag = false;
                d.splice(j, 1);
                c.splice(i, 1);
                j--;
            }
        }
        if (flag === false) {
            i--;
        }

    }
    let q = c.concat(d)
    document.write(q.join(','))
}