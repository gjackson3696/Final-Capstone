package com.techelevator.dao;

import com.techelevator.exceptions.ProfileNotFoundException;
import com.techelevator.model.MemberProfile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
public class JdbcProfileDao implements ProfileDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MemberProfile getProfileByUserId(Long userId) throws ProfileNotFoundException {
        String sql = "SELECT * FROM profile WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        if(results.next()) {
            return mapRowToProfile(results);
        } else {
            throw new ProfileNotFoundException(userId);
        }
    }

    @Override
    public MemberProfile getProfileByProfileId(Long profileId) throws ProfileNotFoundException {
        String sql = "SELECT * FROM profile WHERE profile_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,profileId);
        if(results.next()) {
            return mapRowToProfile(results);
        } else {
            throw new ProfileNotFoundException(profileId);
        }
    }

    @Override
    public MemberProfile createProfile(MemberProfile profile) {
        String insertProfile = "INSERT INTO profile (user_id,"+
                "back_squat,front_squat,zercher_squat,overhead_squat,bulgarian_split_squat,"+
                "conventional_deadlift,sumo_deadlift,"+
                "overhead_press,military_press,push_press,"+
                "squat_clean,power_clean,clean_jerk,split_jerk,push_jerk,squat_jerk,"+
                "squat_snatch,power_snatch,snatch_balance) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING profile_id;";
        Long profileId = jdbcTemplate.queryForObject(insertProfile,Long.class,profile.getUserId(),
                profile.getBackSquat(),profile.getFrontSquat(),profile.getZercherSquat(),profile.getOverheadSquat(),profile.getBulgarianSplitSquat(),
                profile.getConventionalDeadlift(),profile.getSumoDeadlift(),
                profile.getOverheadPress(),profile.getMilitaryPress(),profile.getPushPress(),
                profile.getSquatClean(),profile.getPowerClean(),profile.getCleanJerk(),profile.getSplitJerk(),profile.getPushJerk(),profile.getSquatJerk(),
                profile.getSquatSnatch(),profile.getPowerSnatch(),profile.getSnatchBalance()
                );
        profile.setProfileId(profileId);
        return profile;
    }

    @Override
    public void updateProfile(MemberProfile profile) throws ProfileNotFoundException {
        String update = "UPDATE profile SET "+
                "back_squat = ?,front_squat = ?,zercher_squat = ?,overhead_squat = ?,bulgarian_split_squat = ?,"+
                "conventional_deadlift = ?,sumo_deadlift = ?,"+
                "overhead_press = ?,military_press = ?,push_press = ?,"+
                "squat_clean = ?,power_clean = ?,clean_jerk = ?,split_jerk = ?,push_jerk = ?,squat_jerk = ?,"+
                "squat_snatch = ?,power_snatch = ?,snatch_balance = ? "+
                "WHERE user_id = ?;";
        try {
            jdbcTemplate.update(update,
                    profile.getBackSquat(), profile.getFrontSquat(), profile.getZercherSquat(), profile.getOverheadSquat(), profile.getBulgarianSplitSquat(),
                    profile.getConventionalDeadlift(), profile.getSumoDeadlift(),
                    profile.getOverheadPress(), profile.getMilitaryPress(), profile.getPushPress(),
                    profile.getSquatClean(), profile.getPowerClean(), profile.getCleanJerk(), profile.getSplitJerk(), profile.getPushJerk(), profile.getSquatJerk(),
                    profile.getSquatSnatch(), profile.getPowerSnatch(), profile.getSnatchBalance(),
                    profile.getUserId()
            );
        } catch(Exception e) {
            throw new ProfileNotFoundException(profile.getUserId());
        }
    }

    private MemberProfile mapRowToProfile(SqlRowSet rs) {
        MemberProfile profile = new MemberProfile();
        profile.setProfileId(rs.getLong("profile_id"));
        profile.setUserId(rs.getLong("user_id"));
        profile.setBackSquat(rs.getString("back_squat"));
        profile.setFrontSquat(rs.getString("front_squat"));
        profile.setZercherSquat(rs.getString("zercher_squat"));
        profile.setOverheadSquat(rs.getString("overhead_squat"));
        profile.setBulgarianSplitSquat(rs.getString("bulgarian_split_squat"));
        profile.setConventionalDeadlift(rs.getString("conventional_deadlift"));
        profile.setSumoDeadlift(rs.getString("sumo_deadlift"));
        profile.setOverheadPress(rs.getString("overhead_press"));
        profile.setMilitaryPress(rs.getString("military_press"));
        profile.setPushPress(rs.getString("push_press"));
        profile.setSquatClean(rs.getString("squat_clean"));
        profile.setPowerClean(rs.getString("power_clean"));
        profile.setCleanJerk(rs.getString("clean_jerk"));
        profile.setSplitJerk(rs.getString("split_jerk"));
        profile.setPushJerk(rs.getString("push_jerk"));
        profile.setSquatJerk(rs.getString("squat_jerk"));
        profile.setSquatSnatch(rs.getString("squat_snatch"));
        profile.setPowerSnatch(rs.getString("power_snatch"));
        profile.setSnatchBalance(rs.getString("snatch_balance"));
        return profile;
    }
}
