import express from 'express';
import { createServer } from 'node:http';
import { fileURLToPath } from 'node:url';
import { dirname, join } from 'node:path';
import { Server } from 'socket.io';

const app = express();
const server = createServer(app);
const io = new Server(server);

const __dirname = dirname(fileURLToPath(import.meta.url));

app.get('/', (req, res) => {
  res.sendFile(join(__dirname, 'index.html'));
});

// socket 연결되어 있는 모든 곳에 전송
io.on('connection', (socket) => {
  socket.on('chat message', (msg) => {
    console.log('emit : ', msg);
    io.emit('chat message', msg);
  });
});

// 수신 된 메시지 출력
io.on('connection', (socket) => {
  socket.on('chat message', (msg) => {
    /**
     * client ip address는 handshake 객체로 접근
     * handshake는 server <-> client 연결되는 작업을 의미
     */
    const ipAddress = socket.handshake.address;
  
    console.log('client ip : ', ipAddress);
    console.log('chat message: ' + msg);
  });
});



server.listen(3000, () => {
  console.log('server running at http://localhost:3000');
});