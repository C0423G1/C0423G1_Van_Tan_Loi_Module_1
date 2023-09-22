import React, {useEffect, useState} from 'react';
import * as BookService from "../service/BookService";
import {Link} from "react-router-dom";

function ListBook() {
    const [book, setBooks] = useState([]);

    const getBooks = async () => {
        setBooks(await BookService.getAll());
    };

    useEffect(() => {
        getBooks();
    }, []);

    return (
        <>
            <h1>BookList</h1>
            <td>
                <Link to="/create"><button className="btn btn-success">Add</button></Link>
            </td>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {book.map((books) => (
                    <tr key={books.id}>
                        <td>{books.title}</td>
                        <td>{books.quantity}</td>
                        <td>
                            <Link to={`/edit/${books.id}`}><button className="btn btn-primary">Edit</button></Link>
                        </td>
                        <td>
                            <Link to={`/delete/${books.id}`}><button className="btn btn-danger">Delete</button></Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    );
}

export default ListBook;
