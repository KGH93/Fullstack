import React from 'react';
import Hello from './Hello';
import Wrapper from './Wrapper';

function App() {
  return (
    <Wrapper>
    <Hello name="react" color="red" isSpecial/>
    {/* isSpecial 이름만 넣어두면 isSpecial={true} 와 동일 */}
    <Hello color="pink"/>
    </Wrapper>
  );  
}

export default App;