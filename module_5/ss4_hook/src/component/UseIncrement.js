import { useState } from 'react';

function useIncrement(initial, addAmount) {
    const [count, setCount] = useState(initial);

    function increase() {
        setCount(count + addAmount);
    }

    return [count, increase];
}

export default useIncrement;
