package cn.com.magicsoft.framework.service;

import java.util.List;
import java.util.Map;

import cn.com.magicsoft.framework.core.data.SimplePage;
import cn.com.magicsoft.framework.core.enums.DatabaseOperatorEnum;
import cn.com.magicsoft.framework.core.exception.ServiceException;
import cn.com.magicsoft.framework.core.model.AuthorityParams;

public interface BaseCrudService {
	public abstract <ModelType> int deleteById(ModelType paramModelType) throws ServiceException;

	public abstract <ModelType> int add(ModelType paramModelType) throws ServiceException;

	public abstract <ModelType> ModelType findById(ModelType paramModelType) throws ServiceException;

	public abstract <ModelType> List<ModelType> findByBiz(ModelType paramModelType, Map<String, Object> paramMap)
			throws ServiceException;

	public abstract <ModelType> int modifyById(ModelType paramModelType) throws ServiceException;

	public abstract int findCount(Map<String, Object> paramMap) throws ServiceException;

	public abstract int findCount(Map<String, Object> paramMap, AuthorityParams paramAuthorityParams)
			throws ServiceException;

	public abstract <ModelType> List<ModelType> findByPage(SimplePage paramSimplePage, String paramString1,
			String paramString2, Map<String, Object> paramMap) throws ServiceException;

	public abstract <ModelType> List<ModelType> findByPage(SimplePage paramSimplePage, String paramString1,
			String paramString2, Map<String, Object> paramMap, AuthorityParams paramAuthorityParams)
			throws ServiceException;

	public abstract <ModelType> int save(Map<DatabaseOperatorEnum, List<ModelType>> paramMap) throws ServiceException;

}
