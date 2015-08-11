package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Game;
import com.bkersanske.playersalarytool.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkersanske
 * @since 11/08/15 09:15
 */
@Service
public interface IGameService {

    public List<Game> retrieveGames();

    public Game retrieveGame(String id);

    public void addGame(Game game);

    public List<Game> retrieveGamesByHomeTeamAndAwayTeam(Team homeTeam, Team awayTeam);
}
