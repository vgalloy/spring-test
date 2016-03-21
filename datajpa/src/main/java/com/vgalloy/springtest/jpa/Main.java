package com.vgalloy.springtest.jpa;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vgalloy.springtest.jpa.entity.User;
import com.vgalloy.springtest.jpa.repository.UserRepository;

/**
 * Created by Vincent Galloy on 21/03/16.
 */
@Component
@ComponentScan
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.vgalloy.springtest.jpa")
public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		User user = new User("my name");
		userRepository.save(user);
		System.out.println(user);
		System.out.println(userRepository.findAll());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setDataSource(dataSource());
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}

	 @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);

      return transactionManager;
   }
}
