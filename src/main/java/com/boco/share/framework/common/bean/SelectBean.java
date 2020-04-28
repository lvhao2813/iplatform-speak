package com.boco.share.framework.common.bean;

import java.io.Serializable;

/**
 * 下拉列表统一实体类
 * @author heng
 *
 */
public class SelectBean implements Serializable{


	/** serialVersionUID*/  
	private static final long serialVersionUID = 4688043039344019322L;

	/**
	 * id
	 */
	private String id;
	
	/**
	 * 内容
	 */
	private String text;

	
	public SelectBean() {
	}
	
	public SelectBean(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
