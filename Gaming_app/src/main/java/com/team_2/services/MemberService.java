package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.exceptions.BadRequestException;
import com.team_2.exceptions.ResourceNotFoundException;
import com.team_2.models.Member;
import com.team_2.repositories.MemberRepository;

@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberRepository memberRepo;

    // Get all members
    public List<Member> getAllMembers() {
        logger.info("Fetching all members from DB");
        List<Member> members = memberRepo.findAll();
        if (members.isEmpty()) {
            logger.error("No members found");
            throw new ResourceNotFoundException("No members found in database");
        }
        return members;
    }

    // Get member by ID
    public Member getMemberById(String id) {
        logger.info("Fetching member with ID: {}", id);
        return memberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));
    }

    // Add new member
    public Member addMember(Member member) {
        if (member == null || member.getName() == null || member.getName().trim().isEmpty()) {
            logger.error("Invalid member data: name missing");
            throw new BadRequestException("Member name must not be empty");
        }
        logger.info("Adding new member: {}", member.getName());
        return memberRepo.save(member);
    }

    // Update member
    public Member updateMember(String id, Member memberDetails) {
        logger.info("Updating member with ID: {}", id);
        Member existingMember = memberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));

        existingMember.setName(memberDetails.getName());
        existingMember.setEmail(memberDetails.getEmail());
        existingMember.setAge(memberDetails.getAge());
        existingMember.setBalance(memberDetails.getBalance());
        existingMember.setStatus(memberDetails.getStatus());

        return memberRepo.save(existingMember);
    }

    // Delete member
    public void deleteMember(String id) {
        logger.info("Deleting member with ID: {}", id);
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));
        memberRepo.delete(member);
        logger.info("Member with ID {} deleted successfully", id);
    }
}
