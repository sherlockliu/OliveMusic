package cn.com.magicsoft.framework.core.security;

import java.util.List;

public interface DataAccessProvider {
	
	/**
	 * 获取授权数据
	 * @param name 数据类型(品牌，订货单位,组织)
	 * @return
	 */
	List<String> getAccessData(String name);
	
	String getAccessDataString(String name);
	
	void clear();
	
}
