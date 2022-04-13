package com.techelevator.dao;

import java.util.List;

public interface ClassMembersDao {

    List<Long> getRegisteredClassesByMemberId(Long memberId);

}
