package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Player;
import com.bkersanske.playersalarytool.repositories.PlayerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:11
 */
@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> retrievePlayers() {
        return Lists.newArrayList(playerRepository.findAll());
    }

}
