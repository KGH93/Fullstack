import React, {useState} from 'react'

export default function InputSample() {
    const [text, setText] = useState('');

    const onChange = (e) =>{
        setText(e.target.value);
    }  //이렇게 하면 사용자가 input 입력할 때마다 text 상태가 최신값으로 업데이트 된다. 
    // e는 onChange 이벤트 객체
    // e.target은 이벤트가 발생한 html 요소 -> <input> 태그
    // e.target.value는 <input> 요소의 현재 값(value) -> 사용자가 입력한 값
    const onReset = () => {
        setText('');
    }
  return (
    <div>
        <input onChange={onChange} value={text}/>
        {/* onChange={onChange} 사용자가 입력하면 text를 즉시 바꿔줌 */}
        {/* value={text} -> input 값은 항상 text 상태와 동기화 */}
        <button onClick={onReset}>초기화</button>
        <div>
            <b>값:{text} </b>
        </div>
    </div>
  )
}
