package com.bkersanske.playersalarytool.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 10:07
 */
@Entity
@Table(name="team")
public class Team extends BaseObject {

    /* Team abbreviation */
    @Column
    private String abbreviation;

    /* List of players that play on this team. */
    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team() {
    }

    public Team(String abbreviation) {
        super();
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
