package com.techelevator.dao;

import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Member member = mapRowToMember(results);
            members.add(member);
        }
        return members;
    }

    @Override
    public Member getMemberByMemberId(Long memberId) throws MemberNotFoundException {
        String sql = "SELECT * FROM members WHERE member_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,memberId);
        if(results.next()) {
            return mapRowToMember(results);
        } else {
            throw new MemberNotFoundException(memberId);
        }
    }

    @Override
    public Member getMemberByUserId(Long userId) throws MemberNotFoundException {
        String sql = "SELECT * FROM members WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        if(results.next()) {
            return mapRowToMember(results);
        } else {
            throw new MemberNotFoundException(userId);
        }
    }

    @Override
    public Member create(Member member) {
        String insertMember = "INSERT INTO members ( ) "+
                "VALUES (?,?,?,?) RETURNING member_id;";
        member.setMemberId(jdbcTemplate.queryForObject(insertMember,Long.class,
                member.getUserId(),member.getFirstName(),member.getLastName(),member.getEmail()));
        return member;
    }

    @Override
    public void updateMember(Member member) throws MemberNotFoundException {
        String update = "UPDATE members SET first_name = ?, last_name = ?, email = ? WHERE member_id = ?;";
        try {
            jdbcTemplate.update(update,member.getFirstName(),member.getLastName(),member.getEmail(),member.getMemberId());
        } catch(Exception e) {
            throw new MemberNotFoundException(member.getMemberId());
        }
    }

    @Override
    public void updateName(Long memberId, String firstName, String lastName) throws MemberNotFoundException {
        String sql = "UPDATE members SET first_name = ?, last_name = ? WHERE member_id = ?;";
        try {
            jdbcTemplate.update(sql, firstName, lastName, memberId);
        } catch(Exception e) {
            throw new MemberNotFoundException(memberId);
        }
    }

    @Override
    public void updateEmail(Long memberId, String email) throws MemberNotFoundException {
        String sql = "UPDATE members SET email = ? WHERE member_id = ?;";
        try {
            jdbcTemplate.update(sql, email, memberId);
        } catch(Exception e) {
            throw new MemberNotFoundException(memberId);
        }
    }

    private Member mapRowToMember(SqlRowSet results) {
        Member member = new Member();
        member.setMemberId(results.getLong("member_id"));
        member.setUserId(results.getLong("user_id"));
        member.setFirstName(results.getString("first_name"));
        member.setLastName(results.getString("last_name"));
        member.setEmail(results.getString("email"));
        return member;
    }
}
