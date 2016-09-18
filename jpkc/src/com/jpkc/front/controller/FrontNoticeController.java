package com.jpkc.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.service.WebsiteNoticeService;

/**
 * 
 * 前端notice
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/frontNotice")
public class FrontNoticeController {
//	@Resource
//	private WebsiteNoticeService noticeService;
//
//	/***
//	 * 公告API
//	 * 
//	 * @param pageNumber
//	 * @param pageSize
//	 * @param request
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("/noticeList")
//	public @ResponseBody Render<Object> noticeList(int pageNumber, int pageSize, HttpServletRequest request, Model model) {
//		pageSize = 10;
//		Render<Object> render = new Render<Object>();
//		Notice notice = new Notice();
//		Page<Notice> page = noticeService.getNoticeByPage(notice, pageSize, pageNumber);
//		render.setData(page);
//		render.setCode("2000");
//		return render;
//	}
//
//	/**
//	 * 公告分页
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/noticesIndex")
//	public String noticeListIndex() {
//		return "/front/notice";
//	}
//
//	/**
//	 * notice 详细
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping("/noticeDetail/{id}")
//	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable String id, Model model) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", id);
//		Notice notice = noticeService.select(map);
//		model.addAttribute("notice", notice);
//		return "/front/noticeDetail";
//	}
}
