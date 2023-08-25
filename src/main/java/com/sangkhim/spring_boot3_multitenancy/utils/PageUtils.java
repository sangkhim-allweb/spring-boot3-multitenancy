package com.sangkhim.spring_boot3_multitenancy.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUtils {

  public static Pageable pageable(Pageable pageable) {
    return pageable.isPaged() ? pageable : Pageable.unpaged();
  }
}
