## Tightly Coupled

- 강한 결합
- `class` 사용

## Loose Coupling

- 느슨한 결합
- `interface` 사용

## Spring Context

- `Spring` 사용한 App 실행
- `Bean` 사용

> [!NOTE]
> ### record
> 1. Data 목적의 Class 임을 명시
> 2. 생성자 및 Getter,Setter를 자동으로 생성해 준다.

## Java Object

1. Java Bean

   - 매개변수가 없는 생성자
   - Setter, Getter
   - Serializable 참조

2. POJO(Plain Old Java Object)
    
    - 생성자가 없다
    - 모든 객체는 POJO가 된다

3. Spring Bean

    - IOC Container(Spring Container) 가 관리한다.

> [!NOTE]
> ### Try - with - resources
> try - catch - finally 에서의 자원 반환 누락을 더욱 효과적으로 방지할 수 있다.
