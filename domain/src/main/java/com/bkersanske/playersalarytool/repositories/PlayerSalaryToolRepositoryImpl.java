package com.bkersanske.playersalarytool.repositories;

import com.bkersanske.playersalarytool.domain.IDomainObject;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Date;

/**
 * @author bkersanske
 * @since 08/08/15 13:45
 */
public class PlayerSalaryToolRepositoryImpl<T, K extends Serializable> extends SimpleJpaRepository<T, K> implements PlayerSalaryToolRepository<T, K> {

    public PlayerSalaryToolRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }

    @Transactional
    public <S extends T> S save(S entity) {
        if (entity instanceof IDomainObject) {
            IDomainObject obj = (IDomainObject) entity;
            obj.prepareForWrite();
            obj.validate();
            obj.setUpdated(new Date());
        }
        return super.save(entity);
    }
}