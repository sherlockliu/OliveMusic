package cn.com.magicsoft.olive.music.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.manager.BaseCrudManagerImpl;
import cn.com.magicsoft.framework.service.BaseCrudService;
import cn.com.magicsoft.olive.music.manager.api.SysMenuInfoManager;
import cn.com.magicsoft.olive.music.model.SysMenuInfo;
import cn.com.magicsoft.olive.music.service.SysMenuInfoService;

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
@Service("sysMenuInfoManager")
class SysMenuInfoManagerImpl extends BaseCrudManagerImpl implements SysMenuInfoManager {
    @Resource
    private SysMenuInfoService sysMenuInfoService;

    @Override
    public BaseCrudService init() {
        return sysMenuInfoService;
    }

	@Override
	public List<SysMenuInfo> getChildMenus(Integer id) throws ManagerException {
		try {
			return this.sysMenuInfoService.getChildMenus(id);
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public List<SysMenuInfo> getMenusByRoleId(List<Integer> roleIds) throws ManagerException {
		try {
			return this.sysMenuInfoService.getMenusByRoleId(roleIds);
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}
}