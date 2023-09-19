import React, {useState} from 'react';

function CongViec() {
    const [list, setList] = useState([]);
    const [item, setItem] = useState("");
    const handleChange = (event) => {
        setItem(event.target.value);
    }
    const handAddItem = () => {
        if (item !== "") {
            setList(prevList => [...prevList, item]);
            setItem("");
        }
    }
    return (
        <>
            <h1>Todo List</h1>
            <input
                type="text"
                value={item}
                onChange={handleChange}
            />
            <button onClick={handAddItem}>Add</button>
            <ul>
                {list.map((todo, index) => (
                    <li key={index}>{todo}</li>
                ))}
            </ul>
        </>
    );
}

export default CongViec;
