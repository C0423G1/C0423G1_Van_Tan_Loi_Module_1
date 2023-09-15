const person = {
    firstName: "John",
    lastName: "Doe",
    age: 30,
    gender: "Male",
    occupation: "developer",
    nationality: "American",
    city: "New York",
    hobbies: ["reading", "traveling", "photography"],
    languages: ["English", "Spanish"],
    education: {
        degree: "Bachelor",
        major: "Computer Science",
        university: "Harvard University"
    }
};

const student = {
    firstName: person.firstName,
    gender: person.gender,
    degree: person.education.degree,
    english: person.languages[0],
};

console.log(student)