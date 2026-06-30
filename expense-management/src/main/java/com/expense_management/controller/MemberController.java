package com.expense_management.controller;

import com.expense_management.dto.CreateMemberRequest;
import com.expense_management.entity.Member;
import com.expense_management.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip-groups")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/{tripGroupId}/members")
    public Member addMember(
            @PathVariable Long tripGroupId,
            @Valid @RequestBody CreateMemberRequest request) {

        return memberService.addMember(tripGroupId, request);

    }

    @GetMapping("/{tripGroupId}/members")
    public List<Member> getMembers(
            @PathVariable Long tripGroupId) {

        return memberService.getMembers(tripGroupId);

    }

}
