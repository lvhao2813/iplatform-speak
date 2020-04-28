package com.boco.share.framework.pagination;

/**
* Title: Pagination 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
public class Pagination {

	/**
	 *  每页多少条记录
	 */
	private int pageCount;

	/**
	 *  共多少条记录
	 */
	private long totalCount;

	/**
	 *  当前第几页
	 */
	private int currentPageNum;

	/**
	 *  总页数
	 */
	private int totalPageNum;

	/**
	 * 初始化时默认值
	 */
	public Pagination() {
		// 默认每页10条记录
		pageCount = 10;
		// 共多少条记录
		totalCount = 0;
		// 默认第一页
		currentPageNum = 1;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

}
