package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Player;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:10
 */
public interface IPlayerService {

    public List<Player> retrievePlayers();

}
