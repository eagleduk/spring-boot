## `J`ava `S`erver `P`ages

- Default Path = `resource/META-INF/resources`

## RequestParam

- `jakarta.el:jakarta.el-api` 추가되어야 동작한다.
- `ModelMap`에 데이터를 저장하면 JSP에서 사용가능 하다.

## Logger

- **aplication.properties**에 `log.level.[PACKAGE]`를 선택하여 로깅하고자 하는 패키지를 선택할 수 있다.

## Request vs Model vs Session

- `Request` 는 요청을 하는 동안에만 사용 가능
- `Model`은 반환하는 페이지에서만 사용 가능
- `Session`은 언제 어디서나 사용 가능

## jstl

- jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api
- org.glassfish.web:jakarta.servlet.jsp.jstl

## bootstrap

- org.webjars:bootstrap:5.3.7

## validation

- org.springframework.boot:spring-boot-starter-validation

## JSP Fragment

## Spring boot Security

- org.springframework.boot:spring-boot-starter-security
- 자동으로 로그인페이지, 로그아웃을 제공해 준다.
- 기본 유저는 `user`, 패스워드는 로그에 나타난다.

## H2 Database

## JPA