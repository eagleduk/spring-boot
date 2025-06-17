## Lazy Initialization

- 지연 초기화
- `Bean` 객체가 Spring Application이 시작할 때 초기화되는게  아니고 객체가 사용되기 전에 초기화 된다.
- `@Lazy` 어노테이션 사용.
- Spring Application이 시작될 때 에러를 발견할 수 없다. 런타임 에러 발생.
- `@Compoment`, `@Bean` 어노테이션에 사용할 수 있다.
- 기본값은 **즉시초기화**