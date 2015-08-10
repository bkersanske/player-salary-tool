package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Team;
import com.bkersanske.playersalarytool.repositories.TeamRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:15
 */
@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> retrieveTeams() {
        return Lists.newArrayList(teamRepository.findAll());
    }

    @Override
    public Team retrieveTeam(String teamId) {
        return teamRepository.findOne(teamId);
    }

    @Override
    public void addTeam(Team team) {
        teamRepository.save(team);
    }
}
