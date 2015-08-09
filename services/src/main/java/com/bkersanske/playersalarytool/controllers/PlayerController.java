package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.domain.Player;
import com.bkersanske.playersalarytool.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

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
    public List<Player> getPlayers() {
        return playerService.retrievePlayers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable("id") String id) {
        return playerService.retrievePlayer(id);
    }

}