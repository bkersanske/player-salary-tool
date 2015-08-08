package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.domain.Player;
import com.bkersanske.playersalarytool.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}