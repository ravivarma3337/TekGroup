package com.tek.demo.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan("com.tek.demo")
@EnableTransactionManagement
@EnableJpaRepositories("com.tek.demo.Dao")
@PropertySource("classpath:application-dev.properties")
@Profile({"dev"})
public class SpringConfigDev extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment env;
	

	/**
	 * @Bean public InternalResourceViewResolver viewResolver() {
	 *       InternalResourceViewResolver viewResolver = new
	 *       InternalResourceViewResolver();
	 *       viewResolver.setViewClass(JstlView.class);
	 *       viewResolver.setPrefix("/WEB-INF/"); viewResolver.setSuffix(".jsp");
	 *       return viewResolver; }
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ "+env.getProperty("tek.test"));
		dataSource.setDriverClassName(env.getProperty("tek.db.driver"));
		dataSource.setUrl(env.getProperty("tek.db.url"));
		dataSource.setUsername(env.getProperty("tek.db.user"));
		dataSource.setPassword(env.getProperty("tek.db.password"));
		return dataSource;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
		c.enable();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		System.out.println("MysqlJPAConfig jpaVendorAdapter() called");
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		factoryBean.setPackagesToScan("com.tek.demo.model");
		factoryBean.setJpaProperties(jpaProperties());
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		return jpaProperties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
}