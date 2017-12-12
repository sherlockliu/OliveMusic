package cn.com.magicsoft.framework.core.enums;

public enum DatabaseOperatorEnum {
	DELETED, 
	UPDATED, 
	INSERTED;

	private String operator;

	public String getOperator() {
		return this.operator;
	}
}
