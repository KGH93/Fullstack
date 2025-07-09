import React, { useState } from 'react'
import './TodoList.css'
import TodoItem from './TodoItem'

export default function TodoList({todo, onUpdate, onDelete}) {
  const [search, setSearch] = useState('');
  const onChageSearch = (e) => {
    setSearch(e.target.value);
  }
  const getSearchResult = () => {
  //빈문자이면 그대로 todo, 아니면 일치하는 아이템만 필ㄹ터링해 반환
    return search === "" ? todo :
    todo.filter((it)=>
      it.content.toLowerCase().includes(search.toLowerCase())
      // 대소문자 구분 없이 검색
    );
  }

  return (
    <div className='TodoList'>
        <h4>Todo List 📌</h4>
        <input className="searchbar" onChange={onChageSearch} placeholder="검색어를 입력하세요"/>
        <div className="list_wrapper">
            {getSearchResult().map((todo)=>(
                <TodoItem {...todo} key={todo.id} onUpdate={onUpdate} onDelete={onDelete}/>
            ))}
        </div>
    </div>
  )
}
