package com.team_2.controllers;

import java.util.List;

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

    @Autowired
    private RechargeService rechargeService;

    @GetMapping
    public List<Recharge> getRecharges() {
        return rechargeService.getAllRecharges();
    }

    @PostMapping
    public Recharge addRecharge(@RequestBody Recharge recharge) {
        return rechargeService.addRecharge(recharge);
    }
}
