package com.yoursite.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.eclipse.persistence.platform.database.DatabasePlatform;
import org.eclipse.persistence.platform.database.MySQLPlatform;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * Class which includes database related configuration and bean creation
 * @author Hemrajsinh Gharia
 *
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages={"com.yoursite.repository"}, entityManagerFactoryRef = "em")
@EnableLoadTimeWeaving
public class DBConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${eclipselink.persistenceUnitName}")
	private String persistenceUnitName;

	private static org.apache.log4j.Logger log = Logger.getLogger(DBConfig.class);
	
	@Bean()
	public DataSource getDataSource() {
		BoneCPDataSource ds = new BoneCPDataSource();
		log.debug("Driver Name : " + driverClassName);
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("DB Url : " + url);
		ds.setDriverClass(driverClassName);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxConnectionsPerPartition(5);
		ds.setMinConnectionsPerPartition(2);
		ds.setAcquireIncrement(2);		
		return ds;
	}

	@Bean(name = "em")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());		
		em.setJpaDialect(jpaDialect());
		em.setPackagesToScan("com.yoursite.model");
		em.setPersistenceUnitName(persistenceUnitName);
		DatabasePlatform dp = new MySQLPlatform();
		em.setJpaVendorAdapter(getEclipseLinkJpaVendorAdapter());
		
		//following code will be used for static weaving. Uncomment when creating war.
		/*Map <String, String> propMap = new HashMap<String, String>();
		propMap.put("eclipselink.weaving", "static");
		em.setJpaPropertyMap(propMap);*/
				
		em.setLoadTimeWeaver(loadTimeWeaver()); //comment this when using static weaving. Mostly in development environment inside eclipse
		return em;
	}

	@Bean
	public EclipseLinkJpaVendorAdapter getEclipseLinkJpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform");
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}

	@Bean()
	public LoadTimeWeaver loadTimeWeaver() {
	    return new org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public JpaDialect jpaDialect() {
		return new EclipseLinkJpaDialect();
	}
}
