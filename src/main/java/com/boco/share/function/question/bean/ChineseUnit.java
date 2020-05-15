/**
 * 
 */
package com.boco.share.function.question.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xp
 *
 */
@ApiModel(value = "汉字工具", description = "汉字工具表")
public class ChineseUnit {
	
	@ApiModelProperty(value ="主键id")
	private String id;
	
	@ApiModelProperty(value ="明细id")
	private int questionsDetailId;
	
	@ApiModelProperty(value ="汉字id")
	private String chineseId;
	
	@ApiModelProperty(value ="汉字排序")
	private int ord;
	
}
