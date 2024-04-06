## Configuration

### application-dev.properties

```properties
# Development environment properties
server.port=8081
spring.datasource.url=jdbc:postgresql://localhost:5432/ms-user
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.rabbitmq.addresses=amqps://your_rabbitmq_credentials
broker.queue.email.name=default.email
