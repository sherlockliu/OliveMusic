package cn.com.magicsoft.framework.core.security;

import java.io.Serializable;

public class FunctionItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String functionCode;
	
	private String functionName;

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
