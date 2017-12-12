package cn.com.magicsoft.framework.manager;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.magicsoft.framework.core.data.SimplePage;
import cn.com.magicsoft.framework.core.enums.DatabaseOperatorEnum;
import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.exception.ServiceException;
import cn.com.magicsoft.framework.core.model.AuthorityParams;
import cn.com.magicsoft.framework.service.BaseCrudService;

@Service
public abstract class BaseCrudManagerImpl implements BaseCrudManager {
	private BaseCrudService service;

	@PostConstruct
	protected void initConfig() {
		this.service = init();
	}

	protected abstract BaseCrudService init();

	public <ModelType> int deleteById(ModelType modelType) throws ManagerException {
		try {
			return this.service.deleteById(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public <ModelType> int add(ModelType modelType) throws ManagerException {
		try {
			return this.service.add(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public <ModelType> ModelType findById(ModelType modelType) throws ManagerException {
		try {
			return this.service.findById(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public <ModelType> int modifyById(ModelType modelType) throws ManagerException {
		try {
			return this.service.modifyById(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public int findCount(Map<String, Object> params) throws ManagerException {
		try {
			return this.service.findCount(params);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public int findCount(Map<String, Object> params, AuthorityParams authorityParams) throws ManagerException {
		try {
			return this.service.findCount(params, authorityParams);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public <ModelType> List<ModelType> findByBiz(ModelType modelType, Map<String, Object> params)
			throws ManagerException {
		try {
			return this.service.findByBiz(modelType, params);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params) throws ManagerException {
		try {
			return findByPage(page, orderByField, orderBy, params, null);
		} catch (ManagerException e) {
			throw e;
		}
	}

	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params, AuthorityParams authorityParams) throws ManagerException {
		try {
			return this.service.findByPage(page, orderByField, orderBy, params, authorityParams);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ManagerException.class })
	public <ModelType> int save(Map<DatabaseOperatorEnum, List<ModelType>> params) throws ManagerException {
		try {
			int count = 0;
			for (Map.Entry param : params.entrySet()) {
				Iterator localIterator2;
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.DELETED)) {
					List list = (List) params.get(DatabaseOperatorEnum.DELETED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							count += this.service.deleteById(modelType);
						}
					}
				}
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.UPDATED)) {
					List list = (List) params.get(DatabaseOperatorEnum.UPDATED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							count += this.service.modifyById(modelType);
						}
					}
				}
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.INSERTED)) {
					List list = (List) params.get(DatabaseOperatorEnum.INSERTED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							this.service.add(modelType);
						}
						count += list.size();
					}
				}
			}
			return count;
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
}