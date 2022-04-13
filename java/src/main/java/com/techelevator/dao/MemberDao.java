package com.techelevator.dao;

import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Member;

import java.util.List;

public interface MemberDao {

    List<Member> findAll();

    Member getMemberByMemberId(Long memberId) throws MemberNotFoundException;

    Member getMemberByUserId(Long userId) throws MemberNotFoundException;

    Member create(Member member);

    void updateMember(Member member) throws MemberNotFoundException;

    void updateName(Long memberId, String firstName, String lastName) throws MemberNotFoundException;

    void updateEmail(Long memberId, String email) throws MemberNotFoundException;

}
