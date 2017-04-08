package cn.com.magicsoft.olive.music.web.controller;

import javax.annotation.Resource;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< Updated upstream
import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
=======
import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.olive.music.dal.database.SysInternalUserMapper;
import cn.com.magicsoft.olive.music.dal.database.TestMapper;
import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;
import cn.com.magicsoft.olive.music.web.controller.BaseCrudController.CrudInfo;
>>>>>>> Stashed changes

@Controller
@RequestMapping("/home")
public class HomeController extends BaseCrudController<SysInternalUser> {
	
<<<<<<< Updated upstream
	private final XLogger LOGGER = XLoggerFactory.getXLogger(HomeController.class);
	
	@Resource
	private SysInternalUserManager sysInternalUserManager;
=======
	@Resource
	private SysInternalUserManager sysInternalUserManager;
	
	@Resource
	private SysInternalUserMapper mapper;
	
	@Resource
	private TestMapper mapper12;
>>>>>>> Stashed changes
	
	@RequestMapping(value = "/index")
	public String index() {
		return "/home/index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "/home/login";
	}
<<<<<<< Updated upstream
=======

	@Override
	protected BaseCrudController<SysInternalUser>.CrudInfo init() {
		return new CrudInfo("home/",this.sysInternalUserManager);
	}
>>>>>>> Stashed changes
}
