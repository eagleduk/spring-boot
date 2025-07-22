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

