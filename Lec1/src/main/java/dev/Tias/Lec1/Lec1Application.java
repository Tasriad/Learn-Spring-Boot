package dev.Tias.Lec1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lec1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Lec1Application.class, args);
		Dev dev = context.getBean(Dev.class);
		dev.greet();
	}

}
