package com.jpkc.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamGroup;
import com.jpkc.model.TeamResource;
import com.jpkc.model.WebsiteNotice;
import com.jpkc.service.TeamGroupService;
import com.jpkc.service.TeamResourceService;
import com.jpkc.service.WebsiteNoticeService;

/**
 * 首页controller
 * 
 * @author zhangyi
 * @version 1.0 2016年2月28日
 */
@Controller
@RequestMapping("/front")
public class FrontController extends BaseController {

	@Resource
	private WebsiteNoticeService noticeService;

	@Resource
	private TeamResourceService teamResourceService;

	@Resource
	private TeamGroupService teamGroupService;

	/**
	 * 首页index
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String frontIndex(HttpServletRequest request, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		// 通知公告
		Page<WebsiteNotice> noticePager = noticeService.search(map);
		model.addAttribute("noticePager", noticePager);

		// 实验教学资料
		map.put("type", 5);
		Page<TeamResource> resourcePager = teamResourceService.search(map);
		model.addAttribute("resourcePager", resourcePager);

		// 滚动图的老师图片
		TeamGroup o = new TeamGroup();
		o.setType(2);
		List<TeamGroup> groupList = null;
		try {
			groupList = teamGroupService.load(o);
		} catch (Exception e) {
		}
		model.addAttribute("groupList", groupList);

		return "/front/index";
	}

	/**
	 * 联系我们
	 * 
	 * @return
	 */
	@RequestMapping("/contact")
	public String contact(HttpServletRequest request, Model model) {
		return "/front/contact";
	}
	
	/**
	 * 申报材料
	 * 
	 * @return
	 */
	@RequestMapping("/declare")
	public String declare(HttpServletRequest request, Model model) {
		return "/front/declare";
	}
}
