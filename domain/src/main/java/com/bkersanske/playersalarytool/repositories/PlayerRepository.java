package com.bkersanske.playersalarytool.repositories;

import com.bkersanske.playersalarytool.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bkersanske
 * @since 08/08/15 10:13
 */
@Repository
public interface PlayerRepository extends PlayerSalaryToolRepository<Player, String> {

}
