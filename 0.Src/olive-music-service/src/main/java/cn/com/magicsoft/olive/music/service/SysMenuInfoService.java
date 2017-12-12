package cn.com.magicsoft.olive.music.service;

import java.util.List;

import cn.com.magicsoft.framework.core.exception.ServiceException;
import cn.com.magicsoft.framework.service.BaseCrudService;
import cn.com.magicsoft.olive.music.model.SysMenuInfo;

/**
 * ��д�������; 
 * @author user
 * @date  2017-04-01 17:25:33
 * @version 1.0.0
 * @copyright (C) 2013 WonHigh Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the WonHigh technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
public interface SysMenuInfoService extends BaseCrudService {
	
	List<SysMenuInfo> getChildMenus(Integer id) throws ServiceException;
	
	List<SysMenuInfo> getMenusByRoleId(List<Integer> roleIds) throws ServiceException;
}