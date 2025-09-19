package com.team_2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Get all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        logger.info("API Call: Get all members");
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        logger.info("API Call: Get member by ID {}", id);
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    // Add new member
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        logger.info("API Call: Add new member");
        return ResponseEntity.ok(memberService.addMember(member));
    }

    // Update member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member memberDetails) {
        logger.info("API Call: Update member with ID {}", id);
        return ResponseEntity.ok(memberService.updateMember(id, memberDetails));
    }

    // Delete member
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable String id) {
        logger.info("API Call: Delete member with ID {}", id);
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member with ID " + id + " deleted successfully");
    }
}
