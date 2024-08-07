package net.example.blog;

import net.example.blog.user.Impl.UserHttpClient;
import net.example.blog.user.User;
import net.example.blog.user.UserNotFoundException;
import net.example.blog.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRestClient restClient){
		return args -> {
			logger.info("JSON Placeholder API Client interaction\n");
//			List<User> users = restClient.findAll();
//			logger.info("Fetched Users: {}", users);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a number for user id?");
			Integer id = scanner.nextInt();

			try{
				User user = restClient.findById(id);
				logger.info("Fetched User with ID {}: {}", id, user);
			}catch (UserNotFoundException e){
				logger.error("Error fetching user: {}",e.getMessage());
			}
		};
	}



	UserHttpClient userHttpRestClient(){
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/users");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}
}
