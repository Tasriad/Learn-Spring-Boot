package dev.Tias.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/runs")
public class RunController {

    private final RunRepository runRepository;
    public RunController(RunRepository runRepository)
    {
        this.runRepository = runRepository;
    }
    @GetMapping("")
    List<Run> findAll()
    {
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id)
    {
        return runRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Run not found with id: " + id));
    }
    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createrun(@Valid  @RequestBody Run run)
    {
        runRepository.createRun(run);
    }
    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateRun(@Valid @PathVariable Integer id, @RequestBody Run run)
    {
        runRepository.updateRun(id, run);
    }
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteRun(@PathVariable Integer id)
    {
        runRepository.deleteRun(id);
    }
}
