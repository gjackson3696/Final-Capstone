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
                "weights,workoutTime,rounds,completed," +
                "back_squat,front_squat,zercher_squat,overhead_squat,bulgarian_split_squat," +
                "conventional_deadlift,sumo_deadlift,"+
                "overhead_press,military_press,push_press," +
                "squat_clean,power_clean,split_jerk,push_jerk,squat_jerk," +
                "squat_snatch,power_snatch,snatch_balance) " +
                "VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(logWorkout,workout.getUserId(),workout.getName(),
                workout.getDomain(),workout.getStructure(),workout.getWeights(),
                workout.getTime(),workout.getRounds(),workout.isCompleted(),
                workout.getBackSquat(),workout.getFrontSquat(),workout.getZercherSquat(),workout.getOverheadSquat(),workout.getBulgarianSplitSquat(),
                workout.getConventionalDeadlift(),workout.getSumoDeadlift(),
                workout.getOverheadPress(),workout.getMilitaryPress(),workout.getPushPress(),
                workout.getSquatClean(),workout.getPowerClean(),workout.getSplitJerk(),workout.getPushJerk(),workout.getSquatJerk(),
                workout.getSquatSnatch(),workout.getPowerSnatch(),workout.getSnatchBalance()
                );
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
