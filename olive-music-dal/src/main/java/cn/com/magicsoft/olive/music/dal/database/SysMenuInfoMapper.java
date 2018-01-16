package cn.com.magicsoft.olive.music.dal.database;

import java.util.List;

import cn.com.magicsoft.framework.dal.BaseCrudMapper;
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
public interface SysMenuInfoMapper extends BaseCrudMapper {

	List<SysMenuInfo> getChildMenus(Integer id);

	List<SysMenuInfo> getMenusByRoleId(List<Integer> roleIds);
}