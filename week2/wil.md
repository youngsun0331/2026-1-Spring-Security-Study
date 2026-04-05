
> 세션 방식 인증에 대한 내용을 요약해서 정리해주세요.

> 왜 MemberRole 의 value 로 ROLE_ 접두사를 붙이는지 알아보고, wil.md 에 해당 이유를 포함해주세요.

## 기본 SecurityFilterChain

+ 개발자가 설정하지 않으면 DefaultSecurityFilterChain이 빈으로 등록된다
-> 모든 시큐리티 설정은 SecurityFilterChain 빈을 등록하는 것 부터 시작함

## Session 기반 인증
+ 서버가 사용자의 정보를 저장하고 있음
-> Stateful

### @Scope("prototype")
+ prototype ?
    + 매번 주입할 때 마다 새로운 객체를 만들어 주입해 주는 객체
    + 싱글톤 : 어디서 주입받든 동일한 인스턴스를 사용하는 객체
+ 여러 SecurityFilterChain 간에 HttpSecurity 상태가 공유되면 안됨


## MemberRole 의 valu 로 ROLE 접두사를 붙이는 이유
스프링 시큐리티는 내부적으로 권한과 역할을 구분하여 처리한다.

### 역할
ROLE_로 시작하는 권한

### Authority(권한)
특정 리소스나 기능에 대한 접근 권한

### 붙이는 이유
1. 역할과 권한을 구분하기 위해서 -> 기존 시스템과 호환성을 유지한다
2. `ROLE_USER` 와 `USER` 같은 표현이 혼동될 수 있기때문에 구분하기 위해서

# 로그인 플로우

1. 로그인 요청을 authToken 으로 변환한다.
2. AuthenticationManager 로 인증한다
3. 현재 인증 정보를 저장한다
    -> 시큐리티컨텍스트가 담당
4. 세션을 생성하고 JSESSIONID를 발급한다
5. 세션에 인증 정보를 저장한다