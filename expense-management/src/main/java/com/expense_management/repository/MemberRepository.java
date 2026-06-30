package com.expense_management.repository;

import com.expense_management.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByTripGroupId(Long groupId);
}
