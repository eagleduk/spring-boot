## H2 Database

- 메모리에 저장되는 Test Database
- `/h2-console` 으로 접속
- `spring.datasource.url` 값으로 *URL*을 설정한다.
- `resources/schema.sql` 에서 서버 기동 시 실행되는 SQL QUERY를 작성할 수 있다.

## Spring Jdbc

- 가장 기본적인 SQL Query 를 사용한다.
- 많은 코드 작성이 필요하다.

## Spring JPA

- SQL Query 를 사용하지 않는다.
- `Spring Jdbc` 보다 작은 코드 작성

## Spring Data JPA

- Spring JPA 보다 간결하다.
- `EntityManager` 도 사용하지 않는다.
- `JpaRepository` 를 상속받는 **interface**로 구현

> [!NOTE]
> 
> Hibernate는 JPA의 구현체.
> 
> JPA를 사용하기 위해서 반드시 Hibernate**만**을 사용할 필요가 없다