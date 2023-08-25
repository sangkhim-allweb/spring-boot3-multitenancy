package com.sangkhim.spring_boot3_multitenancy.config.db;

import javax.sql.DataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Getter
@Setter
public class DbConfigDTO {

  private String url;
  private String username;
  private String driver;
  private String password;

  public DataSource createDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }
}
