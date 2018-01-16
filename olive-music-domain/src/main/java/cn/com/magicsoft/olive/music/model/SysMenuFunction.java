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
public class SysMenuFunction implements Serializable {
    /**
     * 
     */
    private Integer menuFuncId;

    /**
     * 
     */
    private Integer menuId;

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
     * {@linkplain #menuFuncId}
     *
     * @return the value of sys_menu_function.menu_func_id
     */
    public Integer getMenuFuncId() {
        return menuFuncId;
    }

    /**
     * 
     * {@linkplain #menuFuncId}
     * @param menuFuncId the value for sys_menu_function.menu_func_id
     */
    public void setMenuFuncId(Integer menuFuncId) {
        this.menuFuncId = menuFuncId;
    }

    /**
     * 
     * {@linkplain #menuId}
     *
     * @return the value of sys_menu_function.menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 
     * {@linkplain #menuId}
     * @param menuId the value for sys_menu_function.menu_id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 
     * {@linkplain #funcId}
     *
     * @return the value of sys_menu_function.func_id
     */
    public Integer getFuncId() {
        return funcId;
    }

    /**
     * 
     * {@linkplain #funcId}
     * @param funcId the value for sys_menu_function.func_id
     */
    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_menu_function.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_menu_function.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}