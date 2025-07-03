import React from 'react'
import './TodoList.css'
import TodoItem from './TodoItem'

export default function TodoList({todo}) {
  return (
    <div className='TodoList'>
        <h4>Todo List 📌</h4>
        <input className="searchbar" placeholder="검색어를 입력하세요"/>
        <div className="list_wrapper">
            {todo.map((todo)=>(
                <TodoItem {...todo} key={todo.id}/>
            ))}
        </div>
    </div>
  )
}
