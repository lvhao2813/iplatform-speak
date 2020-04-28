package com.boco.share.framework.common;

import java.security.InvalidKeyException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.boco.share.framework.common.constants.Constant;

/**
 * 
 * @author zhy
 *
 */
public class CipherUtil implements Constant{
	private static String key = "EPMS2018";
	

	public static String encode(String str) {
		byte[] signedMsg = str.getBytes();
		String algorithm = "DES";
		try {
			byte[] buffer = key.getBytes();
			Cipher c = Cipher.getInstance(algorithm);
			DESKeySpec dks = new DESKeySpec(buffer);
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance(algorithm);
			SecretKey deskey = keyFactory.generateSecret(dks);
			c.init(1, deskey);
			byte[] cipherByte = c.doFinal(signedMsg);

			StringBuilder baseE64 = new StringBuilder(Base64.getEncoder().encodeToString(cipherByte));

			if (baseE64.toString().indexOf(PLUS) != -1) {
				for (int i = 0; i < baseE64.length(); i++) {
					if (baseE64.charAt(i) == PLUS) {
						String str1 = baseE64.substring(0, i);
						baseE64 = new StringBuilder(str1).append(MINUS_SIGN).append(baseE64.substring(i + 1, baseE64.length()));
					}
				}
			}
			return baseE64.toString();
		} catch (InvalidKeyException ex1) {
			ex1.printStackTrace();
			return null;
		} catch (ClassCastException ex) {
			ex.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加密失败");
		}
		return null;
	}

	public static String decode(String encriptedMsg) {
		String algorithm = "DES";
		StringBuilder sb = new StringBuilder(encriptedMsg);
		try {
			if (sb.toString().indexOf(MINUS_SIGN) != -1) {
				for (int i = 0; i < sb.length(); i++) {
					if (sb.charAt(i) == MINUS_SIGN) {
						String tmpStr = sb.substring(0, i);
						sb = new StringBuilder(tmpStr).append(PLUS).append(encriptedMsg.substring(i + 1,encriptedMsg.length()));
					}
				}
			}

			byte[] baseD64 = Base64.getDecoder().decode(sb.toString());

			byte[] buffer = key.getBytes();
			Cipher c = Cipher.getInstance(algorithm);
			DESKeySpec dks = new DESKeySpec(buffer);
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance(algorithm);
			SecretKey deskey = keyFactory.generateSecret(dks);
			c.init(2, deskey);
			byte[] clearByte = c.doFinal(baseD64);

			return new String(clearByte);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("解密失败");
		}
		return null;
	}

	public static void main(String[] args) {
		String token = "wujianbo";
		String t = CipherUtil.encode(token);
		System.out.println(t);
		System.out.println(CipherUtil.decode(t));
	}
}