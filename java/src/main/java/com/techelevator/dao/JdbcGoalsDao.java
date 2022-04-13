package com.techelevator.dao;

import com.techelevator.exceptions.GoalsNotFoundException;
import com.techelevator.exceptions.ProfileNotFoundException;
import com.techelevator.model.MemberGoals;
import com.techelevator.model.MemberProfile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class JdbcGoalsDao implements GoalsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcGoalsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MemberGoals getGoalsByMemberId(Long memberId) throws GoalsNotFoundException {
        String sql = "SELECT * FROM goals WHERE member_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,memberId);
        if(results.next()) {
            return mapRowToGoals(results);
        } else {
            throw new GoalsNotFoundException(memberId);
        }
    }

    @Override
    public MemberGoals getGoalsByGoalsId(Long goalsId) throws GoalsNotFoundException {
        String sql = "SELECT * FROM goals WHERE goals_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,goalsId);
        if(results.next()) {
            return mapRowToGoals(results);
        } else {
            throw new GoalsNotFoundException(goalsId);
        }
    }

    @Override
    public MemberGoals createGoals(MemberGoals goals) {
        String insertGoals = "INSERT INTO goals (member_id,"+
                "back_squat,front_squat,zercher_squat,overhead_squat,bulgarian_split_squat,"+
                "conventional_deadlift,sumo_deadlift,"+
                "overhead_press,military_press,push_press,"+
                "squat_clean,power_clean,split_jerk,push_jerk,squat_jerk,"+
                "squat_snatch,power_snatch,snatch_balance) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING goals_id;";
        Long goalsId = jdbcTemplate.queryForObject(insertGoals,Long.class,goals.getMemberId(),
                goals.getBackSquat(),goals.getFrontSquat(),goals.getZercherSquat(),goals.getBulgarianSplitSquat(),
                goals.getConventionalDeadlift(),goals.getSumoDeadlift(),
                goals.getOverheadPress(),goals.getMilitaryPress(),goals.getPushPress(),
                goals.getSquatClean(),goals.getPowerClean(),goals.getSplitJerk(),goals.getPushJerk(),goals.getSquatJerk(),
                goals.getSquatSnatch(),goals.getPowerSnatch(),goals.getSnatchBalance()
        );
        goals.setGoalsId(goalsId);
        return goals;
    }

    @Override
    public void updateGoals(MemberGoals goals) throws GoalsNotFoundException {
        String update = "UPDATE goals SET "+
                "back_squat = ?,front_squat = ?,zercher_squat = ?,overhead_squat = ?,bulgarian_split_squat = ?,"+
                "conventional_deadlift = ?,sumo_deadlift = ?,"+
                "overhead_press = ?,military_press = ?,push_press = ?,"+
                "squat_clean = ?,power_clean = ?,split_jerk = ?,push_jerk = ?,squat_jerk = ?,"+
                "squat_snatch = ?,power_snatch = ?,snatch_balance = ? "+
                "WHERE member_id = ?;";
        try {
            jdbcTemplate.update(update,
                    goals.getBackSquat(), goals.getFrontSquat(), goals.getZercherSquat(), goals.getBulgarianSplitSquat(),
                    goals.getConventionalDeadlift(), goals.getSumoDeadlift(),
                    goals.getOverheadPress(), goals.getMilitaryPress(), goals.getPushPress(),
                    goals.getSquatClean(), goals.getPowerClean(), goals.getSplitJerk(), goals.getPushJerk(), goals.getSquatJerk(),
                    goals.getSquatSnatch(), goals.getPowerSnatch(), goals.getSnatchBalance(),
                    goals.getMemberId()
            );
        } catch(Exception e) {
            throw new GoalsNotFoundException(goals.getMemberId());
        }
    }

    private MemberGoals mapRowToGoals(SqlRowSet rs) {
        MemberGoals goals = new MemberGoals();
        goals.setGoalsId(rs.getLong("profile_id"));
        goals.setMemberId(rs.getLong("member_id"));
        goals.setBackSquat(rs.getString("back_squat"));
        goals.setFrontSquat(rs.getString("front_squat"));
        goals.setZercherSquat(rs.getString("zercher_squat"));
        goals.setOverheadSquat(rs.getString("overhead_squat"));
        goals.setBulgarianSplitSquat(rs.getString("bulgarian_split_squat"));
        goals.setConventionalDeadlift(rs.getString("conventional_deadlift"));
        goals.setSumoDeadlift(rs.getString("sumo_deadlift"));
        goals.setOverheadPress(rs.getString("overhead_press"));
        goals.setMilitaryPress(rs.getString("military_press"));
        goals.setPushPress(rs.getString("push_press"));
        goals.setSquatClean(rs.getString("squat_clean"));
        goals.setPowerClean(rs.getString("power_clean"));
        goals.setSplitJerk(rs.getString("split_jerk"));
        goals.setPushJerk(rs.getString("push_jerk"));
        goals.setSquatJerk(rs.getString("squat_jerk"));
        goals.setSquatSnatch(rs.getString("squat_snatch"));
        goals.setPowerSnatch(rs.getString("power_snatch"));
        goals.setSnatchBalance(rs.getString("snatch_balance"));
        return goals;
    }
}
