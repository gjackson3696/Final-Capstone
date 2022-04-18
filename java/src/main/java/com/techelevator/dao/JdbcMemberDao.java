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
    public Long findMemberIdByUsername(String username) throws MemberNotFoundException {
        String sql = "SELECT members.member_id FROM members " +
                "JOIN users ON members.user_id = users.user_id " +
                "WHERE users.username = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,username);
        if(results.next()) {
            return results.getLong("member_id");
        } else {
            throw new MemberNotFoundException(username);
        }
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
        String insertMember = "INSERT INTO members (user_id,first_name,last_name,email) "+
                "VALUES (?,?,?,?) RETURNING member_id;";
        member.setMemberId(jdbcTemplate.queryForObject(insertMember,Long.class,
                member.getUserId(),member.getFirstName(),member.getLastName(),member.getEmail()));
        return member;
    }

    @Override
    public void updateMember(Member member) throws MemberNotFoundException {
        String update = "UPDATE members SET first_name = ?, last_name = ?, email = ? WHERE user_id = ?;";
        try {
            jdbcTemplate.update(update,member.getFirstName(),member.getLastName(),member.getEmail(),member.getUserId());
        } catch(Exception e) {
            throw new MemberNotFoundException(member.getMemberId());
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
