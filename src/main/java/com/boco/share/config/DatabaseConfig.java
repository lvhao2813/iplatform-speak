package com.boco.share.config;

import java.util.Properties;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Bean
	public DatabaseIdProvider getDatabaseIdProvider() {
		DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
		Properties p = new Properties();
		p.setProperty("Oracle", "oracle");
		p.setProperty("MySQL", "mysql");
		p.setProperty("PostgreSQL", "postgresql");
		p.setProperty("DB2", "db2");
		p.setProperty("SQL Server", "sqlserver");
		databaseIdProvider.setProperties(p);
		return databaseIdProvider;
	}

}
