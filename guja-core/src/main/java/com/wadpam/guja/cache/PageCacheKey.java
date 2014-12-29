package com.wadpam.guja.cache;

import java.io.Serializable;

/**
 * Created by sosandstrom on 2014-12-21.
 */
public class PageCacheKey implements Serializable, Comparable<PageCacheKey> {
  public final Integer pageSize;
  public final String cursorKey;

  public PageCacheKey(Integer pageSize, String cursorKey) {
    this.pageSize = pageSize;
    this.cursorKey = cursorKey;
  }

  @Override
  public int compareTo(PageCacheKey other) {
    int returnValue = this.pageSize.compareTo(other.pageSize);
    if (0 != returnValue) {
      return returnValue;
    }
    if (null == this.cursorKey) {
      return null == other.cursorKey ? 0 : 1;
    }
    return this.cursorKey.compareTo(other.cursorKey);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PageCacheKey)) {
      return false;
    }
    return 0 == compareTo((PageCacheKey) o);
  }

  @Override
  public int hashCode() {
    return 31 * pageSize.hashCode() + (null != cursorKey ? cursorKey.hashCode() : 0);
  }
}
