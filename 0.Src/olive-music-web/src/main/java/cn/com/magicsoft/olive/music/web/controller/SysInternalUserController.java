package cn.com.magicsoft.olive.music.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.security.ITicket;
import cn.com.magicsoft.framework.core.security.SecurityUser;
import cn.com.magicsoft.framework.core.utils.EncryptUtils;
import cn.com.magicsoft.framework.web.controller.BaseCrudController;
import cn.com.magicsoft.framework.web.security.AuthorizationManager;
import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;
import cn.com.magicsoft.olive.music.web.security.OliveTicket;

/**
 * ��д�������; 
 * @author user
 * @date  2017-04-01 17:28:32
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
@RequestMapping("/sys_internal_user")
public class SysInternalUserController extends BaseCrudController<SysInternalUser> {
	
	private XLogger logger = XLoggerFactory.getXLogger(SysInternalUserController.class);
	
    @Resource
    private SysInternalUserManager sysInternalUserManager;

    @Override
    public CrudInfo init() {
        return new CrudInfo("sys_internal_user/",sysInternalUserManager);
    }
    
    @RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> doLogin(HttpServletRequest req, Model model) throws ManagerException {
		Map<String,Object> params = builderParams(req, model);
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			ITicket ticket = new OliveTicket(params.get("userAccount").toString(), 
					EncryptUtils.md5(params.get("password").toString()), true);
			
			SecurityUser user = AuthorizationManager.login(ticket);
			if(user!= null){
				result.put("success",true);
			}else{
				result.put("success",false);
			}
		} catch (Exception e) {
			logger.error("", e);
			result.put("success",true);
		}
		return result;
	}
    
    @RequestMapping(value = "/logOut")
   	@ResponseBody
   	public String logOut(HttpServletRequest req, Model model) throws ManagerException {
   		AuthorizationManager.logout();
   		return "true";
   	}
}