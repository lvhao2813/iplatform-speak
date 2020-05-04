package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.dao.PriManagerMapper;
import com.boco.share.privilege.service.inter.IPriManagerService;
import com.boco.share.privilege.util.Md5Util;
import com.boco.share.privilege.util.PrivilageConstants;

/**
 * <p>
 * Title: PriManagerServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@Service
public class PriManagerServiceImpl implements IPriManagerService {

	@Autowired
	private PriManagerMapper userManagerMapper;

	@Override
	public PriManagerBean checkManager(PriManagerBean priManager) {
//		priManager.setPassword(Md5Util.encode(priManager.getPassword()));

		priManager = userManagerMapper.getManagerByCodeAndPassword(priManager);
		return priManager;
	}

	@Override
	public Map<String, String> getUserRole(String mgrId) {
//		return userManagerMapper.getUserRole(mgrId); ###
		return null;
	}

	@Override
	public List<PriMenuBean> queryAllMenu() {
//		return userManagerMapper.loadAllMenu(); ###
		return null;
	}

	@Override
	public List<Map<String, String>> queryMenuAndOptByUser(PriManagerBean priManager) {
		return userManagerMapper.queryMenuAndOptByUser(priManager);
	}

	@Override
	public List<User> loadUsers(Map<String, String> formMap) {
		return userManagerMapper.loadUsers(formMap);
	}
	

	@Override
	public User getUserById(Map<String, String> formMap) {
		return userManagerMapper.getUserById(formMap);
	}

	@Override
	public int insert(User user) {
		user.setPassWord((Md5Util.encode(PrivilageConstants.DEFAULT_PWD)));
		return userManagerMapper.insertManager(user);
	}

	@Override
	public int update(User user) {
		return userManagerMapper.updateManager(user);
	}

	@Override
	public void deleteManager(String deleteId) {
		userManagerMapper.deleteManager(deleteId);
	}

	@Override
	public void batchDeleteManager(String[] mgrIds) {
		userManagerMapper.batchDeleteManager(mgrIds);
	}

	@Override
	public void setStopOrActive(String mgrId) {
		userManagerMapper.setStopOrActive(mgrId);
	}

	@Override
	public String queryHomeUrl(String mgrId) {
		return userManagerMapper.queryHomeUrl(mgrId);
	}

	@Override
	public void setDateAuthoParams(PriManagerBean priManager, ServletRequest request) {
		String specitys = request.getParameter("specity");
		if (!StringUtils.isEmpty(specitys)) {
			priManager.setSpecialty(specitys);
		}
		List<String> provinceOrgChilds = userManagerMapper.queryOrgAndChild("1");
		provinceOrgChilds.add("1");
		String orgId = request.getParameter("orgId");
		if (!StringUtils.isEmpty(orgId)) {
			String[] orgIds = orgId.split(",");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < orgIds.length; i++) {
				String org = orgIds[i];
				if(i == 0) {
					sb.append(org);
					List<String> orgChilds = userManagerMapper.queryOrgAndChild(org);
					if (!orgChilds.isEmpty()) {
						for (String orgChild : orgChilds) {
							sb.append(","+orgChild);
						}
					}
				} else {
					sb.append(",").append(org);
					List<String> orgChilds = userManagerMapper.queryOrgAndChild(org);
					if (!orgChilds.isEmpty()) {
						for (String orgChild : orgChilds) {
							sb.append(","+orgChild);
						}
					}
				}
			}
			String orgsss = sb.toString();
			
			if(provinceOrgChilds.contains(orgId)) {
				priManager.setOrganization("");
			}else {
				priManager.setOrganization(orgsss.substring(0, orgsss.length() - 1));
			}
			
		}
	}

}
