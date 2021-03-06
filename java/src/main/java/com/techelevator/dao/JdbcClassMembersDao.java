package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcClassMembersDao implements ClassMembersDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcClassMembersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Long> getRegisteredClassesByMemberId(Long memberId) {
        List<Long> registeredClasses = new ArrayList<>();
        String sql = "SELECT class_id FROM class_members WHERE member_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,memberId);
        while(results.next()) {
            registeredClasses.add(results.getLong("class_id"));
        }
        return registeredClasses;
    }

    @Override
    public void registerMember(Long memberId, Long classId) {
        String sql = "INSERT INTO class_members (class_id,member_id) VALUES (?,?);";
        jdbcTemplate.update(sql,classId,memberId);
    }

    @Override
    public void unregisterMember(Long memberId, Long classId) {
        String sql = "DELETE FROM class_members WHERE member_id = ? AND class_id = ?;";
        jdbcTemplate.update(sql,memberId,classId);
    }

}
