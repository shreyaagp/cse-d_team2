package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.exceptions.BadRequestException;
import com.team_2.exceptions.ResourceNotFoundException;
import com.team_2.models.Recharge;
import com.team_2.repositories.RechargeRepository;

@Service
public class RechargeService {

    private static final Logger logger = LoggerFactory.getLogger(RechargeService.class);

    @Autowired
    private RechargeRepository rechargeRepo;

    // Get all recharges
    public List<Recharge> getAllRecharges() {
        logger.info("Fetching all recharges from DB");
        List<Recharge> recharges = rechargeRepo.findAll();
        if (recharges.isEmpty()) {
            logger.error("No recharges found");
            throw new ResourceNotFoundException("No recharges found in database");
        }
        return recharges;
    }

    // Get recharge by ID
    public Recharge getRechargeById(String id) {
        logger.info("Fetching recharge with ID: {}", id);
        return rechargeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recharge with ID " + id + " not found"));
    }

    // Add new recharge
    public Recharge addRecharge(Recharge recharge) {
        if (recharge == null || recharge.getMemberId() == null || recharge.getMemberId().trim().isEmpty()) {
            logger.error("Invalid recharge: memberId missing");
            throw new BadRequestException("Member ID must not be empty");
        }
        logger.info("Adding recharge for memberId: {}", recharge.getMemberId());
        return rechargeRepo.save(recharge);
    }

    // Update recharge
    public Recharge updateRecharge(String id, Recharge updatedRecharge) {
        logger.info("Updating recharge with ID: {}", id);
        Recharge existingRecharge = rechargeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recharge with ID " + id + " not found"));

        if (updatedRecharge.getMemberId() != null) {
            existingRecharge.setMemberId(updatedRecharge.getMemberId());
        }
        if (updatedRecharge.getAmount() > 0) {
            existingRecharge.setAmount(updatedRecharge.getAmount());
        }
        if (updatedRecharge.getDate() != null) {
            existingRecharge.setDate(updatedRecharge.getDate());
        }

        return rechargeRepo.save(existingRecharge);
    }

    // Delete recharge
    public void deleteRecharge(String id) {
        logger.info("Deleting recharge with ID: {}", id);
        Recharge recharge = rechargeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recharge with ID " + id + " not found"));
        rechargeRepo.delete(recharge);
        logger.info("Recharge deleted successfully with ID: {}", id);
    }
}
