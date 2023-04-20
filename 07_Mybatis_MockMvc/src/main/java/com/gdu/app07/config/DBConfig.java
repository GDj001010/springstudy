package com.gdu.app07.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@PropertySource(value={"classpath:application.properties"})		// properties 파일좀 읽어와라, application.properties 파일의 속성을 읽어 오자!
@EnableTransactionManagement	// transaction을 허용한다.
@Configuration
public class DBConfig {
	
		
	@Autowired
	private Environment env;	// 환경 ?
	// HikariConfig Bean 를 먼저 만들어줘야한다.
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
		hikariConfig.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
		hikariConfig.setUsername(env.getProperty("spring.datasource.hikari.username"));
		hikariConfig.setPassword(env.getProperty("spring.datasource.hikari.password"));
		return hikariConfig;
	}
	
	// DriverManagerDataSource 가 있었지만 Hikari가 대신 해준다. DataSource = connectionPool 해주는 아이.
	// DriverManagerDataSource 대신 HikariDataSource Bean을 만들어준다.
	@Bean(destroyMethod="close") // hikari 사용방법
	public HikariDataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	
	// SqlSessionFactory Bean	구글링 해보기
	@Bean
	public SqlSessionFactory factory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.config-location")));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis.mapper-locations"));
		return bean.getObject(); // factory bean에서 object 꺼내면 팩토리가 만들어진다.
	}
	
	
	// SqlSessionTemplate Bean	(기존의 SqlSession)
	@Bean
	public SqlSessionTemplate template() throws Exception {
		return new SqlSessionTemplate(factory());
	}
	
	
	// TransactionManager Bean
	@Bean
	public TransactionManager transactionManager () {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	
	
	
	
	
	
	
	
}
