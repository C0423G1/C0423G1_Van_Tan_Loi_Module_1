import {useEffect, useState} from "react";
import axios from "axios";
import * as studentService from "../../services/StudentService"

export function StudentList() {
    const [students, setStudents] = useState([])
    const [name, setName] = useState("");
    useEffect(() => {
        getStudents();
    }, []);

    useEffect(() => {
        searchName();
    }, [name]);

    const searchName = async () =>{
        setStudents(await studentService.getAllByName(name));
    }

    const getStudents = async () => {
        setStudents(await studentService.getAll());
    };
    return (
        <>
            <h1>Student List</h1>
            <input type="text" onChange={(event) => setName(event.target.value)}/>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Language</th>
                </tr>
                </thead>
                <tbody>
                {
                    students.map((student) => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>{student.gender == 1 ? 'Male' : 'Female'}</td>
                            <td>
                                {
                                    student.languages.map((language, index) => (
                                        <span key={index}>{language + ', '}</span>
                                    ))
                                }
                            </td>

                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
}
