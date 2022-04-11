package com.techelevator.dao;

import com.techelevator.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JdbcMemberDao implements MemberDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member getMemberByMemberId(Long memberId) {
        return null;
    }

    @Override
    public Member getMemberByUserId(Long memberId) {
        return null;
    }

    @Override
    public boolean create(Long userId, String firstName, String lastName, String email) {
        return false;
    }

    @Override
    public boolean setProfile(Map<String, String> profile) {
        return false;
    }

    @Override
    public boolean addProfileDetail(String key, String value) {
        return false;
    }

    @Override
    public boolean updateProfileDetail(String key, String value) {
        return false;
    }

    @Override
    public boolean removeProfileDetail(String key) {
        return false;
    }

    @Override
    public boolean setGoals(Map<String, String> goals) {
        return false;
    }

    @Override
    public boolean addGoal(String key, String value) {
        return false;
    }

    @Override
    public boolean updateGoal(String key, String value) {
        return false;
    }

    @Override
    public boolean removeGoal(String key, String value) {
        return false;
    }
}
