package com.sangkhim.spring_boot3_multitenancy.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    ServletRequestAttributes attr =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (attr == null) {
      return "en";
    } else {
      String pathInfo = attr.getRequest().getRequestURI();
      return pathInfo.substring(1, 3);
    }
  }
}
