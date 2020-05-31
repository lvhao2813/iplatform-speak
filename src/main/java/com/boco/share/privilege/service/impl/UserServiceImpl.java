/**
 * 
 */
package com.boco.share.privilege.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.boco.share.framework.common.DateUtils;
import com.boco.share.framework.common.FileUtils;
import com.boco.share.framework.common.UuidUtil;
import com.boco.share.function.common.bean.Attachment;
import com.boco.share.function.common.bean.AttachmentUnit;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.bean.UserAvailable;
import com.boco.share.privilege.dao.UserMapper;
import com.boco.share.privilege.service.inter.UserService;
import com.boco.share.privilege.util.Md5Util;
import com.boco.share.privilege.util.PrivilageConstants;

/**
 * @author lv
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByCode(String code) {
		User user = userMapper.getUserByCode(code);
		UserAvailable userAvailable = userMapper.queryUserAvailableByUserId(user.getId());
		// 检测会员是否过期,过期则更新状态
		if (isVip(userAvailable) && DateUtils.isVipOverTime(userAvailable.getExecTime())) {
			userAvailable.setVip("0");
			userMapper.deleteUserAvailable(userAvailable.getId());
			userMapper.saveUserAvailable(userAvailable); // 这里为啥不能直接update
		}
		user.setUserAvaliable(userAvailable);
		return user;
	}

	@Override
	public boolean checkLoginUser(String code, String passWord) {
		User user = userMapper.getUserByCode(code);
		if (user == null) {
			return false;
		} else {
			if (passWord.equals(user.getPassWord())) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public List<User> loadUsers(Map<String, String> formMap) {
		return userMapper.loadUsers(formMap);
	}

	@Override
	public User getUserById(Map<String, String> formMap) {
		User user = userMapper.getUserById(formMap);
		UserAvailable userAvailable = userMapper.queryUserAvailableByUserId(user.getId());
		user.setUserAvaliable(userAvailable);
		return user;
	}

	@Override
	public int insert(User user) {
		user.setPassWord((Md5Util.encode(PrivilageConstants.DEFAULT_PWD)));
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public void deleteUser(String deleteId) {
		userMapper.deleteUser(deleteId);
	}

	@Override
	public void batchDeleteUsers(String[] mgrIds) {
		userMapper.batchDeleteUsers(mgrIds);
	}
	
	@Override
	public void uploadImg(Map<String, String> formMap,MultipartFile file) throws IOException {
		User user = userMapper.getUserById(formMap);
		String headPath = user.getHeadPath();
		if(!StringUtils.isEmpty(headPath)) {
			deleteHeadFile(headPath);
		}
		if (file != null) {
			 uploadFile(file,user);
		}


	}
	
	private boolean isVip(UserAvailable available) {
		// 如果是空的则为未充值对象
		if (available == null) {
			return false;
		} else {
			if ("0".equals(available.getVip())) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	/**
	 * 	根据路径删除头像
	 * @param path
	 */
	private void deleteHeadFile(String path) {
		File file = new File(path);
		file.delete();
	}
	
	/**
	 * 	上传附件，返回文件存放路径
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private void uploadFile(MultipartFile file,User user) throws IOException {
		// 保存文件到本地磁盘,同时生成对象，保存路径方便后续取
		byte[] bytes = file.getBytes();
		String resourceBasePath = FileUtils.getResourceBasePath() + "/static/headImgs";
		File fileDir = new File(resourceBasePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		String fileName = DateUtils.getNowDateNum() + "_" + file.getOriginalFilename();
		Path path = Paths.get(resourceBasePath + "/" + fileName);
		Files.write(path, bytes);
		// 返回文件路径
		user.setHeadPath(path.toString());
		user.setHeadName(fileName);
		userMapper.update(user);
	}
	

}
