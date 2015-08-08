package com.bkersanske.playersalarytool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author bkersanske
 * @since 08/08/15 13:42
 */
public class PlayerSalaryToolRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new PlayerSalaryToolRepositoryFactory<T, I>(entityManager);
    }

    private static class PlayerSalaryToolRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

        private EntityManager entityManager;

        public PlayerSalaryToolRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected Object getTargetRepository(RepositoryMetadata metadata) {
            return new PlayerSalaryToolRepositoryImpl<T, I>((Class<T>) metadata.getDomainType(), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return PlayerSalaryToolRepository.class;
        }
    }
}
