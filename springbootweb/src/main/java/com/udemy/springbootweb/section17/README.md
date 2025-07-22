## `A`spect `O`riented `P`rogramming

- 관점지향프로그래밍
- 공통 관심사를 `aspect`로 구현
- org.springframework.boot:spring-boot-starter-aop

### Terminology
| Term       |                                        |
|:-----------|:---------------------------------------|
| Advice     | 무엇을 할지. 수행되는 로직                        |
| Pointcut   | 언제 할지. 수행되려는 시기. 인터셉터 되는 대상이 되는 메소드 명시 |
| Aspect     | Advice + Pointcut                      |
| Weaver     | AOP 프레임워크                              |
| Join Point | 실행 인스턴스                                |

### Annotations
| Annotation        |                       |
|:------------------|:----------------------|
| `@Before`         | 메소드가 수행되기 전에 수행       |
| `@After`          | 메소드가 수행되고 나서 수행       |
| `@AfterReturning` | 메소드가 성공적으로 수행되고 나서 수행 |
| `@AfterThrowing`  | 메소드가 익셉션을 던졌을 때 수행    |
| `@Around` | 메소드 수행 전과 후에 수행 |

### Common Pointcut

- Pointcut 을 공통적으로 정의하여 언제든지 참조할 수 있다.