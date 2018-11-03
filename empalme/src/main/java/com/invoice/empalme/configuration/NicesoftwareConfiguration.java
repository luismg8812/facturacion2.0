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
    basePackages = "com.invoice.empalme.dao.nicesoftware", 
    entityManagerFactoryRef = "nicesoftwareEntityManager", 
    transactionManagerRef = "userTransactionManager"
)
public class NicesoftwareConfiguration {
	
	@Autowired
    private Environment env;

	@Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean nicesoftwareEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(nicesoftwareDataSource());
        em.setPackagesToScan(
          new String[] { "com.invoice.empalme.model.nicesoftware" });
 
        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        //properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",env.getProperty("spring.datasourcenicenoftware.database-platform"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
	    
	  @Primary
	    @Bean
	    public DataSource nicesoftwareDataSource() {
	  
	        DriverManagerDataSource dataSource
	          = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("spring.datasourcenicenoftware.driver-class-name"));
	        dataSource.setUrl(env.getProperty("spring.datasourcenicenoftware.url"));
	        dataSource.setUsername(env.getProperty("spring.datasourcenicenoftware.username"));
	        dataSource.setPassword(env.getProperty("spring.datasourcenicenoftware.password"));
	        System.out.println("usuario:"+ dataSource.getUsername());
	        return dataSource;
	    }
	 
	    @Primary
	    @Bean
	    public PlatformTransactionManager userTransactionManager() {
	  
	        JpaTransactionManager transactionManager
	          = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	          nicesoftwareEntityManager().getObject());
	        return transactionManager;
	    }
	
	
}
