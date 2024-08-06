package net.example.blog.run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
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
    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }


    //create a method that return a run based on id
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){

        Optional<Run> run =  runRepository.findById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void createRun(@RequestBody Run run){
        runRepository.create(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Integer id){
        runRepository.removeById(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        runRepository.UpdateById(run,id);
    }


}
