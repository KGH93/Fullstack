import React from "react";
import Hello from "./Hello";
import Wrapper from "./Wrapper";

function App() {
  const handleClick = () => {
    alert("버튼이 클릭되었습니다.");
  };
  return (
    <Wrapper>
      <Hello name="react" color="red"/>
      <Hello color="pink"/>
      <button onClick={handleClick}>눌러보세요</button>
    </Wrapper>
  );
}

export default App;
