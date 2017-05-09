package cn.com.magicsoft.olive.music.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.framework.core.exception.ServiceException;
import cn.com.magicsoft.framework.dal.BaseCrudMapper;
import cn.com.magicsoft.framework.service.BaseCrudServiceImpl;
import cn.com.magicsoft.olive.music.dal.database.SysMenuInfoMapper;
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
@Service("sysMenuInfoService")
class SysMenuInfoServiceImpl extends BaseCrudServiceImpl implements SysMenuInfoService {
    @Resource
    private SysMenuInfoMapper sysMenuInfoMapper;

    @Override
    public BaseCrudMapper init() {
        return sysMenuInfoMapper;
    }

	@Override
	public List<SysMenuInfo> getChildMenus(Integer id) throws ServiceException {
		try {
			return this.sysMenuInfoMapper.getChildMenus(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SysMenuInfo> getMenusByRoleId(List<Integer> roleIds) throws ServiceException {
		try {
			return this.sysMenuInfoMapper.getMenusByRoleId(roleIds);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}