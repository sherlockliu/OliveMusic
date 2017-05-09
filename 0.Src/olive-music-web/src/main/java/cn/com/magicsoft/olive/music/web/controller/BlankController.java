package cn.com.magicsoft.olive.music.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blank")
public class BlankController {
	
	@RequestMapping(value = "/404")
	public String index() {
		return "/blank/404";
	}
}
