# Assesment (Matches & Match Odds)
### Project Requirements
- JDK 17
- Maven 3.8.8
- Docker, Docker Compose (optional)


### Build & Run
##### i) Without Docker
Change data source accordingly in *application.properties*:

	spring.datasource.url=jdbc:postgresql://localhost:5432/{db_name} 
	spring.datasource.username={username}  
	spring.datasource.password={password}

-Run:

	~$ cd (project directory)
	~$ mvn clean install -DskipTests
	~$ java -jar target/assessment-0.0.1-SNAPSHOT.jar

##### ii) With Docker (using host db)

-Run:

	~$ cd (project directory)
	~$ mvn clean install -DskipTests
	~$ docker buildx build --tag assessment_app:1.0 .
    ~$ docker run --network=host assessment_app:1.0 

##### ii) With docker-compose (using docker db)

-Run:

	~$ cd (project directory)
	~$ mvn clean install -DskipTests
	~$ docker-compose up  

##### ii) With Docker (using host db)

### Swagger UI
http://localhost:8080/swagger-ui/index.html

### Postman collection
project file: *assessment.postman_collection.json*

