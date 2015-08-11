package com.bkersanske.playersalarytool.services;


import com.bkersanske.playersalarytool.domain.Game;
import com.bkersanske.playersalarytool.domain.Player;
import com.bkersanske.playersalarytool.domain.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * @author bkersanske
 * @since 09/08/15 19:52
 */
@Service
public class UploadService implements IUploadService {

    @Autowired
    private ITeamService teamService;

    @Autowired
    private IPlayerService playerService;

    @Autowired
    private IGameService gameService;

    public void processFileInputStream(InputStream inputStream) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new InputStreamReader(inputStream));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray playerList = (JSONArray)jsonObject.get("playerList");
            Iterator<JSONObject> iterator = playerList.iterator();
            while(iterator.hasNext()) {
                JSONObject jsonPlayer = iterator.next();
                String playerId = ((Long) jsonPlayer.get("pid")).toString();
                if(playerService.retrievePlayer(playerId) == null) {
                    addPlayerFromJSON(jsonPlayer);
                    System.out.println("Added player with id " + playerId + " to the database.");
                } else {
                    System.out.println("Player with id " + playerId + " already exists in database.");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void addPlayerFromJSON(JSONObject jsonPlayer) {

        Player player = new Player();
        player.setId(((Long) jsonPlayer.get("pid")).toString());
        player.setFirstName((String) jsonPlayer.get("fn"));
        player.setLastName((String) jsonPlayer.get("ln"));
        player.setInjuryStatus((String)jsonPlayer.get("i"));
        player.setPositionName((String)jsonPlayer.get("pn"));
        player.setSalary(((Long)jsonPlayer.get("s")).doubleValue());
        player.setDisabledFromDrafting((Boolean)jsonPlayer.get("IsDisabledFromDrafting"));

        String homeTeamId = ((Long)jsonPlayer.get("htid")).toString();
        Team homeTeam = teamService.retrieveTeam(homeTeamId);
        if(homeTeam == null) {
            homeTeam = addTeam(homeTeamId, (String)jsonPlayer.get("htabbr"));
        }

        String awayTeamId = ((Long)jsonPlayer.get("atid")).toString();
        Team awayTeam = teamService.retrieveTeam(awayTeamId);
        if(awayTeam == null) {
            awayTeam = addTeam(awayTeamId, (String)jsonPlayer.get("atabbr"));
        }

        String playerTeamId = ((Long)jsonPlayer.get("tid")).toString();
        if(playerTeamId.equals(awayTeam.getId())) {
            player.setTeam(awayTeam);
        } else if(playerTeamId.equals(homeTeam.getId())){
            player.setTeam(homeTeam);
        }

        List<Game> games = gameService.retrieveGamesByHomeTeamAndAwayTeam(homeTeam, awayTeam);
        if(games == null || games.size() == 0) {
            Game game = new Game();
            game.setHomeTeam(homeTeam);
            game.setAwayTeam(awayTeam);
            gameService.addGame(game);
        }

        player.setNextGame(gameService.retrieveGamesByHomeTeamAndAwayTeam(homeTeam, awayTeam).get(0));
        playerService.addPlayer(player);
    }

    private Team addTeam(String teamId, String abbreviation) {
        Team team = new Team();
        team.setId(teamId);
        team.setAbbreviation(abbreviation);
        teamService.addTeam(team);
        return team;
    }

}
