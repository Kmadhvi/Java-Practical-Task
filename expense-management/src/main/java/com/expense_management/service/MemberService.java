package com.expense_management.service;

import com.expense_management.dto.CreateMemberRequest;
import com.expense_management.entity.Member;

import java.util.List;

public interface MemberService {

    Member addMember(Long tripGroupId, CreateMemberRequest request);

    List<Member> getMembers(Long tripGroupId);

}
