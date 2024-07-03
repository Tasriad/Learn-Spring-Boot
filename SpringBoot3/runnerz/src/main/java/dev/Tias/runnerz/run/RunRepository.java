package dev.Tias.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
private final JdbcClient jdbcClient;
public RunRepository(JdbcClient jdbcClient)
{
    this.jdbcClient = jdbcClient;
}
public List<Run> findAll(){
    return jdbcClient.sql("select * from Run").query(Run.class).list();
}
public Optional<Run> findById(Integer id){
    return jdbcClient.sql("select * from Run where id = :id").param("id", id).query(Run.class).optional();
}
public void createRun(Run run){
    var id = jdbcClient.sql("insert into Run (title, startedOn, endedOn, miles, location) values (?, ?, ?, ?, ?)")
            .params(List.of(run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().toString())).update();
    Assert.state(id == 1, "Run not created " + run.title());
}
public void updateRun(Integer id,Run run){
    var update = jdbcClient.sql("update Run set title = ?, startedOn = ?, endedOn = ?, miles = ?, location = ? where id = ?")
            .params(List.of(run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().name(), run.id())).update();
    Assert.state(update == 1, "Run not found with id: " + run.id());
}
public void deleteRun(Integer id){
    var delete = jdbcClient.sql("delete from Run where id = :id").param("id", id).update();
    Assert.state(delete == 1, "Run not found with id: " + id);
}
public int count()
{
    return jdbcClient.sql("select * from Run").query().listOfRows().size();

}
public void saveAll(List<Run> runs)
{
    runs.stream().forEach(this::createRun);
}
public List<Run> findByLocation(Location location)
{
    return jdbcClient.sql("select * from Run where location = :location").param("location", location.name()).query(Run.class).list();
}
//------------------------------------------> WITHOUT DATABASE<-----------------------------------------------------
//    private List<Run> runs = new ArrayList<>();
//    public List<Run> findAll()
//    {
//        return runs;
//    }
//    public Optional<Run> findById(Integer id)
//    {
//        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
//    }
//    public void createRun(Run run)
//    {
//        runs.add(run);
//    }
//    public void updateRun(Integer id, Run run)
//    {
//        Optional<Run> existingRun = findById(id);
//        if(existingRun.isPresent())
//        {
//            runs.set(runs.indexOf(existingRun.get()), run);
//        }
//    }
//    public void deleteRun(Integer id)
//    {
//        Optional<Run> existingRun = findById(id);
//        existingRun.ifPresent(run -> runs.remove(run));
//    }
//    @PostConstruct
//    private void init(){
//        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR));
//        runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 5, Location.INDOOR));
//    }
//------------------------------------------> WITHOUT DATABASE<-----------------------------------------------------


}
