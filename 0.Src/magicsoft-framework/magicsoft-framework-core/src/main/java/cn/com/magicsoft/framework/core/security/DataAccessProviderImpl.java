package cn.com.magicsoft.framework.core.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import cn.com.magicsoft.framework.core.Storage;


public class DataAccessProviderImpl implements DataAccessProvider {
	private static final String DATA_ACCESS_KEY = "dc";

	protected static final XLogger logger = XLoggerFactory
			.getXLogger(DataAccessProviderImpl.class);

	@Value("${dataaccess}")
	protected int dataaccess;

	// @DynamicProperty("dataaccess:0")
	// public void setDataaccess(int val){
	// this.dataaccess = val;
	// this.clear();
	// }

	@Value("${dataaccess.shopMode}")
	protected String shopMode;

	private Storage storage() {
		return Authorization.getStorage();
	}

	@Override
	public void clear() {
		storage().remove(DATA_ACCESS_KEY);
	}

	@SuppressWarnings("unused")
	private Map<String, List<String>> getData() {
		Map<String, List<String>> data = storage().get(DATA_ACCESS_KEY);
		if (data == null) {
			data = new HashMap<String, List<String>>();
			storage().set(DATA_ACCESS_KEY, data);
		}
		return data;
	}

	@Override
	public List<String> getAccessData(String name) {
		return null;
	}

	public List<String> getData(int userId, String name) {
		return null;
	}

	@Override
	public String getAccessDataString(String name) {
		List<String> items = getAccessData(name);
		if (null == items)
			return null;
		String sb = StringUtils.join(items, "','");
		sb = "'" + sb + "'";
		return sb.toString();
	}

}
