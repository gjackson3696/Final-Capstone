package com.techelevator.dao;

import com.techelevator.model.LoggedWorkout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcLoggedWorkoutDao implements LoggedWorkoutDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLoggedWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LoggedWorkout> getLoggedWorkoutsByUserId(Long userId) {
        List<LoggedWorkout> loggedWorkouts = new ArrayList<>();
        String sql = "SELECT * FROM logged_workouts WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        while(results.next()) {
            LoggedWorkout workout = mapRowToLoggedWorkout(results);
            loggedWorkouts.add(workout);
        }
        return loggedWorkouts;
    }

    @Override
    public void logWorkout(LoggedWorkout workout) {
        String logWorkout = "INSERT INTO logged_workouts (user_id,name,domain,structure," +
                "weights,workoutTime,rounds,completed) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(logWorkout,workout.getUserId(),workout.getName(),
                workout.getDomain(),workout.getStructure(),workout.getWeights(),
                workout.getTime(),workout.getRounds(),workout.isCompleted());
    }

    private LoggedWorkout mapRowToLoggedWorkout(SqlRowSet rs) {
        LoggedWorkout workout = new LoggedWorkout();
        workout.setWorkoutId(rs.getLong("logged_workout_id"));
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
