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
public class SysRoleMenuInfo implements Serializable {
    /**
     * 
     */
    private Integer roleMenuId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer menuId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #roleMenuId}
     *
     * @return the value of sys_role_menu_info.role_menu_id
     */
    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    /**
     * 
     * {@linkplain #roleMenuId}
     * @param roleMenuId the value for sys_role_menu_info.role_menu_id
     */
    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    /**
     * 
     * {@linkplain #roleId}
     *
     * @return the value of sys_role_menu_info.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * {@linkplain #roleId}
     * @param roleId the value for sys_role_menu_info.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * {@linkplain #menuId}
     *
     * @return the value of sys_role_menu_info.menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 
     * {@linkplain #menuId}
     * @param menuId the value for sys_role_menu_info.menu_id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_role_menu_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_role_menu_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}