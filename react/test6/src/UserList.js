import React from 'react'

function User({user, onRemove, onToggle}) {
    return(
        <div>
            <b
            style={{cursor: 'pointer',
                color: user.active ? 'green' : 'black',
            }}
            onClick={() => onToggle(user.id)}
            >{user.username}</b> <span>({user.email})</span>
            <button onClick={() => onRemove(user.id)}>삭제</button>
        </div>
        //user하나의 정보를 출력
        //삭제버튼을 누르면 onRemove함수 호출
        // user.id를 인자로 전달해서 어떤 사용자를 삭제할지 부모에게 알려줌
    );
}

export default function UserList({users, onRemove, onToggle}) {

    return (
    <div>
        {users.map(user =>(
          <User user={user} key={user.id} onRemove={onRemove} onToggle={onToggle}/>
        ))}
    </div>
  )
}
