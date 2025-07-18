create database server;

use server;

CREATE TABLE member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    writer_username VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (writer_username) REFERENCES member(username)
);

INSERT INTO member (username, password, name) VALUES
('alice', 'pass1', 'Alice'),
('bob456', 'pass2', 'Bob'),
('charlie789', 'pass3', 'Charlie'),
('dana321', 'pass4', 'Dana');

select * from member;

INSERT INTO post (title, content, writer_username, created_at) VALUES
('첫 번째 글', '내용입니다 1', 'charlie789', '2025-07-15 10:15:00'),
('여행 후기', '부산 다녀왔어요', 'alice', '2025-07-16 09:00:00'),
('추천 도서', '이 책 읽어보세요', 'bob456', '2025-07-14 14:30:00'),
('자기소개', '안녕하세요 Charlie입니다', 'charlie789', '2025-07-17 11:45:00'),
('개발자 팁', 'Java 꿀팁 공유합니다', 'bob456', '2025-07-13 16:10:00'),
('일기', '오늘도 화창한 날씨', 'dana321', '2025-07-18 08:20:00'),
('공부법 공유', '이렇게 하면 효율 UP', 'alice', '2025-07-13 20:00:00'),
('Dana의 첫 글', '첫 글 올려봅니다', 'dana321', '2025-07-15 17:50:00'),
('테스트 글입니다', '테스트용 게시물', 'charlie789', '2025-07-14 12:00:00'),
('Dana 팁 공유', '알아두면 쓸모있는 정보', 'dana321', '2025-07-16 13:30:00'),
('Bob 일상', '요즘 덥네요', 'bob456', '2025-07-17 10:00:00'),
('Alice의 후기', '카페 리뷰', 'alice', '2025-07-18 09:10:00');

select * from post;