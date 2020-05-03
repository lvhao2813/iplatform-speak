package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.dao.PriMenuMapper;
import com.boco.share.privilege.service.inter.MenuService;

/**
* Title: PriMenuServiceImpl 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	public PriMenuMapper priMenuMapper;

	@Override
	public List<PriMenuBean> queryMenu(Map<String, String> formMap) {
		return priMenuMapper.queryMenu(formMap);
	}

	@Override
	public List<PriMenuBean> queryMenuListByLevel(Map<String, String> formMap) {
		List<PriMenuBean> currentMenuList = priMenuMapper.queryMenuListByLevel(formMap);
		initTree(currentMenuList);
		return currentMenuList;
	}
	
	/**
	 * Title: initTree
	 * Description: 组合树形结构上下级ID
	 * @param resultList
	 */
	private void initTree(List<PriMenuBean> resultList) {
		for (int i = 0; i < resultList.size(); i++) {
			PriMenuBean currentMenuBean = resultList.get(i);

			if ("0".equals(currentMenuBean.getParentId())) {
				currentMenuBean.setTreeParentsId("0");
				currentMenuBean.setTreeId(String.valueOf(currentMenuBean.getMenuOrd()).trim());
			} else {
				currentMenuBean.setTreeParentsId(currentMenuBean.getAllParentsId().trim());
				currentMenuBean.setTreeId((currentMenuBean.getAllParentsId()+"-"+currentMenuBean.getMenuOrd()).trim());
			}

		}
	}

	@Override
	public int insertMenu(PriMenuBean priMenuBean) {
//		Integer MaxOrder = priMenuMapper.queryMaxOrder(priMenuBean.getParentId());
//		priMenuBean.setMenuOrd(MaxOrder+1);
		return priMenuMapper.insertMenu(priMenuBean);
	}

	@Override
	public int updateMenu(PriMenuBean priMenuBean) {
//		Integer MaxOrder = priMenuMapper.queryMaxOrder(priMenuBean.getParentId());
//		priMenuBean.setMenuOrd(MaxOrder+1);
		return priMenuMapper.updateMenu(priMenuBean);
	}

	@Override
	public int deleteMenu(String deleteId) {
		return priMenuMapper.deleteMenu(deleteId);
	}

	@Override
	public void batchDelete(String[] deleteIds) {
		priMenuMapper.batchDeleteMenu(deleteIds);
	}

	@Override
	public void menuSelectedOpt(String menuId, String[] optIds, String createdBy) {

		try {
			priMenuMapper.deleteSelectedOpt(menuId);
			if(optIds!=null) {
				for (String optId : optIds) {
					Map<String,String> formMap = CollectionUtil.getHashMap(4);
					formMap.put("MENU_OPT_ID", UniqueIDGenerator.getUUID());
					formMap.put("MENU_ID", menuId);
					formMap.put("OPT_ID", optId);
					formMap.put("CREATED_BY", createdBy);
					
					priMenuMapper.insertSelectedOpt(formMap);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@Override
	public List<Map<String, String>> querySelectOptByMenuId(String menuId) {
		return priMenuMapper.querySelectOptByMenuId(menuId);
	}

	@Deprecated
	@Override
	public void setIsHome(String menuId) {
//		priMenuMapper.cancelAllHomePage();
//		priMenuMapper.setupOrCancelHomePageByMenuId(menuId);
	}

	@Override
	public List<Map<String, String>> listSelectWithOutRole(Map<String, String> formMap) {
		return priMenuMapper.listSelectWithOutRole(formMap);
	}

	@Override
	public List<Map<String, String>> listSelectWithInRole(Map<String, String> formMap) {
		return priMenuMapper.listSelectWithInRole(formMap);
	}

	@Override
	public void updateHomeRole(String menuId, String[] checkedIds) {
		priMenuMapper.deleteHomeWithRoleId(menuId);
		if (checkedIds != null) {
			for (String roleId : checkedIds) {
				Map<String, String> formMap = CollectionUtil.getHashMap(2);
				formMap.put("MENU_ID", menuId);
				formMap.put("ROLE_ID", roleId);
				priMenuMapper.updateHomeRole(formMap);
			}
		}
	}

	
	
}
