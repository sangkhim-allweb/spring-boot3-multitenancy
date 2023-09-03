package com.sangkhim.spring_boot3_multitenancy.config.db;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "db")
public class DbConfigProperty {

  private Map<String, DbConfigDataSource> configurations = new HashMap<>();

  public Map<Object, Object> createTargetDataSources() {
    Map<Object, Object> result = new HashMap<>();
    configurations.forEach((key, value) -> result.put(key, value.createDataSource()));
    return result;
  }
}
