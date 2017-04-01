package cn.com.magicsoft.olive.music.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 请写出类的用途 
 * @author user
 * @date  2017-04-01 17:25:33
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
public class SysMenuInfo implements Serializable {
    /**
     * 
     */
    private Integer menuId;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 
     */
    private String menuUrl;

    /**
     * 
     */
    private Byte menuOrder;

    /**
     * 
     */
    private String menuIcon;

    /**
     * 
     */
    private Byte menuType;

    /**
     * 
     */
    private Byte isSystem;

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
     * {@linkplain #menuId}
     *
     * @return the value of sys_menu_info.menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 
     * {@linkplain #menuId}
     * @param menuId the value for sys_menu_info.menu_id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 
     * {@linkplain #menuName}
     *
     * @return the value of sys_menu_info.menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 
     * {@linkplain #menuName}
     * @param menuName the value for sys_menu_info.menu_name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 
     * {@linkplain #parentId}
     *
     * @return the value of sys_menu_info.parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 
     * {@linkplain #parentId}
     * @param parentId the value for sys_menu_info.parent_id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * {@linkplain #menuUrl}
     *
     * @return the value of sys_menu_info.menu_url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 
     * {@linkplain #menuUrl}
     * @param menuUrl the value for sys_menu_info.menu_url
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 
     * {@linkplain #menuOrder}
     *
     * @return the value of sys_menu_info.menu_order
     */
    public Byte getMenuOrder() {
        return menuOrder;
    }

    /**
     * 
     * {@linkplain #menuOrder}
     * @param menuOrder the value for sys_menu_info.menu_order
     */
    public void setMenuOrder(Byte menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 
     * {@linkplain #menuIcon}
     *
     * @return the value of sys_menu_info.menu_icon
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 
     * {@linkplain #menuIcon}
     * @param menuIcon the value for sys_menu_info.menu_icon
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 
     * {@linkplain #menuType}
     *
     * @return the value of sys_menu_info.menu_type
     */
    public Byte getMenuType() {
        return menuType;
    }

    /**
     * 
     * {@linkplain #menuType}
     * @param menuType the value for sys_menu_info.menu_type
     */
    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    /**
     * 
     * {@linkplain #isSystem}
     *
     * @return the value of sys_menu_info.is_system
     */
    public Byte getIsSystem() {
        return isSystem;
    }

    /**
     * 
     * {@linkplain #isSystem}
     * @param isSystem the value for sys_menu_info.is_system
     */
    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of sys_menu_info.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for sys_menu_info.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of sys_menu_info.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for sys_menu_info.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_menu_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_menu_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}