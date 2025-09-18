package com.team_2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team_2.models.Member;
import com.team_2.services.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
        logger.info("Received request to fetch all members");
        List<Member> members = memberService.getAllMembers();
        logger.debug("Fetched {} members from service", members.size());
        return members;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        logger.info("Received request to create new member: {}", member.getName());
        Member savedMember = memberService.addMember(member);
        logger.info("Member saved successfully with id: {}", savedMember.getId());
        return savedMember;
    }
}
