import React, { useState, useRef } from 'react'
import './App.css'
import Header from './component/Header'
import TodoEditor from './component/TodoEditor'
import TodoList from './component/TodoList'

const mockTodo = [
  {
    id: 0,
    isDone: false,
    content: "React 공부하기",
    createdDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "빨래 널기",
    createdDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "노래 연습하기",
    createdDate: new Date().getTime(),
  },
];

export default function App() {
  const [todo, setTodo] = useState(mockTodo);

  const idRef = useRef(3);

  const onCreate = (content) => {
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime()
    };
    setTodo([newItem, ...todo]);
    idRef.current += 1;
  };

  // onUpdate는 targetId 라는 토글할 할 일의 id를 매개변수 변수로 받음
  const onUpdate = (targetId) =>{
    setTodo(
      todo.map((it) => // 현재 todo 배열을 순회하면서
        it.id === targetId ? {...it, isDone: !it.isDone} 
        //it.id === targetId -> 해당 isDone을 true/false로 토글
        : it
      )
    );
  };

  const onDelete = (targetId) => {
    setTodo(todo.filter((it) => it.id !== targetId));
    // targetId와 일치하지 않는 아이템만 남김
  };



  return (
    <div className='App'>
      <Header/>
      <TodoEditor onCreate={onCreate}/>
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete}/>
    </div>
  )
}
