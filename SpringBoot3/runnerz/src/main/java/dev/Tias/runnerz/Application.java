package dev.Tias.runnerz;

import dev.Tias.runnerz.run.Location;
import dev.Tias.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// TIPS-----------> Create all classes inside the dev package otherwise you won't get access

@SpringBootApplication
public class Application {

	// Log messages to the console
		private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		log.info("Application started successfully!");
	}
// 	// Create a Run object and log it to the console
//
//	@Bean
//	CommandLineRunner runner(){
//		return args -> {
//			Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
//			log.info("Run: {}", run);
//		};
//	}
}
