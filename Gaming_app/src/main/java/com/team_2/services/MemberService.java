package com.team_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.models.Member;
import com.team_2.repositories.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member addMember(Member member) {
        return memberRepo.save(member);
    }
}
