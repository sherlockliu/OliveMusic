package cn.com.magicsoft.olive.music.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.magicsoft.framework.web.controller.BaseCrudController;
import cn.com.magicsoft.olive.music.manager.api.SysMenuFunctionManager;

/**
 * ��д�������; 
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
@Controller
@RequestMapping("/sys_menu_function")
public class SysMenuFunctionController extends BaseCrudController {
    @Resource
    private SysMenuFunctionManager sysMenuFunctionManager;

    @Override
    public CrudInfo init() {
        return new CrudInfo("sys_menu_function/",sysMenuFunctionManager);
    }
}