package com.invoice.empalme.configuration;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
    basePackages = "com.invoice.empalme.dao.invoice", 
    entityManagerFactoryRef = "invoiceEntityManager", 
    transactionManagerRef = "invoiceTransactionManager"
)
public class InvoiceConfiguration {
	
	@Autowired
    private Environment env;

	@Bean
    public LocalContainerEntityManagerFactoryBean invoiceEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(invoiceDataSource());
        em.setPackagesToScan(
          new String[] { "com.invoice.empalme.model.invoice" });
 
        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults",env.getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
	    
	  
	    @Bean
	    public DataSource invoiceDataSource() {
	  
	        DriverManagerDataSource dataSource
	          = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	        dataSource.setUrl(env.getProperty("spring.datasource.url"));
	        dataSource.setUsername(env.getProperty("spring.datasource.username"));
	        dataSource.setPassword(env.getProperty("spring.datasource.password"));
	        System.out.println("usuario:"+ dataSource.getUsername());
	        return dataSource;
	    }
	 
	    
	    @Bean
	    public PlatformTransactionManager invoiceTransactionManager() {
	  
	        JpaTransactionManager transactionManager
	          = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	          invoiceEntityManager().getObject());
	        return transactionManager;
	    }
	
	
}
