package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.models.Member;
import com.team_2.repositories.MemberRepository;

@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberRepository memberRepo;

    public List<Member> getAllMembers() {
        logger.info("Fetching all members from database");
        List<Member> members = memberRepo.findAll();
        logger.info("Retrieved {} members from database", members.size());
        return members;
    }

    public Member addMember(Member member) {
        logger.info("Attempting to add new member: {}", member.getName());
        Member savedMember = memberRepo.save(member);
        logger.info("Member added successfully with ID: {}", savedMember.getId());
        return savedMember;
    }
}
