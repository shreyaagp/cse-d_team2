package com.team_2.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="transactions")
public class Transaction {

    @Id
    private String id;
    private String memberId;
    private String gameId;
    private double amount;
    private Date date = new Date();
    private int duration; // in minutes
    private int players; // number of players
    private boolean playersMultiple; // true if multiple players, false if single player
    private String status; // completed, pending, cancelled

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getGameId() { return gameId; }
    public void setGameId(String gameId) { this.gameId = gameId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getPlayers() { return players; }
    public void setPlayers(int players) { this.players = players; }

    public boolean isPlayersMultiple() { return playersMultiple; }
    public void setPlayersMultiple(boolean playersMultiple) { this.playersMultiple = playersMultiple; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
