/**
 * 
 */
package com.boco.share.privilege.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.privilege.bean.User;

/**
 * @author LOVE
 *
 */
@Mapper
public interface LoginMapper {
	public User getUserByName(@Param("name") String name);
}
