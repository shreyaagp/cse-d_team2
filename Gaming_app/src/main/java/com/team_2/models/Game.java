package com.team_2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class Game {

    @Id
    private String id;
    private String name;
    private double price;
    private String description;
    private int duration;
    private int minPlayers;
    private int maxPlayers;
    private boolean playersMultiple;
    private String status; // active or inactive

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getMinPlayers() { return minPlayers; }
    public void setMinPlayers(int minPlayers) { this.minPlayers = minPlayers; }

    public int getMaxPlayers() { return maxPlayers; }
    public void setMaxPlayers(int maxPlayers) { this.maxPlayers = maxPlayers; }

    public boolean isPlayersMultiple() { return playersMultiple; }
    public void setPlayersMultiple(boolean playersMultiple) { this.playersMultiple = playersMultiple; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
