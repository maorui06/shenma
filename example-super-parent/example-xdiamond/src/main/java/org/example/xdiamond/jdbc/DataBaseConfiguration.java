package org.example.xdiamond.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
@Configuration
@ConfigurationProperties("spring.datasource")
public class DataBaseConfiguration extends DruidDataSourceConfig implements TransactionManagementConfigurer{
	private static final long serialVersionUID = 1L;

	@Bean(name = "dataSource")
	@Primary
	DataSource dataSource() {
		return this;
	}

	@Bean(name = "jdbcTemplate")
	@Primary
	public JdbcTemplate jdbcTemplate(DataSource dsItems) {
		return new JdbcTemplate(dsItems);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}