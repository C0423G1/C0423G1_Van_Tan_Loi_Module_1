import React from 'react';
import useIncrement from "./component/UseIncrement";

function Counter1() {
    const [count, increase] = useIncrement(0, 1);

    return (
        <div>
            <h2>Counter 1</h2>
            <p>Count: {count}</p>
            <button onClick={increase}>Increase</button>
        </div>
    );
}

function Counter2() {
    const [count, increase] = useIncrement(0, 2);

    return (
        <div>
            <h2>Counter 2</h2>
            <p>Count: {count}</p>
            <button onClick={increase}>Increase</button>
        </div>
    );
}

function App() {
    return (
        <div>
            <Counter1/>
            <Counter2/>
        </div>
    );
}

export default App;
