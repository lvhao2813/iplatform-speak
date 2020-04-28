package com.boco.share.function.release.bean;

/**
 * 数据包信息
 * 
 * @author xinxiaofei
 *
 */
public class DataSetBean {
	// 表名
	private String tableName;
	// 字段code
	private String code;
	// 字段名称
	private String comments;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
