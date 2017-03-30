package cn.com.magicsoft.olive.music.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;
import cn.com.magicsoft.olive.music.service.SysInternalUserService;

@Service
public class SysInternalUserManagerImpl implements SysInternalUserManager{

	@Resource
	private SysInternalUserService sysInternalUserService;
	
	@Override
	public List<SysInternalUser> getAll() {
		return this.sysInternalUserService.getAll();
	}

	@Override
	public SysInternalUser getOne(Integer id) {
		return this.sysInternalUserService.getOne(id);
	}

}
