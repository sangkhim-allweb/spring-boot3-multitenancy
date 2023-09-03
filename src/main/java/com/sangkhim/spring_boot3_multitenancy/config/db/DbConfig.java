package com.sangkhim.spring_boot3_multitenancy.config.db;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DbConfigProperty.class)
@RequiredArgsConstructor
public class DbConfig {

  private final DbConfigProperty dbConfigProperty;

  @Bean
  public DataSource dataSource() {
    CustomRoutingDataSource dataSource = new CustomRoutingDataSource();
    dataSource.setTargetDataSources(dbConfigProperty.createTargetDataSources());
    return dataSource;
  }
}
