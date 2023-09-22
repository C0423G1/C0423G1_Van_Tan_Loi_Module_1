import React, {useEffect, useState} from "react";
import * as TodoService from "../service/TodoService";

export function TodoList() {
    const [todos, setTodos] = useState([]);

    const getTodos = async () => {
        setTodos(await TodoService.getAll());
    };

    useEffect(() => {
        getTodos();
    }, []);
    return (
        <>
            <table className="table mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>IDUser</th>
                    <th>Title</th>
                    <th>Completed</th>
                </tr>
                </thead>
                <tbody>
                {todos.map((todo) => (
                    <tr key={todo.id}>
                        <td>{todo.id}</td>
                        <td>{todo.userId}</td>
                        <td>{todo.title}</td>
                        <td>{todo.completed ? "Yes" : "No"}</td>
                    </tr>
                ))}
                </tbody>
            </table>

        </>
    );
}
