# FIM API

FIM API is Restful CRUD API which Assist FIM application with all the information using Spring Boot, H2 Database.

## Tech Stack

1. Java - 1.8.x

2. Maven - 3.x.x

3. Spring-Boot

4. H2 in-memory database

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/Mansi-Jain/WiT-Hackathon-2020-API.git
```

**2. Set up  H2 in-memory database**

H2 database has an embedded GUI console for browsing the contents of a database and running SQL queries. By default, the H2 console is not enabled in Spring. So to enable it, we need to add the following property to application.properties:

+ Open `src/main/resources/application.properties` .

+ Paste the properties to your `application.properties` . 

```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2
```

**3. Create sql file for performing DDL Operation in H2 Database**

+ open `src/main/resources/`.

+ Create `src/main/resources/schema.sql`.

+ Add  following DDL Commands in `schema.sql`.

```bash
DROP TABLE IF EXISTS MEMBER_INFORMATION;
  
CREATE TABLE MEMBER_INFORMATION (
  unique_id VARCHAR(250) PRIMARY KEY,
  password VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  contact_number VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  number_of_dependants INT NOT NULL)
;

DROP TABLE IF EXISTS ORDER_INFORMATION;

CREATE TABLE ORDER_INFORMATION (
  order_id INT PRIMARY KEY,
  unique_id VARCHAR(250) NOT NULL,
  order_placed_date DATE NOT NULL,
  created_by VARCHAR(250) NOT NULL,
  created_at DATE NOT NULL,
  delivery_date DATE NOT NULL,
  packets_required INT NOT NULL
);


```

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/springApi-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    POST /api/member/add
    
    POST /api/login
    
    POST /api/order/add
    
    GET /api/notes/{uniqueId}

You can test them using postman or any other rest client.



