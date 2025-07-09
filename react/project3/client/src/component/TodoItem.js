import React from 'react'
import './TodoItem.css'

export default function TodoItem({id, content, isDone, createdDate, onUpdate, onDelete}) {
  
  const onChangeCheckbox = () => {
    onUpdate(id); // onUpdate 함수 호출, id를 매개변수로 전달
  }

  const onClickDelete = () => {
    onDelete(id); // onDelete 함수 호출, id를 매개변수로 전달
  }
  
  return (
    <div className='TodoItem'>
        <div className='checkbox_col'>
            <input type='checkbox' checked={isDone} onChange={onChangeCheckbox}/>
        </div>
        <div className='title_col'>{content}</div>
        <div className='date_col'>{new Date(createdDate).toLocaleDateString()}</div>
        <div className='btn-col'>
            <button onClick={onClickDelete}>삭제</button>
        </div>
    </div>
  )
}
