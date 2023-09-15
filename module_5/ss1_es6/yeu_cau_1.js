let courses = [
    {
        id: 1,
        title: "ReactJS Tutorial",
        rating: 4.2,
    },
    {
        id: 2,
        title: "Angular Tutorial",
        rating: 2.5,
    },
    {
        id: 3,
        title: "VueJS Tutorial",
        rating: 3.8,
    },
    {
        id: 4,
        title: "Java Tutorial",
        rating: 4,
    },
    {
        id: 5,
        title: "JavaScript Tutorial",
        rating: 3.5,
    },
];
let a = courses.filter(courses => courses.rating >=4);
a.forEach(a =>{
    console.log("ID :" + a.id);
    console.log("title :" + a.title);
    console.log("rating :" + a.rating);
    console.log("---------------------")
})
