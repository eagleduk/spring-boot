## Lazy Initialization

- 지연 초기화
- 객체가 Spring Application이 시작할 때 초기화되는게  아니고 객체가 사용되기 전에 초기화 된다.
- `@Lazy` 어노테이션 사용.
- Spring Application이 시작될 때 에러를 발견할 수 없다. 런타임 에러 발생.
- `@Compoment`, `@Bean` 어노테이션에 사용할 수 있다.
- 기본값은 **즉시초기화**

## Scope

- `Singleton | Prototype`
- `@Scope` 어노테이션 사용.
- 객체가 한번만 생성되는지 호출때 마다 생성되는지를 결정한다.
- 기본값은 **Singleton**

## PostConstruct, PreDestroy

- 객체가 초기화 된 후, 객체가 컨테이너(Spring) 에서 삭제되기 전에 수행된다.
- `PostConstruct`에서는 의존성 주입이 완료된 후 실행되어야 하는 함수에 사용.
  - ex) 데이터베이스에서 데이터를 가져와 초기화
- `PreDestroy`에서는 보유하고 있던 리소스를 해제하는데 사용
  - ex) 데이터베이스 연결 해제
