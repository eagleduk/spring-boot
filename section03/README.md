## Auto Wiring

- Spring 에서 자동으로 Bean 을 주입하는 기능.
- `@Component` 어노테이션이 추가된 클래스를 `@ComponentScan`으로 찾는다. 이때, 찾을 위치(패키지)를 명시해 주어야 한다.
- 다중 `@Component` 어노테이션이 있을 경우, `@Qualifier`, `@Primary` 순으로 우선순위를 가져간다.
- `@Qualifier` 가 지정이 되어 있지 않은 클래스를 우선순위로 할당 하고 싶을 때, `@Qualifier` 값을 클래스 명으로 입력(첫 글자는 소문자) 하면 우선순위를 가진다.