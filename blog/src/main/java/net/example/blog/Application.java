package net.example.blog;

import net.example.blog.run.Location;
import net.example.blog.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	// logger
	private static final Logger logger = LoggerFactory.getLogger((Application.class));

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);






//		logger.info("Application started successfully!");
//		logger.info("Add changes!");
		//logger documentation https://docs.spring.io/spring-boot/reference/features/logging.html

//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//
//		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
//		System.out.println(welcomeMessage.getWelcomeMessage());

// This format is not ideal. What we want to focus is implement IOC which is the bread & butter for applications built on Spring Boot
//		var welcomeMessage = new WelcomeMessage();
//		System.out.println(welcomeMessage.getWelcomeMessage());
	}


	// this will run after the application is running
//	@Bean
//		CommandLineRunner runner(){
//			return args -> {
//				Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR);
//				logger.info("Run: \n"+ run);
//			};
//	}

}
