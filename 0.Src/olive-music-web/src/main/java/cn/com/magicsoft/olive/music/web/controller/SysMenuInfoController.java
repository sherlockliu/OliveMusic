package cn.com.magicsoft.olive.music.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.Index;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.utils.JsonUtils;
import cn.com.magicsoft.framework.web.controller.BaseCrudController;
import cn.com.magicsoft.framework.web.model.ZTreeResponse;
import cn.com.magicsoft.olive.music.manager.api.SysMenuInfoManager;
import cn.com.magicsoft.olive.music.model.SysMenuInfo;

/**
 * ��д�������; 
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
@Controller
@RequestMapping("/sys_menu_info")
public class SysMenuInfoController extends BaseCrudController {
    @Resource
    private SysMenuInfoManager sysMenuInfoManager;

    @Override
    public CrudInfo init() {
        return new CrudInfo("sys_menu_info/",sysMenuInfoManager);
    }
    
    @RequestMapping(value = "/getTreeNode")
	@ResponseBody
    public String getTreeNode(Integer id) throws ManagerException, IOException
    {
        List<SysMenuInfo> menuInfoList;
        if (id == -1)
        {
            menuInfoList = new ArrayList<SysMenuInfo>();
            menuInfoList.add(this.createRootNode());
        }
        else
        {
            menuInfoList = this.sysMenuInfoManager.getChildMenus(id);
        }
        List<ZTreeResponse> response = this.toZtreeResponse(menuInfoList);
        return JsonUtils.toJson(response);
    }
    
    private List<ZTreeResponse> toZtreeResponse(List<SysMenuInfo> menuInfoList)
    {
        List<ZTreeResponse> response = new ArrayList<ZTreeResponse>();
        if (menuInfoList != null)
        {
        		for(SysMenuInfo item : menuInfoList){
        			ZTreeResponse responseItem = new ZTreeResponse();
        			responseItem.setId(item.getMenuId());
        			responseItem.setName(item.getMenuName());
        			responseItem.setIsParent(item.getIsParent()==1?true:false);
        			responseItem.setURL(item.getMenuUrl());
        			response.add(responseItem);
        		}
        }
        return response;
    }
    
    private SysMenuInfo createRootNode()
    {
    		SysMenuInfo rootNode = new SysMenuInfo();
    		rootNode.setIsParent((byte)1);
    		rootNode.setMenuId(0);
    		rootNode.setMenuName("olive");
        return rootNode;
    }
}