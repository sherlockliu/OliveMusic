package cn.com.magicsoft.framework.manager;

import java.util.List;
import java.util.Map;

import cn.com.magicsoft.framework.core.data.SimplePage;
import cn.com.magicsoft.framework.core.enums.DatabaseOperatorEnum;
import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.model.AuthorityParams;

public abstract interface BaseCrudManager {
	public abstract <ModelType> int deleteById(ModelType paramModelType) throws ManagerException;

	public abstract <ModelType> int add(ModelType paramModelType) throws ManagerException;

	public abstract <ModelType> int modifyById(ModelType paramModelType) throws ManagerException;

	public abstract int findCount(Map<String, Object> paramMap) throws ManagerException;

	public abstract int findCount(Map<String, Object> paramMap, AuthorityParams paramAuthorityParams)
			throws ManagerException;

	public abstract <ModelType> ModelType findById(ModelType paramModelType) throws ManagerException;

	public abstract <ModelType> List<ModelType> findByBiz(ModelType paramModelType, Map<String, Object> paramMap)
			throws ManagerException;

	public abstract <ModelType> List<ModelType> findByPage(SimplePage paramSimplePage, String paramString1,
			String paramString2, Map<String, Object> paramMap) throws ManagerException;

	public abstract <ModelType> List<ModelType> findByPage(SimplePage paramSimplePage, String paramString1,
			String paramString2, Map<String, Object> paramMap, AuthorityParams paramAuthorityParams)
			throws ManagerException;

	public abstract <ModelType> int save(Map<DatabaseOperatorEnum, List<ModelType>> paramMap) throws ManagerException;
}
