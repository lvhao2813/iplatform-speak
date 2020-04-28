package com.boco.share.framework.common;

import java.util.UUID;

public class UuidUtil {

  public static String genUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
