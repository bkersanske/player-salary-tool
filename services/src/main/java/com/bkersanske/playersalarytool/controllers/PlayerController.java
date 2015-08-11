package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.controllers.dto.PlayerDTO;
import com.bkersanske.playersalarytool.domain.Player;
import com.bkersanske.playersalarytool.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 09:54
 */
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PlayerDTO> getPlayers() {
        List<Player> players = playerService.retrievePlayers();
        List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();
        for(Player player : players) {
            playerDTOs.add(new PlayerDTO(player));
        }
        return playerDTOs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PlayerDTO getPlayer(@PathVariable("id") String id) {
        Player player = playerService.retrievePlayer(id);
        if(player != null) {
            return new PlayerDTO(player);
        }
        return null;
    }

}