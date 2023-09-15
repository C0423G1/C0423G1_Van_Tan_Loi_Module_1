const check = (obj)=>{
    const firstName = obj.firstName !==undefined ? obj.firstName : "Quân"
    const degree = obj.degree !==undefined ? obj.degree : "NA"
    console.log("firstName : " +firstName + " degree : " + degree);
}
const sv1={
    firstName : "John",
    gender : "male",
    degree : "Bachelor",
    english : "English"
}
const sv2 = {
    name : "John",
    gender : "male",
    degree : "Bachelor",
    english : "English"
}
check(sv1)
check(sv2)