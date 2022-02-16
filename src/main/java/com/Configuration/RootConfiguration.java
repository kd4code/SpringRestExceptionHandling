package com.Configuration;

import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Configuration
//@EnableAspectJAutoProxy
@PropertySource("classpath:hibernate.properties")
@ComponentScans(value = { @ComponentScan("com.DAO"),@ComponentScan("com.ExceptionClasses")})
public class RootConfiguration {
	@Autowired
	 private Environment env;
	

	 @Bean
	 public LocalSessionFactoryBean getSessionFactory() {
	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

	    Properties props = new Properties();

	    // Setting Hibernate properties
	    props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	    props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

	    factoryBean.setHibernateProperties(props);
	    factoryBean.setPackagesToScan("com.Entity");
	    factoryBean.setDataSource(getDataSource());

	    return factoryBean;
	 }

	 @Bean
	 public DataSource getDataSource() {
	     BasicDataSource dataSource = new BasicDataSource();
	     dataSource.setDriverClassName(env.getProperty("mysql.driver"));
	     dataSource.setUrl(env.getProperty("mysql.url"));
	     dataSource.setUsername(env.getProperty("mysql.user"));
	     dataSource.setPassword(env.getProperty("mysql.password"));
	     return dataSource;
	 }
}
