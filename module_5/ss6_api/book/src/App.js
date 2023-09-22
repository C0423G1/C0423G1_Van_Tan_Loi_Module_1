import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import ListBook from "./components/book/ListBook";
import React from "react";
import CreateBook from "./components/book/CreateBook";
import EditBook from "./components/book/EditBook";
import DeleteBook from "./components/book/DeleteBook";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/">
                    <Route index element={<ListBook/>}/>
                    <Route path="create" element={<CreateBook/>}/>
                    <Route path="edit/:id" element={<EditBook/>}/>
                    <Route path="delete/:id" element={<DeleteBook/>}/>
                </Route>
            </Routes>
        </Router>
    );
}

export default App;
