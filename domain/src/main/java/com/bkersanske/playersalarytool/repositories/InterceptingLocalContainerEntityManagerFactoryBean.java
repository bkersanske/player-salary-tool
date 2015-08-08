package com.bkersanske.playersalarytool.repositories;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author bkersanske
 * @since 08/08/15 13:47
 */
public class InterceptingLocalContainerEntityManagerFactoryBean extends LocalContainerEntityManagerFactoryBean {

    private static final long serialVersionUID = 1L;

    public void setInterceptor(String className) {
        getJpaPropertyMap().put("hibernate.ejb.interceptor", className);
    }
}