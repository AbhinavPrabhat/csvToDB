package com.abhinav.ipldashboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Serializer;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="ipl_data")
public class MatchModel {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "City")
    private String city;
    @Column(name = "Date")
    private String date;
    @Column(name = "Season")
    private String season;
    @Column(name = "Team1")
    private String team1;
    @Column(name = "Team2")
    private String team2;
    @Column(name = "Venue")
    private String venue;
    @Column(name = "TossWinner")
    private String tossWinner;
    @Column(name = "TossDecision")
    private String tossDecision;
    @Column(name = "SuperOver")
    private String superOver;
    @Column(name = "WinningTeam")
    private String winningTeam;
    @Column(name = "WonBy")
    private String wonBy;
    @Column(name = "Margin")
    private String margin;
    @Column(name = "Player_of_Match")
    private String playerOfMatch;
    @Column(name = "Umpire1")
    private String umpire1;
    @Column(name = "Umpire2")
    private String umpire2;

    public MatchModel(String id, String city, String date, String season, String team1, String team2, String venue, String tossWinner, String tossDecision, String superOver, String winningTeam, String wonBy, String margin, String playerOfMatch, String umpire1, String umpire2) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.season = season;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.superOver = superOver;
        this.winningTeam = winningTeam;
        this.wonBy = wonBy;
        this.margin = margin;
        this.playerOfMatch = playerOfMatch;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
    }

    @Override
    public String toString() {
        return "MatchModel{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", season='" + season + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", venue='" + venue + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                ", superOver='" + superOver + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", wonBy='" + wonBy + '\'' +
                ", margin='" + margin + '\'' +
                ", playerOfMatch='" + playerOfMatch + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getSuperOver() {
        return superOver;
    }

    public void setSuperOver(String superOver) {
        this.superOver = superOver;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getWonBy() {
        return wonBy;
    }

    public void setWonBy(String wonBy) {
        this.wonBy = wonBy;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }
}
