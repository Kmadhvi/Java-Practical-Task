package com.expense_management.service.impl;

import com.expense_management.dto.CreateMemberRequest;
import com.expense_management.entity.Member;
import com.expense_management.entity.TripGroup;
import com.expense_management.repository.MemberRepository;
import com.expense_management.repository.TripGroupRepository;
import com.expense_management.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final TripGroupRepository tripGroupRepository;

    @Override
    public Member addMember(Long tripGroupId,
                            CreateMemberRequest request) {

        TripGroup tripGroup = tripGroupRepository.findById(tripGroupId)
                .orElseThrow(() ->
                        new RuntimeException("Trip Group not found"));

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .tripGroup(tripGroup)
                .build();

        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMembers(Long tripGroupId) {

        tripGroupRepository.findById(tripGroupId)
                .orElseThrow(() ->
                        new RuntimeException("Trip Group not found"));

        return memberRepository.findByTripGroupId(tripGroupId);

    }


}
