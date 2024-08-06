package net.example.blog;

import net.example.blog.run.Location;
import net.example.blog.run.Run;
import net.example.blog.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}


	//this is how will insert some data.
//	@Bean
//	CommandLineRunner runner(RunRepository repository){
//		return args -> {
//			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR);
//			logger.info("Run: \n"+ run);
//			repository.create(run);
//		};
//	}
}
