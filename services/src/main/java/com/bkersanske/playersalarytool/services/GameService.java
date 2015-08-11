package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Game;
import com.bkersanske.playersalarytool.domain.Team;
import com.bkersanske.playersalarytool.repositories.GameRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkersanske
 * @since 11/08/15 09:16
 */
@Service
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> retrieveGames() {
        return Lists.newArrayList(gameRepository.findAll());
    }

    @Override
    public Game retrieveGame(String id) {
        return gameRepository.findOne(id);
    }

    @Override
    public void addGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public List<Game> retrieveGamesByHomeTeamAndAwayTeam(Team homeTeam, Team awayTeam) {
        return gameRepository.findByHomeTeamAndAwayTeam(homeTeam, awayTeam);
    }

}
