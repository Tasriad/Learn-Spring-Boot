package dev.Tias.runnerz.run;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final RunRepository runRepository;
    private final ObjectMapper objectMapper ;

    public RunJsonDataLoader(RunRepository runRepository, ObjectMapper objectMapper){
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if((runRepository.count())==0)
        {
            try(InputStream inputStream = new ClassPathResource("data/runs.json").getInputStream())
            {
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                runRepository.saveAll(allRuns.runs());
                log.info("Loaded {} runs from JSON file and saving it to a database", allRuns.runs().size());
            }
            catch (Exception e)
            {
                log.error("Failed to load runs from JSON file", e);
            }
        }
    }
}
