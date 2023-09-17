const check = ({firstName="Quân",degree= 'NA'}) => {
    console.log("firstName : " + firstName );
    console.log("degree     : " + degree);
    console.log("--------------------------");
}

const sv1 = {
    firstName: "John",
    gender: "male",
    degree: "Bachelor",
    english: "English"
}

const sv2 = {
    name: "John",
    gender: "male",
    degree: "Bachelor",
    english: "English"
}

check(sv1)
check(sv2)