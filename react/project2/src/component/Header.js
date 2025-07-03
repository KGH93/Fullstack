import "./Header.css";  // Header.css 파일을 import

const Header = () => {  // Header 익명함수로
  return (
    <div className="Header">
        <h3>오늘은 📅</h3>
        <h1>{new Date().toDateString()}</h1>
    </div>
  )
}
export default Header;  // Header 컴포넌트 export