/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lv
 *
 */
public class QuestionDetail implements Serializable {

	private static final long serialVersionUID = -8137613244791817364L;

	private String id;

	private String word;

	private List<Chinese> chineseUnit = new ArrayList<Chinese>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<Chinese> getChineseUnit() {
		return chineseUnit;
	}

	public void setChineseUnit(List<Chinese> chineseUnit) {
		this.chineseUnit = chineseUnit;
	}

}
