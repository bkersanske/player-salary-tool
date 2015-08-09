package com.bkersanske.playersalarytool.domain;

import javax.persistence.*;

/**
 * @author bkersanske
 * @since 08/08/15 10:03
 */
@Entity
@Table(name = "player")
public class Player extends BaseObject {

    /* Player's first name */
    @Column(name = "first_name")
    private String firstName;

    /* Player's last name */
    @Column(name = "last_name")
    private String lastName;

    /* Player's position name */
    @Column(name = "position_name")
    private String positionName;

    /* Injury statuses if any. */
    @Column(name = "injury_status")
    private String injuryStatus;

    /* Player salary */
    @Column(name = "salary")
    private Double salary;

    /* Team the player plays for. */
    @OneToOne
    @JoinColumn(name = "team_id", nullable = true)
    private Team team;

    public Player() {
    }

    public Player(String firstName, String lastName, String positionName, String injuryStatus, Double salary, Team team) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionName = positionName;
        this.injuryStatus = injuryStatus;
        this.salary = salary;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
