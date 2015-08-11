package com.bkersanske.playersalarytool.repositories;

import com.bkersanske.playersalarytool.domain.Game;
import com.bkersanske.playersalarytool.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bkersanske
 * @since 11/08/15 08:56
 */
@Repository
public interface GameRepository extends PlayerSalaryToolRepository<Game, String> {

    List<Game> findByHomeTeam(Team homeTeam);

    List<Game> findByAwayTeam(Team awayTeam);

    List<Game> findByHomeTeamAndAwayTeam(Team homeTeam, Team awayTeam);

}
