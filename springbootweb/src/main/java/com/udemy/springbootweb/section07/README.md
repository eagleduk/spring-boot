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