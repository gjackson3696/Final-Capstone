package com.techelevator.dao;

import com.techelevator.model.Member;

import java.util.List;
import java.util.Map;

public interface MemberDao {

    List<Member> findAll();

    Member getMemberByMemberId(Long memberId);

    Member getMemberByUserId(Long memberId);

    boolean create(Long userId, String firstName, String lastName, String email);

    boolean setProfile(Map<String,String> profile);

    boolean addProfileDetail(String key, String value);

    boolean updateProfileDetail(String key, String value);

    boolean removeProfileDetail(String key);

    boolean setGoals(Map<String,String> goals);

    boolean addGoal(String key, String value);

    boolean updateGoal(String key, String value);

    boolean removeGoal(String key, String value);
}
