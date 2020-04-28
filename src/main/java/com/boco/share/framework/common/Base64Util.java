package com.boco.share.framework.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
* <p>Title: Base64Util</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月23日
 */
public class Base64Util {
	
	static final Base64.Decoder DECODER = Base64.getDecoder();
	static final Base64.Encoder ENCODER = Base64.getEncoder();
	
	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(byte[] bstr) {
		return Base64.getEncoder().encodeToString(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 * @throws UnsupportedEncodingException 
	 */
	public static String decode(String str) {
		byte[] bt = null;
		String byteToString = null;
		try {
			bt = Base64.getDecoder().decode(str);
			byteToString = new String(bt,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return byteToString;
	}
	
	/**
	 * 解码两次
	 * @param str
	 * @return
	 */
	public static String decodeTwice(String str) {
		return decode(decode(str));
	}


	public static void main(String[] args) throws UnsupportedEncodingException {
		String sss1 = "o6zAJs6jB4WUlC8D7MA-Yy7umZ0c.SGKE8JGe2TgVf371d111ec5e9f382d51aef6a819494d";
		System.out.println(decode(sss1));
		String xxx = encode("文本文件.设施看破按实际 ".getBytes("UTF-8"));
		System.out.println("11111---"+xxx);
		System.out.println("22222----"+decode(xxx));
		
	}
}