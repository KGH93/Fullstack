const express = require('express');
const cors = require('cors');
const mysql = require('mysql2');
const app = express();
const PORT = 5000;

app.use(cors());
app.use(express.json());

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '1234',       // 본인 비밀번호
  database: 'todo1_app',
});

db.connect((err) => {
  if (err) {
    console.error('❌ DB 연결 실패:', err);
    process.exit(1);
  }
  console.log('✅ DB 연결 성공!');
});

// 전체 조회
app.get('/todos', (req, res) => {
  db.query('SELECT * FROM todos ORDER BY id DESC', (err, result) => {
    if (err) return res.status(500).send(err.message);
    res.json(result);
  });
});

// 추가
app.post('/todos', (req, res) => {
  const { content } = req.body;
  const createdDate = Date.now();
  const isDone = false;
  db.query(
    'INSERT INTO todos (content, isDone, createdDate) VALUES (?, ?, ?)',
    [content, isDone, createdDate],
    (err, result) => {
      if (err) return res.status(500).send(err.message);
      res.json({ id: result.insertId, content, isDone, createdDate });
    }
  );
});

// 토글
app.put('/todos/:id', (req, res) => {
  const { id } = req.params;
  db.query('UPDATE todos SET isDone = NOT isDone WHERE id = ?', [id], (err) => {
    if (err) return res.status(500).send(err.message);
    res.sendStatus(200);
  });
});

// 삭제
app.delete('/todos/:id', (req, res) => {
  const { id } = req.params;
  db.query('DELETE FROM todos WHERE id = ?', [id], (err) => {
    if (err) return res.status(500).send(err.message);
    res.sendStatus(200);
  });
});

app.listen(PORT, () => {
  console.log(`🚀 서버 실행 중: http://localhost:${PORT}`);
});
