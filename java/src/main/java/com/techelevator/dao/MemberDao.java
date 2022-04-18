package com.techelevator.dao;

import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Member;

import java.util.List;

public interface MemberDao {

    List<Member> findAll();

    Long findMemberIdByUsername(String username) throws MemberNotFoundException;

    Member getMemberByMemberId(Long memberId) throws MemberNotFoundException;

    Member getMemberByUserId(Long userId) throws MemberNotFoundException;

    Member create(Member member);

    void updateMember(Member member) throws MemberNotFoundException;

}
