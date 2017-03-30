package cn.com.magicsoft.olive.music.manager.api;

import java.util.List;

import cn.com.magicsoft.olive.music.model.SysInternalUser;

public interface SysInternalUserManager {

	List<SysInternalUser> getAll();
	
	SysInternalUser getOne(Integer id);
}
