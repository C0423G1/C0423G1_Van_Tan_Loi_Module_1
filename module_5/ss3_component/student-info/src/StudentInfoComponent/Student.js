import React, {Component} from 'react';

class Student extends Component {
    constructor(props) {
        super(props);
        this.state={
            students : [
                {id:1,Name : "Nguyễn Văn A",Age:30,Address: " Hà Nội"}
            ]
        }
    }
    render() {
        return (
            <>
                <table>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Age</td>
                        <td>Address</td>
                    </tr>
                    {this.state.students.map(student =>(
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.Name}</td>
                            <td>{student.Age}</td>
                            <td>{student.Address}</td>
                        </tr>
                    ))}
                </table>
            </>
        );
    }
}

export default Student;