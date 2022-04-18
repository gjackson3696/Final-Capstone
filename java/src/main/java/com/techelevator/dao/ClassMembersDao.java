package com.techelevator.dao;

import java.util.List;

public interface ClassMembersDao {

    List<Long> getRegisteredClassesByMemberId(Long memberId);

    void registerMember(Long memberId, Long classId);

    void unregisterMember(Long memberId, Long classId);
}
