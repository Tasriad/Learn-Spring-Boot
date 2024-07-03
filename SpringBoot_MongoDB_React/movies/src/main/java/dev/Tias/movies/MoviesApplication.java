package dev.Tias.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//MoviesApplication class is the entry point of the application.
//It is responsible for starting the Spring Boot application.
//It is annotated with @SpringBootApplication, which is a convenience annotation that adds all of the following:

// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the package, allowing it to find the controllers.
// It is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*") // Enable CORS globally
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);

	}

}
