package com.sangkhim.spring_boot3_multitenancy.config.db;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableConfigurationProperties(DbConfigProp.class)
@RequiredArgsConstructor
public class DbConfig {

  private final DbConfigProp dbConfigProp;

  @Bean
  public DataSource dataSource() {
    CustomRoutingDataSource dataSource = new CustomRoutingDataSource();
    dataSource.setTargetDataSources(dbConfigProp.createTargetDataSources());
    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }
}
