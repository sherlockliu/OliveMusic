package cn.com.magicsoft.olive.music.service;

import java.util.List;

import cn.com.magicsoft.olive.music.model.SysInternalUser;

public interface SysInternalUserService {

	List<SysInternalUser> getAll();

	SysInternalUser getOne(Integer id);
}
