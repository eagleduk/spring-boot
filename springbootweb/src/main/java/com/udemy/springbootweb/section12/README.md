## Axios

## Session Policy

- SessionCreationPolicy.ALWAYS
  
    - 항상 새로운 Session 생성

- SessionCreationPolicy.NEVER
    - 새로운 Session 생성 안함

- SessionCreationPolicy.IF_REQUIRED(Default)
    
    - 필요한 경우에만 세션을 생성
    - 인증이 필요한 자원에 접근할 때 세션을 생성

- SessionCreationPolicy.STATELESS
  
    - 세션을 생성하거나 사용하지 않음
    - 인증 필터는 인증 완료 후 SecurityContext를 세션에 저장하지 않으며 JWT 와 같이 세션을 사용하지 않는 방식으로 인증을 관리할 때 유용할 수 있음

## JWT

- org.springframework.boot:spring-boot-starter-oauth2-authorization-server
- org.springframework.boot:spring-boot-configuration-processor