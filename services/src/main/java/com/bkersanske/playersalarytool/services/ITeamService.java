package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Team;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:14
 */
public interface ITeamService {

    public List<Team> retrieveTeams();
}
