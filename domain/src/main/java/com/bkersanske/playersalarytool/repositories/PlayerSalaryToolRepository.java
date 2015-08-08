package com.bkersanske.playersalarytool.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author bkersanske
 * @since 08/08/15 11:40
 */
@NoRepositoryBean
public interface PlayerSalaryToolRepository<T, PK extends Serializable> extends CrudRepository<T, PK>, JpaSpecificationExecutor<T> {
}
