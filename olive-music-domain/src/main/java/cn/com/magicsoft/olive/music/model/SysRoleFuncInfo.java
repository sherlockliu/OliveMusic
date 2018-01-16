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
public class SysRoleFuncInfo implements Serializable {
    /**
     * 
     */
    private Integer roleFuncId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer funcId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #roleFuncId}
     *
     * @return the value of sys_role_func_info.role_func_id
     */
    public Integer getRoleFuncId() {
        return roleFuncId;
    }

    /**
     * 
     * {@linkplain #roleFuncId}
     * @param roleFuncId the value for sys_role_func_info.role_func_id
     */
    public void setRoleFuncId(Integer roleFuncId) {
        this.roleFuncId = roleFuncId;
    }

    /**
     * 
     * {@linkplain #roleId}
     *
     * @return the value of sys_role_func_info.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * {@linkplain #roleId}
     * @param roleId the value for sys_role_func_info.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * {@linkplain #funcId}
     *
     * @return the value of sys_role_func_info.func_id
     */
    public Integer getFuncId() {
        return funcId;
    }

    /**
     * 
     * {@linkplain #funcId}
     * @param funcId the value for sys_role_func_info.func_id
     */
    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_role_func_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_role_func_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}