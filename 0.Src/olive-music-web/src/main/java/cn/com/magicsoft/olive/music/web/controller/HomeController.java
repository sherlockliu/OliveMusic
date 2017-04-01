package cn.com.magicsoft.olive.music.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.model.SysInternalUser;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Resource
	private SysInternalUserManager sysInternalUserManager; 
	
//	@RequestMapping(value = "/index")
//	@ResponseBody
//	public ModelAndView index(HttpServletRequest request){
//		ModelAndView mav = new ModelAndView("index");
//		return mav;
//	}
	
	@RequestMapping(value = "/index")
	@ResponseBody
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/dev")
//	@ResponseBody
	public String dev() {
		return "home/dev";
	}
}
