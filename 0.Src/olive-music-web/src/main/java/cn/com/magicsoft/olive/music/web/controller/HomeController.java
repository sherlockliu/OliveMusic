package cn.com.magicsoft.olive.music.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.magicsoft.framework.core.exception.ManagerException;
import cn.com.magicsoft.framework.core.utils.JsonUtils;
import cn.com.magicsoft.olive.music.manager.api.SysInternalUserManager;
import cn.com.magicsoft.olive.music.manager.api.SysMenuInfoManager;
import cn.com.magicsoft.olive.music.model.SysMenuInfo;
import cn.com.magicsoft.olive.music.web.viewmodel.MenuView;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private final XLogger LOGGER = XLoggerFactory.getXLogger(HomeController.class);
	
	@Resource
	private SysInternalUserManager sysInternalUserManager;
	
	@Resource
	private SysMenuInfoManager sysMenuInfoManager; 
	
	@RequestMapping(value = "/index")
	public String index() {
		return "/home/index";
	}
	
	@RequestMapping(value = "/dev")
	@ResponseBody
	public String dev() {
		return "dev";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "/home/login";
	}
	
	@RequestMapping(value = "getAuthorizationMenuList")
	@ResponseBody
	public String getAuthorizationMenuList() throws ManagerException, IOException{
//		if(null == Authorization.getUser()){
//			AuthorizationManager.logout();
//			return "";
//		}
//		else{
//			SecurityUser user = Authorization.getUser();
//			List<Role> roleList = user.getRoles();
//			if(roleList!=null){
//				List<Integer> roleIds = new ArrayList<>();
//				for(Role item : roleList){
//					roleIds.add(item.getRoleId());
//				}
//				List<SysMenuInfo> menuList = this.sysMenuInfoManager.getMenusByRoleId(roleIds);
				List<SysMenuInfo> menuList = this.sysMenuInfoManager.getMenusByRoleId(null);
				List<MenuView> menuViews = this.toMenuView(menuList, 0);
				return JsonUtils.toJson(menuViews);
//			}
//		}
//		return "";
	}
	
	private List<MenuView> toMenuView(List<SysMenuInfo> menuList, int parentId){
		List<MenuView> result = null;
		if(menuList !=null && menuList.size() > 0){
			List<SysMenuInfo> childrenMenus = this.findChildrenMenus(menuList, parentId);
			if(childrenMenus != null && childrenMenus.size()>0){
				result = new ArrayList<MenuView>();
				for(SysMenuInfo item : childrenMenus){
					MenuView temp = new MenuView();
					temp.setMenuId(item.getMenuId());
					temp.setMenuName(item.getMenuName());
					temp.setMenuIcon(item.getMenuIcon());
					temp.setMenuUrl(item.getMenuUrl());
					temp.setParentId(item.getParentId());
					temp.setSubMenu(this.toMenuView(menuList, item.getMenuId()));
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	private List<SysMenuInfo> findChildrenMenus(List<SysMenuInfo> menuList, int parentId){
		List<SysMenuInfo> result = null;
		if(menuList != null && menuList.size()>0){
			result = new ArrayList<SysMenuInfo>();
			for(SysMenuInfo item : menuList){
				if(item.getParentId() == parentId){
					result.add(item);
				}
			}
		}
		return result;
	}	
}
