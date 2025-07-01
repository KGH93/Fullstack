import React, { useRef } from 'react'
import UserList from './UserList';

export default function App() {
  const users = [
    {
      id: 1,
      username: 'velopert',
      email: 'public.velopert@gmail.com'
    },
    {
      id: 2,
      username: 'tester',
      email: 'tester@example.com'
    },
    {
      id: 3,
      username: 'liz',
      email: 'liz@example.com'
    }
  ];

  const nextId = useRef(4);
  const onCreate = () => {
    // 구현
    nextId.current += 1;
  }
  return (
    <div>
      <UserList users={users}/>
    </div>
  )
}