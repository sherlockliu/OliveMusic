package cn.com.magicsoft.olive.music.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.olive.music.dal.database.SysInternalUserMapper;
import cn.com.magicsoft.olive.music.model.SysInternalUser;

@Service
public class SysInternalUserServiceImpl implements SysInternalUserService {
	
	@Resource
	private SysInternalUserMapper sysInternalUserMapper;
	
	@Override
	public List<SysInternalUser> getAll() {
		return this.sysInternalUserMapper.getAll();
	}

	@Override
	public SysInternalUser getOne(Integer id) {
		return this.sysInternalUserMapper.getOne(id);
	}
}
