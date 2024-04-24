package com.reservationSystem.infrastructure.config;

import com.reservationSystem.domain.model.valueobject.ValueObject;
import com.reservationSystem.domain.model.valueobject.ValueObjectTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeHandlers(new ValueObjectTypeHandler<>(ValueObject.class));
        return factoryBean.getObject();
    }
}