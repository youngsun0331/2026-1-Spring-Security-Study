## 인증과 인가
### 인증 (Authentication)
+ 로그인
+ ex) 학생증 발급

### 인가 (Authorization)
+ 리소스 접근 제어
+ ex) 학교 도서관 접근, 교수님 연구실...은 안될듯

## Spring Security
+ Spring 환경 인증 / 인가 담당 하는 프레임 워크
    + 프레임 워크 : 툴
    + 라이브러리 : 도서관

## 서블릿 필터(Servlet Filter)
+ 요청/응답을 가로채서 전처리/후처리
+ ex) 요청 로깅 , 인코딩 설정

## Spring Security의 원리
+ 보안을 담당하는 서블릿 필터를 끼워넣자
+ 이름은 SercurityFilterChain으로 하자





>Q1. 근데 이거 AOP랑 똑같은거 아님?


>A1. 동작하는 위치/목적이다름

>Q2. 서블릿이 뭐더라

>Q3. 라이브러리 vs 프레임워크


