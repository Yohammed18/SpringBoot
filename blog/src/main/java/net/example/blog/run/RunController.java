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

}
