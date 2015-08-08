package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:14
 */
@Service
public interface ITeamService {

    public List<Team> retrieveTeams();
}
