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

import com.team_2.models.Recharge;
import com.team_2.services.RechargeService;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    private static final Logger logger = LoggerFactory.getLogger(RechargeController.class);

    @Autowired
    private RechargeService rechargeService;

    @GetMapping
    public List<Recharge> getRecharges() {
        logger.info("Received request to fetch all recharges");
        List<Recharge> recharges = rechargeService.getAllRecharges();
        logger.debug("Fetched {} recharges from service", recharges.size());
        return recharges;
    }

    @PostMapping
    public Recharge addRecharge(@RequestBody Recharge recharge) {
        logger.info("Received request to add new recharge for memberId: {}", recharge.getMemberId());
        Recharge savedRecharge = rechargeService.addRecharge(recharge);
        logger.info("Recharge saved successfully with id: {}", savedRecharge.getId());
        return savedRecharge;
    }
}
