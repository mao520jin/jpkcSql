package com.jpkc.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamResource;
import com.jpkc.service.TeamResourceService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 前端Resources
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/front/resource")
public class ResourcesController extends BaseController {

	@Resource
	private TeamResourceService teamResourceService;

	/**
	 * 资源首页
	 *
	 * @return
	 */
	@RequestMapping("/list")
	public String resourcesList(HttpServletRequest request, String type, Model model) {

		if (!Toolkit.contains(false, type, "dzja", "jxkj", "jxsp", "jxdg", "syjx")) {
			return "/front/index";
		}

		int t = 0;
		String url = "/front/index";

		if ("dzja".equalsIgnoreCase(type)) {
			t = 1;
			url = "/front/team_resource_dzja_list";
		}

		// 教学课件
		if ("jxkj".equalsIgnoreCase(type)) {
			t = 2;
			url = "/front/team_resource_jxkj_list";
		}

		// 教学视频
		if ("jxsp".equalsIgnoreCase(type)) {
			t = 3;
			url = "/front/team_resource_jxsp_list";
		}

		// 教学大纲
		if ("jxdg".equalsIgnoreCase(type)) {
			t = 4;
			url = "/front/team_resource_jxdg_list";
		}

		// 实验教学资料
		if ("syjx".equalsIgnoreCase(type)) {
			t = 5;
			url = "/front/team_resource_syjx_list";
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("isconvert", 2); // 已转换
		map.put("type", t); // 已转换

		Page<TeamResource> pager = teamResourceService.search(map);
		model.addAttribute("pager", pager);

		return url;
	}

	/**
	 * 详细
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/detail/{id}")
	public String noticeDetail(@PathVariable String id, Model model) {
		TeamResource resource = null;
		try {
			resource = teamResourceService.select(Long.parseLong(id));
		} catch (Exception e) {

		}
		model.addAttribute("resource", resource);

		String url = "/front/index";

		if (resource == null) {
			return url;
		}

		int type = resource.getType();

		// 1=电子教案,2=教学课件,3=教学视频,4=教学大纲 ,5=实验教学资料
		// 电子教案
		if (type == 3) {
			url = "/front/team_resource_flv_detail";
		} else {
			url = "/front/team_resource_office_detail";
		}

		return url;
	}

}
