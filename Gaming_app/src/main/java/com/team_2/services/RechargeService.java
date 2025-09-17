package com.team_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.team_2.models.Recharge;
import com.team_2.repositories.RechargeRepository;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepo;

    public List<Recharge> getAllRecharges() {
        return rechargeRepo.findAll();
    }

    public Recharge addRecharge(Recharge recharge) {
        return rechargeRepo.save(recharge);
    }
}
