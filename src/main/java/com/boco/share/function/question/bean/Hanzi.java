/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用于给前台选择多音字的临时类
 * @author xp
 *
 */
@ApiModel(value = "汉字对象", description = "汉字对象")
public class Hanzi implements Serializable{
	@ApiModelProperty(value = "汉字UID")	
	private static final long serialVersionUID = 66532321132501L;
	
	@ApiModelProperty(value = "汉字字符")
	private char chinese;

	@ApiModelProperty(value = "拼音字符串数组")
	private String[] pinyin;

	@ApiModelProperty(value = "最后选择的读音")
	private int choose; //最后用户确定的读音
	
	public int getChoose() {
		return choose;
	}

	public Hanzi(char chinese, String[] pinyin) {
		this.chinese = chinese;
		this.pinyin = pinyin;
		if(pinyin.length==1) {
			this.choose=0;
		}
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}


	public char getChinese() {
		return chinese;
	}

	public void setChinese(char chinese) {
		this.chinese = chinese;
	}

	public String[] getPinyin() {
		return pinyin;
	}

	public void setPinyin(String[] pinyin) {
		this.pinyin = pinyin;
	}
	
	
}
