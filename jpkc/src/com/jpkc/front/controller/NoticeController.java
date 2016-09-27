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
import com.jpkc.model.WebsiteNotice;
import com.jpkc.service.WebsiteNoticeService;

/**
 * 
 * 前端notice
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/front/notice")
public class NoticeController extends BaseController {

	private static Log log = LogFactory.getLog(NoticeController.class);

	@Resource
	private WebsiteNoticeService noticeService;

	/**
	 * 公告分页
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String noticeListIndex(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		Page<WebsiteNotice> pager = noticeService.search(map);
		model.addAttribute("pager", pager);
		return "/front/website_notice_list";
	}

	/**
	 * notice 详细
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/detail/{id}")
	public String noticeDetail(@PathVariable String id, Model model) {
		WebsiteNotice notice = null;
		try {
			notice = noticeService.select(Long.parseLong(id));
		} catch (Exception e) {
			log.error("查看notice详细", e);
			return null;
		}
		model.addAttribute("notice", notice);
		return "front/website_notice_detail";
	}
}
