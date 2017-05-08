package cn.com.magicsoft.olive.music.manager.api;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.security.ITicket;
import cn.com.magicsoft.framework.manager.BaseCrudManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;

/**
 * ��д�������; 
 * @author user
 * @date  2017-04-01 17:28:32
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
public interface SysInternalUserManager extends BaseCrudManager {
	
	SysInternalUser findUserByTicket(ITicket ticket) throws ManagerException;
	
	SysInternalUser findUserById(Integer id)  throws ManagerException;
}