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

import com.team_2.models.Recharge;
import com.team_2.services.RechargeService;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    private static final Logger logger = LoggerFactory.getLogger(RechargeController.class);

    @Autowired
    private RechargeService rechargeService;

    // Get all recharges
    @GetMapping
    public ResponseEntity<List<Recharge>> getAllRecharges() {
        logger.info("API Call: GET /recharges");
        return ResponseEntity.ok(rechargeService.getAllRecharges());
    }

    // Get recharge by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recharge> getRechargeById(@PathVariable String id) {
        logger.info("API Call: GET /recharges/{}", id);
        return ResponseEntity.ok(rechargeService.getRechargeById(id));
    }

    // Add new recharge
    @PostMapping
    public ResponseEntity<Recharge> addRecharge(@RequestBody Recharge recharge) {
        logger.info("API Call: POST /recharges");
        return ResponseEntity.ok(rechargeService.addRecharge(recharge));
    }

    // Update recharge
    @PutMapping("/{id}")
    public ResponseEntity<Recharge> updateRecharge(@PathVariable String id, @RequestBody Recharge recharge) {
        logger.info("API Call: PUT /recharges/{}", id);
        return ResponseEntity.ok(rechargeService.updateRecharge(id, recharge));
    }

    // Delete recharge
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecharge(@PathVariable String id) {
        logger.info("API Call: DELETE /recharges/{}", id);
        rechargeService.deleteRecharge(id);
        return ResponseEntity.ok("Recharge with ID " + id + " deleted successfully");
    }
}
