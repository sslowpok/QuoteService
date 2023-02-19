# QuotesService
## RESTful API to store quotes data for the provided frontend
### Includes
- Methods to create users, get user details by userId
- CRUD operations with quotes
- Adding votes
- Methods to get top 10  most & least voted quotes
- Method to get a random quote
- Swagger UI at `http://localhost:8080/api/v1/kameleoon/swagger-ui/index.html`

### Stack
- Spring boot
- Spring Data JPA
- Spring Web
- Lombok
- Liquibase
- H2 in-memory database
- Swagger UI: `http://localhost:8080/api/v1/kameleoon/swagger-ui/index.html`

### Setup
- `docker-compose up`
- `docker pull sslowpok/quote-service.jar && docker run -d -p 8080:8080 sslowpok/quote-service.jar`