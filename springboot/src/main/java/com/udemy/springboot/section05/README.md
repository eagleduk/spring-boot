## Deploying

1. Profile
    - `application.properties`를 나누어 상황에 맞는 환경을 설정한다.

2. ConfigurationProperties
    - `application.properties`의 입력 값을 `@ConfigurationProperties`가 설정된 Bean(Component)에 저장한다.

3. Actuator
    - 서버의 metrix 정보를 알 수 있다.

> [!NOTE]
> 
> @SpringBootApplication = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
> 