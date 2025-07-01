import React, { useRef, useState } from 'react'

export default function InputSample() {
    // useState 변경되는 값을 관리
    const[inputs, setInputs] = useState({
        name: '',
        nickname: ''
    });

    const nameInput = useRef();
    //useRef 특정 Dom 선택

    const { name, nickname } = inputs; // 비구조화 할당을 통해 inputs에서 name과 nickname을 추출
    //inputs.name inputs.nickname 대신 name. nickname 값을 가져옴

    const onChange = (e) => {
        const { value, name } = e.target; // 우선 e.target 에서 value와 name 추출
        setInputs({
            ...inputs, // 기존 inputs 객체를 복사한뒤 (기존의 값을 유지)
            [name]: value // name 속성에 해당하는 값을 value로 설정
        });
    };
    const onReset = () => {
        setInputs({
            name: '',
            nickname: ''
        });
        nameInput.current.focus();
    }
  return (
    <div>
        <input name='name' ref={nameInput} placeholder="이름" onChange={onChange} value={name}/>
        <input name='nickname' placeholder="닉네임" onChange={onChange} value={nickname}/>
        <button onClick={onReset}>초기화</button>
        <div>
        <b>값: </b>
        {name} ({nickname})
        </div>    
    </div>
  )
}
