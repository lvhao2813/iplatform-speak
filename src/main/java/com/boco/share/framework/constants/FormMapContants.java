package com.boco.share.framework.constants;

/**
* Title: FormMapContants 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
public interface FormMapContants {
	
	final static String THIRD_QUERY_NAME_YEAR="YEAR";
	
	final static String INVEST_QUERY_NAME_YEAR="planYear";
	
	/**
	 * 是否是年度页签
	 */
	final static String TIME_CODE="Y";
	
	/**
	 * 是否是年度页签
	 */
	final static String SREACH_CODE="code";
	
	/**
	 * excel模板文件夹
	 */
	public static final String MODE_DIR_NAME = "excels";
	
	/**
	 * 资本开支专业维度导出名称
	 */
	public static final String INVEST_SPEC_DOWNLOAD_NAME = "资本开支专业维度";
	
	
	/**
	 * 资本开支专业维度导出模板名称
	 */
	public static final String INVEST_SPEC_MODEL_NAME = "investSpec.xls";
	
	/**
	 * 资本开支专业维度导出字段
	 */
	public static final String[] INVEST_SPEC_FIELDS = new String[] {"TYPE_NAME","PLAN_INVEST","FACT_INVEST",
																	"CURR_RATE","LAST_RATE"};
	
	/**
	 * 资本开支年度维度导出名称
	 */
	public static final String INVEST_YEAR_DOWNLOAD_NAME = "资本开支年度维度";
	
	
	/**
	 * 资本开支年度维度导出模板名称
	 */
	public static final String INVEST_YEAR_MODEL_NAME = "investYear.xls";
	
	/**
	 * 资本开支年度维度导出字段
	 */
	public static final String[] INVEST_YEAR_FIELDS = new String[] {"YEAR","INVEST","MONEY",
																	"RATE"};
	
	/**
	 * 资本开支月度维度导出名称
	 */
	public static final String INVEST_MONTH_DOWNLOAD_NAME = "资本开支月度维度";
	
	
	/**
	 * 资本开支月度维度导出模板名称
	 */
	public static final String INVEST_MONTH_MODEL_NAME = "investMonth.xls";
	
	/**
	 * 资本开支月度维度导出字段
	 */
	public static final String[] INVEST_MONTH_FIELDS = new String[] {"YEAR","1","2","3","4","5","6","7","8","9","10","11","12"};
	
	/**
	 * 资本开支项目经理维度导出名称
	 */
	public static final String INVEST_MANAGER_DOWNLOAD_NAME = "资本开支项目经理维度";
	
	/**
	 * 资本开支项目经理维度导出模板名称
	 */
	public static final String INVEST_MANAGER_MODEL_NAME = "investManager.xls";
	
	/**
	 * 资本开支项目经理维度导出字段
	 */
	public static final String[] INVEST_MANAGER_FIELDS = new String[] {"MANAGER_NAME","PLAN_YEAR","PLAN_INVEST",
																	"FACT_INVEST","RATE"};
	
	/**
	 * 资本开支项目经理维度导出名称
	 */
	public static final String INVEST_MANAGER_MONTH_DOWNLOAD_NAME = "资本开支项目经理月度维度";
	
	/**
	 * 资本开支项目经理维度导出模板名称
	 */
	public static final String INVEST_MANAGER_MONTH_MODEL_NAME = "investManagerMonth.xls";
	
	/**
	 * 资本开支项目经理维度导出字段
	 */
	public static final String[] INVEST_MANAGER_MONTH_FIELDS = new String[] {"consMnagerName","janinvest","febinvest","marinvest","aprinvest","mayinvest","juninvest","julinvest","auginvest","sepinvest","octinvest","novinvest","decinvest"};
	
	
	/**
	 * 资本开支项目经理维度导出名称
	 */
	public static final String INVEST_MANAGER_DETAIL_DOWNLOAD_NAME = "资本开支项目经理明细维度";
	
	/**
	 * 资本开支项目经理维度导出模板名称
	 */
	public static final String INVEST_MANAGER_DETAIL_MODEL_NAME = "investManagerDetail.xls";
	
	/**
	 * 资本开支项目经理维度导出字段
	 */
	public static final String[] INVEST_MANAGER_DETAIL_FIELDS = new String[] {"proCode","proName","consType","capType",
																				"orgName","feaInvest","totalInvest", "mislast",
																				"miscur","proInvest","proCfInvest","proAfInvest",
																				"comRate","toAndFeaX","specName","managerName",
																				"consManagerName","january",
																				"february","march","april","may","june",
																				"july","august","september","october","november",
																				"december","janinvest","febinvest","marinvest",
																				"aprinvest","mayinvest","juninvest","julinvest",
																				"auginvest","sepinvest","octinvest","novinvest",
																				"decinvest"};
	
}
