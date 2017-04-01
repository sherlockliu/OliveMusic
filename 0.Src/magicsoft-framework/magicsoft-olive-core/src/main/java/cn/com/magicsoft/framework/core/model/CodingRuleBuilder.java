package cn.com.magicsoft.framework.core.model;

public abstract interface CodingRuleBuilder {
	public abstract void setRequestId(String paramString);

	public abstract String getRequestId();

	public abstract void setPrefix(String paramString);

	public abstract void setFormatedTime(String paramString);

	public abstract void setSequence(String paramString);

	public abstract String buildNo();
}