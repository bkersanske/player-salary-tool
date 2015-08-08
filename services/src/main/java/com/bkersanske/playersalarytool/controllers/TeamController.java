package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.domain.Team;
import com.bkersanske.playersalarytool.services.ITeamService;
import com.bkersanske.playersalarytool.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 10:37
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private ITeamService teamService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Team> getTeams() {
        return teamService.retrieveTeams();
    }
}
