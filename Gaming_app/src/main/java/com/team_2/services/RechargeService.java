package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.models.Recharge;
import com.team_2.repositories.RechargeRepository;

@Service
public class RechargeService {

    private static final Logger logger = LoggerFactory.getLogger(RechargeService.class);

    @Autowired
    private RechargeRepository rechargeRepo;

    public List<Recharge> getAllRecharges() {
        logger.info("Fetching all recharges from database");
        List<Recharge> recharges = rechargeRepo.findAll();
        logger.info("Retrieved {} recharges from database", recharges.size());
        return recharges;
    }

    public Recharge addRecharge(Recharge recharge) {
        logger.info("Attempting to add new recharge for memberId: {}", recharge.getMemberId());
        Recharge savedRecharge = rechargeRepo.save(recharge);
        logger.info("Recharge added successfully with ID: {}", savedRecharge.getId());
        return savedRecharge;
    }
}
