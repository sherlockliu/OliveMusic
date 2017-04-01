package cn.com.magicsoft.olive.music.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 请写出类的用途 
 * @author user
 * @date  2017-04-01 17:10:22
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
public class SysFunctionInfo implements Serializable {
    /**
     * 
     */
    private Integer funcId;

    /**
     * 
     */
    private String funcCode;

    /**
     * 
     */
    private String funcName;

    /**
     * 
     */
    private String funcDescription;

    /**
     * 
     */
    private Byte funcOrder;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #funcId}
     *
     * @return the value of sys_function_info.func_id
     */
    public Integer getFuncId() {
        return funcId;
    }

    /**
     * 
     * {@linkplain #funcId}
     * @param funcId the value for sys_function_info.func_id
     */
    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    /**
     * 
     * {@linkplain #funcCode}
     *
     * @return the value of sys_function_info.func_code
     */
    public String getFuncCode() {
        return funcCode;
    }

    /**
     * 
     * {@linkplain #funcCode}
     * @param funcCode the value for sys_function_info.func_code
     */
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    /**
     * 
     * {@linkplain #funcName}
     *
     * @return the value of sys_function_info.func_name
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * 
     * {@linkplain #funcName}
     * @param funcName the value for sys_function_info.func_name
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    /**
     * 
     * {@linkplain #funcDescription}
     *
     * @return the value of sys_function_info.func_description
     */
    public String getFuncDescription() {
        return funcDescription;
    }

    /**
     * 
     * {@linkplain #funcDescription}
     * @param funcDescription the value for sys_function_info.func_description
     */
    public void setFuncDescription(String funcDescription) {
        this.funcDescription = funcDescription;
    }

    /**
     * 
     * {@linkplain #funcOrder}
     *
     * @return the value of sys_function_info.func_order
     */
    public Byte getFuncOrder() {
        return funcOrder;
    }

    /**
     * 
     * {@linkplain #funcOrder}
     * @param funcOrder the value for sys_function_info.func_order
     */
    public void setFuncOrder(Byte funcOrder) {
        this.funcOrder = funcOrder;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_function_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_function_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}