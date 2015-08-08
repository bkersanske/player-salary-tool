package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Team;
import com.bkersanske.playersalarytool.repositories.TeamRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:15
 */
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> retrieveTeams() {
        return Lists.newArrayList(teamRepository.findAll());
    }
}
