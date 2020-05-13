/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;

/**
 * @author LOVE
 *
 */
public class Chinese implements Serializable{
	private static final long serialVersionUID = 6654351202494111501L;

	private String id;

	private String chinese;

	private String pinyin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

}
