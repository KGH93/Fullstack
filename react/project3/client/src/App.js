import { useReducer, useEffect } from "react";
import "./App.css";
import Header from "./component/Header";
import TodoEditor from "./component/TodoEditor";
import TodoList from "./component/TodoList";

// 상태 변경 로직
function reducer(state, action) {
  switch (action.type) {
    case "INIT":
      return action.data;
    case "CREATE":
      return [action.newItem, ...state];
    case "UPDATE":
      return state.map((it) =>
        it.id === action.targetId ? { ...it, isDone: !it.isDone } : it
      );
    case "DELETE":
      return state.filter((it) => it.id !== action.targetId);
    default:
      return state;
  }
}

function App() {
  const [todo, dispatch] = useReducer(reducer, []);

  // ✅ DB에서 초기 데이터 불러오기
  useEffect(() => {
    fetch("http://localhost:5000/todos")
      .then((res) => res.json())
      .then((data) => {
        dispatch({ type: "INIT", data });
      })
      .catch((err) => console.error("데이터 불러오기 실패:", err));
  }, []);

  // ✅ CREATE
  const onCreate = async (content) => {
    try {
      const res = await fetch("http://localhost:5000/todos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ content }),
      });
      const newItem = await res.json();
      dispatch({ type: "CREATE", newItem });
    } catch (err) {
      console.error("추가 실패:", err);
    }
  };

  // ✅ UPDATE (완료 토글)
  const onUpdate = async (targetId) => {
    try {
      await fetch(`http://localhost:5000/todos/${targetId}`, {
        method: "PUT",
      });
      dispatch({ type: "UPDATE", targetId });
    } catch (err) {
      console.error("업데이트 실패:", err);
    }
  };

  // ✅ DELETE
  const onDelete = async (targetId) => {
    try {
      await fetch(`http://localhost:5000/todos/${targetId}`, {
        method: "DELETE",
      });
      dispatch({ type: "DELETE", targetId });
    } catch (err) {
      console.error("삭제 실패:", err);
    }
  };

  return (
    <div className="App">
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
