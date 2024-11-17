# Assesment (Matches & Match Odds)
### Project Requirements

- JDK 17 (not required )
- Maven 3.8.8
- Docker, Docker Compose (optional)


### Build & Run
##### 
Change data source accordingly in *application.properties*:

	spring.datasource.url=jdbc:postgresql://localhost:5432/{db_name} 
	spring.datasource.username={username}  
	spring.datasource.password={password}

- ###### Run 1) Without Docker:

	    ~$ cd (project directory)
	    ~$ mvn clean install -DskipTests
	    ~$ java -jar target/assessment-0.0.1-SNAPSHOT.jar


- ###### Run 2) With Docker (using host db):

	    ~$ cd (project directory)
	    ~$ mvn clean install -DskipTests
	    ~$ docker buildx build --tag assessment_app:1.0 .
        ~$ docker run --network=host assessment_app:1.0 

- ##### Run 3) With docker-compose (using containerized db)

        ~$ cd (project directory)
	    ~$ mvn clean install -DskipTests
	    ~$ docker-compose up  

### Swagger UI
http://localhost:8080/swagger-ui/index.html

### Postman collection
project file: *assessment.postman_collection.json*

