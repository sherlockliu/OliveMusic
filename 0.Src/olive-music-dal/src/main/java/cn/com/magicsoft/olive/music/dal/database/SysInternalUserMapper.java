package cn.com.magicsoft.olive.music.dal.database;

import java.util.List;

import cn.com.magicsoft.olive.music.model.SysInternalUser;

/*
 * 
 */
public interface SysInternalUserMapper {
	
	List<SysInternalUser> getAll();
	
	SysInternalUser getOne(Integer id);
}
