/**
 * 
 */
package com.boco.share.function.question.bean.exam;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xp
 *
 */
@ApiModel(value = "测试对象", description = "测试对象")
public class Exam implements Serializable {
	private static final long serialVersionUID = -6897762659657847800L;

	@ApiModelProperty(value = "测试id")
	private String id;
	
	@ApiModelProperty(value = "测试名称")
	private String name;
	
	@ApiModelProperty(value = "单字练习id")
	private String singlewordId;
		
	@ApiModelProperty(value = "多字练习id")
	private String multiwordId;
	
	@ApiModelProperty(value = "短文练习id")
	private String essayId;
	
	@ApiModelProperty(value = "命题练习id")
	private String topicId;

	@ApiModelProperty(value = "创建时间")
	private String createDate;
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinglewordId() {
		return singlewordId;
	}

	public void setSinglewordId(String singlewordId) {
		this.singlewordId = singlewordId;
	}

	public String getMultiwordId() {
		return multiwordId;
	}

	public void setMultiwordId(String multiwordId) {
		this.multiwordId = multiwordId;
	}

	public String getEssayId() {
		return essayId;
	}

	public void setEssayId(String essayId) {
		this.essayId = essayId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
}
