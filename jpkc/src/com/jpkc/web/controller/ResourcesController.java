package com.jpkc.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.model.Resources;
import com.jpkc.model.User;
import com.jpkc.service.ResourcesService;
import com.jpkc.util.VerifyUtil;

@Controller
@RequestMapping("/resources")
public class ResourcesController {
	
	private static Log log = LogFactory.getLog(ResourcesController.class);
	
	@Resource
	private ResourcesService resourcesService;
	
	/**
	 * 添加
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/add")
	public String addResourcesIndex() {
		
		return "console/resources/add";
	}
	
	@RequestMapping("/addResources")
	public String addResources(Model model,Resources resources) {
		User user = new User();
		user.setUsername("123");
		resources.setCreateBy(user.getUsername());
		resourcesService.add(resources);
		return "redirect:/resources/list";
	}
	
	@RequestMapping("/list")
	public String resourcesList(Model model,String title) {
		Resources resources = new Resources();
		if(!VerifyUtil.isEmpty(title)) {
			resources.setTitle(title);
		}
		int pageNumber = 1;
		int pageSize = 3;
		Page<Resources> page = resourcesService.getResourcesByPage(resources,pageSize,pageNumber);
		model.addAttribute("page", page);
		model.addAttribute("title", title);
		
		return "console/resources/resourceslist";
	}
	
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String resourcesList(Model model,@PathVariable int pageNumber, @PathVariable int pageSize ) {
		Resources resources = new Resources();
		Page<Resources> page = resourcesService.getResourcesByPage(resources,pageSize,pageNumber);
		model.addAttribute("page", page);
		return "console/resources/resourceslist";
	}
	
	@RequestMapping("/edit/{id}")
	public String editResources(@PathVariable int id,Model model) {
		Resources resources = new Resources();
		resources.setId(id);
		List<Resources> resourcesList = resourcesService.select(resources);
		model.addAttribute("resourcesList", resourcesList);
		return "console/resources/add";
	}
	
	@RequestMapping("/del/{id}")
	public String delResources(@PathVariable int id) {
		Resources resources = new Resources();
		resources.setId(id);
		resourcesService.delete(resources);
		return "redirect:/resources/list";
	}
}
