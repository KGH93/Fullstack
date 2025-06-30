import React from 'react';

//구조분해할당
//isSpecial은 true일 때 * 표시 아님 null
function Hello({color, name = '이름없음', isSpecial}) {
  return <div style={{color:color}}>
    {isSpecial ? <b>*</b> : null}
    안녕하세요 {name}
    </div>
}

export default Hello;