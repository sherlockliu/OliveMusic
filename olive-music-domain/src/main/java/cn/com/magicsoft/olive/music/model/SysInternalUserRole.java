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
public class SysInternalUserRole implements Serializable {
    /**
     * 
     */
    private Integer internalUserRoleId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #internalUserRoleId}
     *
     * @return the value of sys_internal_user_role.internal_user_role_id
     */
    public Integer getInternalUserRoleId() {
        return internalUserRoleId;
    }

    /**
     * 
     * {@linkplain #internalUserRoleId}
     * @param internalUserRoleId the value for sys_internal_user_role.internal_user_role_id
     */
    public void setInternalUserRoleId(Integer internalUserRoleId) {
        this.internalUserRoleId = internalUserRoleId;
    }

    /**
     * 
     * {@linkplain #roleId}
     *
     * @return the value of sys_internal_user_role.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * {@linkplain #roleId}
     * @param roleId the value for sys_internal_user_role.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of sys_internal_user_role.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for sys_internal_user_role.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_internal_user_role.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_internal_user_role.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}