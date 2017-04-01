package cn.com.magicsoft.framework.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.magicsoft.framework.core.data.SimplePage;
import cn.com.magicsoft.framework.core.enums.DatabaseOperatorEnum;
import cn.com.magicsoft.framework.core.exception.ServiceException;
import cn.com.magicsoft.framework.core.model.AuthorityParams;
import cn.com.magicsoft.framework.dal.BaseCrudMapper;

public abstract class BaseCrudServiceImpl implements BaseCrudService {

	@Autowired(required = false)
	private Validator validator;

	@Value("${base.boot.is_need_validate}")
	private String valid;
	private BaseCrudMapper mapper;

	public BaseCrudServiceImpl() {
		this.valid = "false";
	}

	private void initConfig() {
		this.mapper = init();
		if ((null != this.valid) && (new Boolean(this.valid).booleanValue()) && (null == this.validator))
			throw new RuntimeException("系统开启实体类验证,验证器为空异常");
	}

	public abstract BaseCrudMapper init();

	public <ModelType> void validate(ModelType t) throws ServiceException {
		if ((null == this.valid) || (!(new Boolean(this.valid).booleanValue()))) {
			return;
		}
		Set<ConstraintViolation<ModelType>> constraintViolations = this.validator.validate(t, new Class[0]);
		if (constraintViolations.size() > 0) {
			StringBuilder validateError = new StringBuilder();
			for (ConstraintViolation<?> constraintViolation : constraintViolations) {
				validateError.append("属性：").append(constraintViolation.getPropertyPath()).append("报错！")
						.append(constraintViolation.getMessage()).append(";");
			}
			throw new ServiceException(validateError.toString());
		}
	}

	public <ModelType> int deleteById(ModelType modelType) throws ServiceException {
		try {
			return this.mapper.deleteByPrimarayKeyForModel(modelType);
		} catch (Exception e) {
			throw new ServiceException(
					new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
		}
	}

	public <ModelType> int add(ModelType modelType) throws ServiceException {
		try {
			validate(modelType);
			return this.mapper.insertSelective(modelType);
		} catch (Exception e) {
			throw new ServiceException(
					new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
		}
	}

	public <ModelType> ModelType findById(ModelType modelType) throws ServiceException {
		try {
			return this.mapper.selectByPrimaryKey(modelType);
		} catch (Exception e) {
			throw new ServiceException(
					new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
		}
	}

	public <ModelType> List<ModelType> findByBiz(ModelType modelType, Map<String, Object> params)
			throws ServiceException {
		try {
			return this.mapper.selectByParams(modelType, params);
		} catch (Exception e) {
			throw new ServiceException(
					new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
		}
	}

	public <ModelType> int modifyById(ModelType modelType) throws ServiceException {
		try {
			return this.mapper.updateByPrimaryKeySelective(modelType);
		} catch (Exception e) {
			throw new ServiceException(
					new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
		}
	}

	public int findCount(Map<String, Object> params) throws ServiceException {
		try {
			return this.mapper.selectCount(params, null);
		} catch (Exception e) {
			throw new ServiceException("", e);
		}
	}

	public int findCount(Map<String, Object> params, AuthorityParams authorityParams) throws ServiceException {
		try {
			return this.mapper.selectCount(params, authorityParams);
		} catch (Exception e) {
			throw new ServiceException("", e);
		}
	}

	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params) throws ServiceException {
		try {
			return findByPage(page, orderByField, orderBy, params, null);
		} catch (ServiceException e) {
			throw e;
		}
	}

	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params, AuthorityParams authorityParams) throws ServiceException {
		try {
			return this.mapper.selectByPage(page, orderByField, orderBy, params, authorityParams);
		} catch (Exception e) {
			throw new ServiceException("", e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ServiceException.class })
	public <ModelType> int save(Map<DatabaseOperatorEnum, List<ModelType>> params) throws ServiceException {
		try {
			int count = 0;
			for (Map.Entry param : params.entrySet()) {
				Iterator<?> localIterator2;
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.DELETED)) {
					List<?> list = params.get(DatabaseOperatorEnum.DELETED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							count += this.mapper.deleteByPrimarayKeyForModel(modelType);
						}
					}
				}
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.UPDATED)) {
					List<?> list = params.get(DatabaseOperatorEnum.UPDATED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							count += this.mapper.updateByPrimaryKeySelective(modelType);
						}
					}
				}
				if (((DatabaseOperatorEnum) param.getKey()).equals(DatabaseOperatorEnum.INSERTED)) {
					List<?> list = params.get(DatabaseOperatorEnum.INSERTED);
					if ((null != list) && (list.size() > 0)) {
						for (localIterator2 = list.iterator(); localIterator2.hasNext();) {
							Object modelType = localIterator2.next();
							this.mapper.insertSelective(modelType);
						}
						count += list.size();
					}
				}
			}
			return count;
		} catch (Exception e) {
			throw new ServiceException("", e);
		}
	}
}