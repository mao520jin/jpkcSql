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
import com.jpkc.model.TeamHonor;
import com.jpkc.service.TeamHonorService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 前端honor
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/front/honor")
public class HonorController extends BaseController {

	@Resource
	private TeamHonorService teamHonorService;

	/**
	 * 荣誉首页
	 *
	 * @return
	 */
	@RequestMapping("/list")
	public String honorList(HttpServletRequest request, String type, Model model) {

		if (!Toolkit.contains(false, type, "kyxm", "xszz", "jlzz", "cgzs")) {
			return "/front/index";
		}

		int t = 0;
		String url = "/front/index";

		// 科研项目
		if ("kyxm".equalsIgnoreCase(type)) {
			t = 1;
			url = "/front/team_honor_kyxm_list";
		}

		// 学术著作
		if ("xszz".equalsIgnoreCase(type)) {
			t = 2;
			url = "/front/team_honor_xszz_list";
		}

		// 奖励资助
		if ("jlzz".equalsIgnoreCase(type)) {
			t = 3;
			url = "/front/team_honor_jlzz_list";
		}

		// 学生成果展示
		if ("cgzs".equalsIgnoreCase(type)) {
			t = 4;
			url = "/front/team_honor_cgzs_list";
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("type", t); // 已转换

		Page<TeamHonor> pager = teamHonorService.search(map);
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
		TeamHonor teamHonor = null;
		try {
			teamHonor = teamHonorService.select(Long.parseLong(id));
		} catch (Exception e) {
			return "/front/index";
		}
		model.addAttribute("teamHonor", teamHonor);
		return "/front/team_resource_detail";
	}

}
