package com.techelevator.dao;

import com.techelevator.model.Workout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcWorkoutDao implements WorkoutDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Workout> getWorkoutsByMemberId(Long memberId) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts WHERE member_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,memberId);
        while(results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return null;
    }

    @Override
    public void addNewWorkout(Workout workout) {
        String insertWorkout = "INSERT INTO workouts (member_id,name,domain,structure," +
                "weights,workoutTime,rounds,completed) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(insertWorkout,workout.getMemberId(),workout.getName(),
                workout.getDomain(),workout.getStructure(),workout.getWeights(),
                workout.getTime(),workout.getRounds(),workout.isCompleted());
    }

    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkoutId(rs.getLong("workout_id"));
        workout.setMemberId(rs.getLong("member_id"));
        workout.setName(rs.getString("name"));
        workout.setDomain(rs.getString("domain"));
        workout.setStructure(rs.getString("structure"));
        workout.setWeights(rs.getString("weights"));
        workout.setTime(rs.getString("workoutTime"));
        workout.setRounds(rs.getString("rounds"));
        workout.setCompleted(rs.getBoolean("completed"));
        return workout;
    }
}
