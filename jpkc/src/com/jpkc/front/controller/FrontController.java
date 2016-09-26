package com.jpkc.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamResource;
import com.jpkc.model.WebsiteNotice;
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

		map.put("type", 5);
		Page<TeamResource> resourcePager = teamResourceService.search(map);
		model.addAttribute("resourcePager", resourcePager);

		return "/front/index";
	}
	//
	// /**
	// *
	// * 通告
	// *
	// * @param request
	// * @return
	// */
	// @RequestMapping("/loadNotice")
	// public @ResponseBody Render<Object> loadNotice(HttpServletRequest
	// request) {
	//
	// Notice notice = new Notice();
	// List<Notice> noticeList = noticeService.select(notice);
	// Render<Object> render = new Render<Object>();
	// render.setCode("20000");
	// render.setData(noticeList);
	// return render;
	// }
}
