package net.example.blog.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {

    private static final Logger log = LoggerFactory.getLogger(UserRestClient.class);
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }


    public List<User> findAll(){
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {
        });
    }

    public User findById(Integer id){

        return restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class);
    }



}
