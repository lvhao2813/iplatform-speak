package com.boco.share.function.release.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 发布接口 信息对象
 * 
 * @author lv
 *
 */
public class ReleaseDataBean implements Serializable {
	private String id;
	// 数据包的表名
	private String dataSetTableName;
	// 发布接口的名称
	private String name;
	// url类型
	private String urlType;
	// 请求类型
	private String requestType;
	// 操作人
	private String operator;
	// 发布时间
	private String releaseDate;
	// 数据包名称
	private String dataSetName;
	// 发布url
	private String url;
	// token验证
	private String token;

	private List<ReleaseDetailBean> details = new ArrayList<ReleaseDetailBean>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataSetTableName() {
		return dataSetTableName;
	}

	public void setDataSetTableName(String dataSetTableName) {
		this.dataSetTableName = dataSetTableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDataSetName() {
		return dataSetName;
	}

	public void setDataSetName(String dataSetName) {
		this.dataSetName = dataSetName;
	}

	public List<ReleaseDetailBean> getDetails() {
		return details;
	}

	public void setDetails(List<ReleaseDetailBean> details) {
		this.details = details;
	}

}
