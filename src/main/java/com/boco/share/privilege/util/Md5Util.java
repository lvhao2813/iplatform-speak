package com.boco.share.privilege.util;

/**
 * <p>Title: MD5加密算法(推荐)</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author 欧阳春
 * @version 1.0
 */
 

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 

//import java.math.*;
 
public class Md5Util {
    public static final String MD5 = "MD5";
 
    /**
     * 提供md5加密
     *
     * @param sInput
     * @return 返回md5加密字符串
     */
    public static String encode(String sInput) {
 
        // String algorithm = "";
        //输入不能为空
        if (sInput == null) {
            return "null";
        }
        StringBuffer hs = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(Md5Util.MD5);
 
            //按照系统缺省的字符编码方式把sInput 转换成字节，并把结果存到一新的字节数组buffer中
            //byte buffer[] = sInput.getBytes();
            md.update(sInput.getBytes());
            byte buffer[] = md.digest();
            String stmp = "";
 
            for (int n = 0; n < buffer.length; n++) {
                stmp = Integer.toHexString(buffer[n] & 0xff);
                if (stmp.length() == 1) {
                	hs.append("0").append(stmp);
				} else {
					hs.append(stmp);
				}
            }
        } catch (NoSuchAlgorithmException e) {
          
        }
        return hs.toString().toUpperCase();
 
    }
}

