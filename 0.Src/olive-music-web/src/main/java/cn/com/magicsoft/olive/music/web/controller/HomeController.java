package cn.com.magicsoft.olive.music.web.controller;

import javax.annotation.Resource;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private final XLogger LOGGER = XLoggerFactory.getXLogger(HomeController.class);
	
	@Resource
	private SysInternalUserManager sysInternalUserManager;
	
	@RequestMapping(value = "/index")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "/home/login";
	}
	
	@RequestMapping(value = "/dev")
	@ResponseBody
	public String dev() {
		try {
 		    Integer count = this.sysInternalUserManager.findCount(null);
			return count.toString();
		} catch (Exception e) {
		}
		return "22";
	}
}
