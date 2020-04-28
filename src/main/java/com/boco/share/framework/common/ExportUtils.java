package com.boco.share.framework.common;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.boco.share.framework.common.constants.Constant;


/**
 * 文件下载工具类
 * 
 * @author heng
 * 
 */
public class ExportUtils implements Constant {

	public static String mateBrowser(HttpServletRequest request, String filename) throws Exception {
		String finalFileName = null;
		String userAgent = request.getHeader("USER-AGENT");
		// IE浏览器
		if (MSIE.equals(userAgent)) {
			finalFileName = URLEncoder.encode(filename, "UTF8");
			// google,火狐浏览器
		} else if (MOZILLA.equals(userAgent)) {
			finalFileName = new String(filename.getBytes(), "ISO8859-1");
			// 其他浏览器
		} else {
			finalFileName = URLEncoder.encode(filename, "UTF8");
		}
		return finalFileName;
	}

}
