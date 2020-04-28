package com.boco.share.privilege.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>Title: EvalController</p>  
* <p>Description: 展示Session信息 </p>  
* @author RayLLi  
* @date 2018年5月4日
 */
@RestController
@RequestMapping("/")
public class EvalController {
	
	@RequestMapping("eval")
	public String eval(HttpSession session) {
		StringBuffer infomation = new StringBuffer();
        Enumeration<String> en = session.getAttributeNames();
        while(en.hasMoreElements()) {
        	String name = (String)en.nextElement();
        	infomation.append("<br>\nname:"+name);
        	infomation.append("\nvalue:"+session.getAttribute(name));
        }
		
		return infomation.toString() ;
	}

}
