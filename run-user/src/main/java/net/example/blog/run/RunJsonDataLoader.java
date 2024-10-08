package net.example.blog.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.example.blog.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private final JdbcClientRunRepository jdbcClientRunRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(JdbcClientRunRepository jdbcClientRunRepository, ObjectMapper objectMapper) {
        this.jdbcClientRunRepository = jdbcClientRunRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("This is the RunJsonDataLoader Class\n");
        logger.info("LOAD DATA....");
        if(jdbcClientRunRepository.count() == 0){
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")){
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                logger.info("Reading {} runs from JSON data and saving to a database.", allRuns.runs().size());
                jdbcClientRunRepository.saveAll(allRuns.runs());
            }catch (IOException e){
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            logger.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }
}
