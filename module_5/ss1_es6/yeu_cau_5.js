let a = [1,2,3,4,5,6,7,8,9,10]
let checkNumber = (number) => {
    for (let i = 2; i < number ; i++) {
        if(number%i===0){
            return false
        }
    }
    return true
}
let b = a.filter(a => checkNumber(a));
console.log(b);