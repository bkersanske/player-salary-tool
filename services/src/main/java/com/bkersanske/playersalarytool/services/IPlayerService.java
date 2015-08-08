package com.bkersanske.playersalarytool.services;

import com.bkersanske.playersalarytool.domain.Player;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkersanske
 * @since 08/08/15 12:10
 */
@Service
public interface IPlayerService {

    public List<Player> retrievePlayers();

}
