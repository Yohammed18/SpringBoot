package net.example.blog.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository{

    private static final Logger log = LoggerFactory.getLogger((RunRepository.class));
    private List<Run> runs = new ArrayList<>();
    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "First Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3, Location.OUTDOOR));
        runs.add(new Run(2,
                "Second Run",
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS).plus(60, ChronoUnit.MINUTES),
                5, Location.INDOOR));
        runs.add(new Run(3,
                "Third Run",
                LocalDateTime.now().plus(4, ChronoUnit.HOURS),
                LocalDateTime.now().plus(4, ChronoUnit.HOURS).plus(45, ChronoUnit.MINUTES),
                4, Location.OUTDOOR));
        runs.add(new Run(4,
                "Fourth Run",
                LocalDateTime.now().plus(6, ChronoUnit.HOURS),
                LocalDateTime.now().plus(6, ChronoUnit.HOURS).plus(30, ChronoUnit.MINUTES),
                6, Location.INDOOR));
        runs.add(new Run(5,
                "Fifth Run",
                LocalDateTime.now().plus(8, ChronoUnit.HOURS),
                LocalDateTime.now().plus(8, ChronoUnit.HOURS).plus(60, ChronoUnit.MINUTES),
                7, Location.OUTDOOR));
        runs.add(new Run(6,
                "Sixth Run",
                LocalDateTime.now().plus(10, ChronoUnit.HOURS),
                LocalDateTime.now().plus(10, ChronoUnit.HOURS).plus(90, ChronoUnit.MINUTES),
                8, Location.INDOOR));
        runs.add(new Run(7,
                "Seventh Run",
                LocalDateTime.now().plus(12, ChronoUnit.HOURS),
                LocalDateTime.now().plus(12, ChronoUnit.HOURS).plus(45, ChronoUnit.MINUTES),
                5, Location.OUTDOOR));
        runs.add(new Run(8,
                "Eighth Run",
                LocalDateTime.now().plus(14, ChronoUnit.HOURS),
                LocalDateTime.now().plus(14, ChronoUnit.HOURS).plus(60, ChronoUnit.MINUTES),
                9, Location.INDOOR));
        runs.add(new Run(9,
                "Ninth Run",
                LocalDateTime.now().plus(16, ChronoUnit.HOURS),
                LocalDateTime.now().plus(16, ChronoUnit.HOURS).plus(30, ChronoUnit.MINUTES),
                4, Location.OUTDOOR));
        runs.add(new Run(10,
                "Tenth Run",
                LocalDateTime.now().plus(18, ChronoUnit.HOURS),
                LocalDateTime.now().plus(18, ChronoUnit.HOURS).plus(30, ChronoUnit.MINUTES),
                6, Location.INDOOR));
    }

    // returns all the runs
    List<Run> findAll() {
        return runs;
    }

    //return run by id
    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    //create a new run and adds it to the list of runs
    void create(Run run){
        runs.add(run);
    }

    //delete run by id
    void removeById(Integer id){
//        Optional<Run> removeRun = findById(id);
//        runs.remove(removeRun.get());
        runs.removeIf(run -> run.id() == id);
    }

    //Update run
    void UpdateById(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()),run);
        }
    }
}
