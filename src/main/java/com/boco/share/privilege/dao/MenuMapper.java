package com.boco.share.privilege.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.privilege.bean.Menu;

/**
 * 
 * @author lv
 */
@Mapper
public interface MenuMapper {
	
	/**
	 * 通过父结点查找目录
	 * @param formMap
	 * @return
	 */
	List<Menu> queryMenuByParentID(@Param("PARENT_ID")String parentId);
	
}
