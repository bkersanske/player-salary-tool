package com.bkersanske.playersalarytool.services;


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

    public void processFileInputStream(InputStream inputStream) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new InputStreamReader(inputStream));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray playerList = (JSONArray)jsonObject.get("playerList");
            Iterator<JSONObject> iterator = playerList.iterator();
            while(iterator.hasNext()) {
                JSONObject jsonPlayer = iterator.next();
                String playerId = (String) jsonPlayer.get("pid");
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
        player.setFirstName((String) jsonPlayer.get("fn"));
        player.setLastName((String) jsonPlayer.get("ln"));
        player.setInjuryStatus((String)jsonPlayer.get("i"));
        player.setPositionName((String)jsonPlayer.get("pn"));
        player.setSalary(((Long)jsonPlayer.get("s")).doubleValue());

        String homeTeamId = (String)jsonPlayer.get("htid");
        Team homeTeam = teamService.retrieveTeam(homeTeamId);
        if(homeTeam == null) {
            homeTeam = addTeam(homeTeamId, (String)jsonPlayer.get("htabbr"));
        }

        String awayTeamId = (String)jsonPlayer.get("atid");
        Team awayTeam = teamService.retrieveTeam(awayTeamId);
        if(awayTeam == null) {
            awayTeam = addTeam(awayTeamId, (String)jsonPlayer.get("atabbr"));
        }

        String playerTeamId = (String)jsonPlayer.get("tid");
        if(playerTeamId.equals(awayTeam.getId())) {
            player.setTeam(awayTeam);
        } else if(playerTeamId.equals(homeTeam.getId())){
            player.setTeam(homeTeam);
        }

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
