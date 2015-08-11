package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.domain.Game;
import com.bkersanske.playersalarytool.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bkersanske
 * @since 11/08/15 09:41
 */
@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private IGameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getGames() {
        return gameService.retrieveGames();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Game getGame(@PathVariable("id") String id) {
        return gameService.retrieveGame(id);
    }
}
