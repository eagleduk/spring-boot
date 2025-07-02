## DispatcherServlet

- DispatcherServletAutoConfiguration.class

## ResponseBody, JacksonHttpMessageConverters

## Error Mapping

- ErrorMvcAutoConfiguration.class

## Response Status Code

- 200: 요청 성공
- 201: 생성 성공
- 204: 요청 성공, 응답 본문 없음
- 401: 요청에 올바른 정보 제공하지 않음
- 400: 나쁜 요청. 검증 에러
- 404: 요청 리소스 없음
- 500: 서버 에러

## ResponseEntity

- created: `URI`를 인자로 받는다. Header(`Location`) 에 인자로 받은 값을 전달할 수 있다.
- accepted
- noContent
- badRequest
- notFound

## Exception Handler

## Swagger

- org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9
- /swagger-ui.html

## API Versioning

- URI Version(Twitter)
- Parameter Version(Amazon)
- Custom Header(MicroSoft)
- Media Type(GitHub)

## `H`ypermedia `A`s `T`he `E`ngine `O`f `A`pplication `S`tate

- `HATEOAS`
- API 요청 이후 후속 작업을 위한 API Endpoint 를 함께 반환하는 것
- 원하는 만큼의 후속 작업을 위한 Endpoint 를 반환할 수 있다.