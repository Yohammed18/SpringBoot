package net.example.blog.run;
import jakarta.validation.Valid;
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

    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Run> findById(@PathVariable Integer id){
        Optional run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }


}
