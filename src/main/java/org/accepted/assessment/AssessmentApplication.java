package org.accepted.assessment;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args);
    }

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("User");
        myContact.setEmail("your.email@gmail.com");

        Info information = new Info()
                .title("Match/Odds REST APIs")
                .version("1.0")
                .description("Endpoints to manage Matches and Match Odds.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }


}
