## Postgres

```shell
docker run --name section08-postgres -it --publish 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -d postgres
```