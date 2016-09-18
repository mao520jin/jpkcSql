package com.jpkc.front.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpkc.commons.Render;
import com.jpkc.service.WebsiteNoticeService;

/**
 * 首页controller
 * 
 * @author zhangyi
 * @version 1.0 2016年2月28日
 */
@Controller
@RequestMapping("/front")
public class FrontController {

//	@Resource
//	private WebsiteNoticeService noticeService;
//
//	/**
//	 * 首页index
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/index")
//	public String frontIndex(Model model) {
//		return "/front/index";
//	}
//	
//	/**
//	 * 
//	 * 通告
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping("/loadNotice")
//	public @ResponseBody Render<Object> loadNotice(HttpServletRequest request) {
//		
//		Notice notice = new Notice();
//		List<Notice> noticeList = noticeService.select(notice);
//		Render<Object> render = new Render<Object>();
//		render.setCode("20000");
//		render.setData(noticeList);
//		return render;
//	}
}
