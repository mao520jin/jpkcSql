package com.jpkc.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamGroup;
import com.jpkc.service.TeamGroupService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 团队成员
 * 
 * @author zhangyi
 * @version 1.0 2016年2月27日
 */
@Controller
@RequestMapping("/front/group")
public class GroupController extends BaseController {

	private static Log log = LogFactory.getLog(GroupController.class);

	@Resource
	private TeamGroupService teamGroupService;

	/**
	 * 分页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request, String type) {

		// 1=导师，2=学生, 3=课程负责人
		if (!Toolkit.contains(false, type, "kcfzr", "jxtd", "qnjspx")) {
			return "/front/index";
		}

		String nType = null;
		String t = null;

		if ("kcfzr".equals(type)) {
			t = "3";
		}

		if ("qnjspx".equals(type)) {
			nType = "3";
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("type", t);
		map.put("nType", nType);

		Page<TeamGroup> pager = teamGroupService.search(map);
		model.addAttribute("pager", pager);
		model.addAttribute("type", type);

		return "front/team_group_list";
	}

	/**
	 * group 详细
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/detail/{id}")
	public String groupDetail(@PathVariable String id, Model model) {
		TeamGroup teamGroup = null;
		try {
			teamGroup = teamGroupService.select(Long.parseLong(id));
		} catch (Exception e) {
			log.error("查看group详细", e);
			return null;
		}
		model.addAttribute("group", teamGroup);
		return "front/team_group_detail";
	}

}
