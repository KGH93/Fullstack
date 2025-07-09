import React, {useState, useRef} from 'react'
import './TodoEditor.css'


export default function TodoEditor({onCreate}) {
    const [content, setContent] = useState('');
    const inputRef = useRef(); // input에 focus를 주기 위한 ref


    const onChangeContent = (e) => { 
        setContent(e.target.value); 
        //키보드로 입력하는 내용을 content에 반영
    }
    const onSubmit = () => {
        if (!content) {
            inputRef.current.focus(); // content가 비어있으면 input에 focus
            return;
        }
        onCreate(content);
        setContent(''); // 입력 후 input 비우기
    }
    const onKeyDown = (e) => {
        if (e.key === 'Enter') { // Enter 키를 누르면
            onSubmit(); // onSubmit 함수 호출
        }
    }


  return (
    <div className='TodoEditor'>
        <h4>새로운 Todo 작성하기 🖋</h4>    
        <div className='editor_wrapper'>
            <input onKeyDown={onKeyDown} ref={inputRef} value={content} onChange={onChangeContent} placeholder="새로운 Todo..." />
            <button onClick={onSubmit}>추가</button>
        </div>
    </div>
  )
}
