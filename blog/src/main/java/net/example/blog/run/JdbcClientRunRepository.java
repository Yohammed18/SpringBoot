package net.example.blog.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@Repository
public class JdbcClientRunRepository {

    private static final Logger log = LoggerFactory.getLogger((JdbcClientRunRepository.class));
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll(){
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("select * from run where id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run){
        var create = jdbcClient.sql("INSERT INTO Run (id, title, started_on, completed_on, miles, location)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?);\n")
                .params(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString())
                .update();

        Assert.state(create == 1, "Failed to create " + run.title());
    }


    public void update(Run run, Integer id){
        var update = jdbcClient.sql("Update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ?")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
                .update();

        Assert.state(update == 1, "Failed to update " + run.title());
    }

    public void delete(Integer id){
        var delete = jdbcClient.sql("delete from run where id = :id" )
                .param("id", id)
                .update();

        Assert.state(delete == 1, "Failed to delete run " + id);
    }

    public void saveAll(List<Run> runs){
        runs.stream().forEach(this::create);
    }

    public int count(){ return jdbcClient.sql("Select * from run").query().listOfRows().size(); }

    public List<Run> findByLocation(String location){
        return jdbcClient.sql("select * from run where location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }


}
