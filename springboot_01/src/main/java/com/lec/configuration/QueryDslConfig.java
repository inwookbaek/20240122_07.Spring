package com.lec.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import jakarta.persistence.EntityManager;

@Configuration
public class QueryDslConfig {

    @Autowired private EntityManager em;
    @Bean
    public JpaRepositoryFactory jpaQueryFactory(){
        return new JpaRepositoryFactory(em);
    }
}
