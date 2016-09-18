package com.jpkc.front.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.service.TeamResourceService;

/**
 * 
 * 前端Resources
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/frontResources")
public class FrontResourcesController {
	//
	// @Resource
	// private ResourcesService resourcesService;
	//
	// /**
	// * 资源首页
	// *
	// * @return
	// */
	// @RequestMapping("/resourcesIndex")
	// public String resourcesListIndex(String type, Model model) {
	// model.addAttribute("type", type);
	// return "/front/resources";
	// }
	//
	// /***
	// * 资源分页
	// *
	// * @param pageNumber
	// * @param pageSize
	// * @param request
	// * @return
	// */
	// @RequestMapping("/resourcesList")
	// public @ResponseBody Render<Object> resourcesList(int pageNumber, int
	// pageSize, HttpServletRequest request, String type) {
	// pageSize = 10;
	// Render<Object> render = new Render<Object>();
	// Resources resources = new Resources();
	// resources.setType(Integer.parseInt(type));
	// Page<Resources> page = resourcesService.getResourcesByPage(resources,
	// pageSize, pageNumber);
	// render.setData(page);
	// render.setCode("20000");
	// return render;
	// }

}
