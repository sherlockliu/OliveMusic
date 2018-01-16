package cn.com.magicsoft.olive.music.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.security.ITicket;
import cn.com.magicsoft.framework.manager.BaseCrudManagerImpl;
import cn.com.magicsoft.framework.service.BaseCrudService;
import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;
import cn.com.magicsoft.olive.music.service.SysInternalUserService;

/**
 * ��д�������; 
 * @author user
 * @date  2017-04-01 17:10:22
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
@Service("sysInternalUserManager")
class SysInternalUserManagerImpl extends BaseCrudManagerImpl implements SysInternalUserManager {
    
	@Resource
    private SysInternalUserService sysInternalUserService;
    
    @Override
    public BaseCrudService init() {
        return sysInternalUserService;
    }

	@Override
	public SysInternalUser findUserByTicket(ITicket ticket)  throws ManagerException {
		try {
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("userAccount", ticket.getIdentity());
			params.put("password",ticket.getPassword());
			params.put("invalid","0");
			List<SysInternalUser> list = this.sysInternalUserService.findByBiz(null, params);
			if(null!=list && list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public SysInternalUser findUserById(Integer id) throws ManagerException {
		try {
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("id", id);
			List<SysInternalUser> list = this.sysInternalUserService.findByBiz(null, params);
			if(null!=list && list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}
}