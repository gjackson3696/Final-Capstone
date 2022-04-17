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
    public List<Workout> getWorkoutsByUserId(Long userId) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        while(results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }

    @Override
    public void addNewWorkout(Workout workout) {
        String insertWorkout = "INSERT INTO workouts (user_id,name,domain,structure," +
                "weights,workoutTime,rounds,completed) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(insertWorkout,workout.getUserId(),workout.getName(),
                workout.getDomain(),workout.getStructure(),workout.getWeights(),
                workout.getTime(),workout.getRounds(),workout.isCompleted());
    }

    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkoutId(rs.getLong("workout_id"));
        workout.setUserId(rs.getLong("user_id"));
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
