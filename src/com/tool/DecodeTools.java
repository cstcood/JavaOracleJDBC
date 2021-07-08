package com.tool;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


/**
 * @author 16409
 */
public interface DecodeTools {

  /**
   * get the MD5 of original string
   *
   * @param str the init string of decode forwarded
   * @return String
   */
  static String getMd5Str(String str) {
    byte[] digest = null;
    try {
      MessageDigest md5 = MessageDigest.getInstance("md5");
      digest = md5.digest(str.getBytes(StandardCharsets.UTF_8));
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (digest != null) {
      return byte2HexStr(digest);
    }
    return null;
  }


  /**
   * Convert Bin to HEX
   *
   * @param buf the array of input bin
   * @return String
   */
  static String byte2HexStr(byte[] buf) {
    StringBuilder sBuffer = new StringBuilder();
    for (byte b : buf) {
      final int lowBit = 0xff;
      String hex = Integer.toHexString(b & lowBit);
      if (hex.length() == 1) {
        hex = '0' + hex;
      }
      sBuffer.append(hex.toUpperCase());
    }
    return sBuffer.toString();
  }
}
