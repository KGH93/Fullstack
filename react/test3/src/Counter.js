import React, { useState } from 'react';


export default function Counter() {

    const[number, setNumber] = useState(0);
    // useState(0) 0은 초기값
    // useState는 배열을 반환한다. 첫번째 요소는 현재 상태값, 두번째 요소는 상태를 변경하는 Setter 함수
    const onIncrease = () => {
        // setNumber(number+1);
        setNumber(prevNumber => prevNumber + 1);
        // prevNumber는 이전 상태값을 의미한다.
    };
    const onDecrease = () => {
        // setNumber(number-1);
        setNumber(prevNumber => prevNumber - 1);
    };

    return (
    <div>
        <h1>{number}</h1>
        <button onClick={onIncrease}>+1</button>
        <button onClick={onDecrease}>-1</button>
    </div>
    )
}
