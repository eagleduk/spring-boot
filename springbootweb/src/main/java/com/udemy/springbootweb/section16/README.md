## Authentication

- Form Authentication
- Basic Authentication

## `C`ross-`S`ite `R`equest `F`orgery

- 세션을 사용하지 않으면 사용할 필요가 없다.
- POST, PUT, PATCH, DELETE 등 데이터 변조에 대한 요청을 수행할 때 필요하다.

## `C`ross-`O`rigin `R`esource `S`haring

- 도메인 간 허용되는 요청을 설정
- 글로벌 설정, URL 별 설정을 할 수 있다.

## User Authentication

- In Memory
- In Database

## Password Encoder

- `Encoding`: 데이터를 다른 형식으로 변환하는 것. 데이터를 압축하거나 스트리밍할 때 사용.
- `Hashing`: 데이터를 해시 문자열로 변환. 해시에서 원래 데이터 구할 수 없다. 데이터 무결성 검증시 사용. **패스워드 저장 시 사용.**
- `Encryption`: 키나 패스워드를 사용해 데이터를 인코딩하고 복호화.