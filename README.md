# server-impl
스프링부트 서버 시험문제

---

````markdown
# 📝 MyBatis 게시판 프로젝트

Spring Boot + MyBatis 기반의 간단한 게시판 웹 서비스입니다.  
회원가입, 로그인, 게시글 CRUD, 페이징, 예외 처리 등 **실무형 기능**이 집약된 구조로 설계되어 있습니다.

---

## 🚀 기술 스택

| 구분       | 내용                         |
|------------|------------------------------|
| Backend    | Spring Boot 3.x, Spring MVC  |
| ORM        | MyBatis + Mapper XML         |
| DB         | H2 (개발용) / MySQL (운영 가능) |
| Build Tool | Gradle                       |
| View       | Thymeleaf / REST (선택형)    |

---

## ✨ 주요 기능

### ✅ 회원 기능
- 회원가입 / 로그인
- 비밀번호 암호화 (BCrypt)
- 중복 체크
- 프로필 수정

### ✅ 게시판 기능
- 게시글 작성 / 조회 / 수정 / 삭제
- 페이징 처리 (`PageHelper` or Custom)
- 작성자 인증
- 작성일자/조회수 정렬

### ✅ 예외 및 인증
- 전역 예외 처리 (`@ControllerAdvice`)
- 인증 체크 (Interceptor or Spring Security 확장 가능)
- 예외별 상세 응답 처리

---

## 🛠️ 실행 방법

### 1. 프로젝트 클론

```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
````

### 2. 설정

`src/main/resources/application.yml` 또는 `.properties`에서 DB 설정 확인:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
```

### 3. 실행

```bash
./gradlew bootRun
```

혹은 IntelliJ/Eclipse에서 `ServerApplication.java` 실행

### 4. 접속

```
http://localhost:8080
```

---

## 🧪 더미 데이터

* User 계정 4개 자동 생성 (예: `user1`, `user2`, ...)
* 각 계정당 게시글 3개 생성 (총 12개)
* 실행 시 초기화 (`data.sql` 또는 `CommandLineRunner` 기반)

---

## 🧩 디렉토리 구조

```
src
├── main
│   ├── java/com/example/server
│   │   ├── controller        # 컨트롤러
│   │   ├── service           # 서비스 계층
│   │   ├── mapper            # MyBatis Mapper 인터페이스
│   │   ├── dto               # DTO
│   │   ├── entity            # JPA/DB Entity
│   │   └── ServerApplication.java
│   └── resources
│       ├── mapper/MemberMapper.xml  # Mapper XML
│       └── application.yml
```

## 📜 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다.

---
