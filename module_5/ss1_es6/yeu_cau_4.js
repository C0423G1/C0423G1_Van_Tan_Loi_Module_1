let checkNumber = (number) => {
    for (let i = 2; i < number ; i++) {
        if(number%i===0){
            return "Không phải là số nguyên số"
        }
    }
    return "Là Số Nguyên tố"
}
console.log(checkNumber(4))