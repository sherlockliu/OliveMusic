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
public class SysRoleInfo implements Serializable {
    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private String roleName;

    /**
     * 
     */
    private String roleDescription;

    /**
     * 
     */
    private Byte roleType;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 
     */
    private Byte invalid;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #roleId}
     *
     * @return the value of sys_role_info.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * {@linkplain #roleId}
     * @param roleId the value for sys_role_info.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * {@linkplain #roleName}
     *
     * @return the value of sys_role_info.role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 
     * {@linkplain #roleName}
     * @param roleName the value for sys_role_info.role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 
     * {@linkplain #roleDescription}
     *
     * @return the value of sys_role_info.role_description
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * 
     * {@linkplain #roleDescription}
     * @param roleDescription the value for sys_role_info.role_description
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 
     * {@linkplain #roleType}
     *
     * @return the value of sys_role_info.role_type
     */
    public Byte getRoleType() {
        return roleType;
    }

    /**
     * 
     * {@linkplain #roleType}
     * @param roleType the value for sys_role_info.role_type
     */
    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    /**
     * 
     * {@linkplain #creator}
     *
     * @return the value of sys_role_info.creator
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 
     * {@linkplain #creator}
     * @param creator the value for sys_role_info.creator
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of sys_role_info.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for sys_role_info.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of sys_role_info.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for sys_role_info.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_role_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_role_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}