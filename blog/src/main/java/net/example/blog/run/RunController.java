package net.example.blog.run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {
    private final RunRepository runRepository;
    private static final Logger logger = LoggerFactory.getLogger((RunController.class));

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

//    @GetMapping("/hello")
//    String home(){
//        return "Hello, Runner";
//    }

    //CRUD REST API
    //create a method that returns all the runs
    @GetMapping("/api/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }


    //create a method that return a run based on id
    @GetMapping("/api/run/{id}")
    Run findById(@PathVariable Integer id){

        Optional<Run> run =  runRepository.getRunById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

}
