import logo from './logo.svg';
import './App.css';
import {TodoList} from "./components/todo/TodoList";
import React from "react";
import CreateTodo from "./components/todo/CreateTodo";

function App() {
    return (
        <>
            <CreateTodo/>
            <TodoList/>
        </>
    );
}

export default App;
