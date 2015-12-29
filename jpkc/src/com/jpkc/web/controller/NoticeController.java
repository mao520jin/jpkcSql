package com.jpkc.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.model.Notice;
import com.jpkc.model.User;
import com.jpkc.service.NoticeService;
import com.jpkc.util.VerifyUtil;

/**
 * 
 * 公告
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-8
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

	private static Log log = LogFactory.getLog(NoticeController.class);

	@Resource
	private NoticeService noticeService;

	/**
	 * 添加公告
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/add")
	public String addNoticeIndex() {

		return "console/notice/add";
	}

	/**
	 * 公告列表
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list")
	public String noticeList(Model model, String title) {
		Notice notice = new Notice();
		if (!VerifyUtil.isEmpty(title)) {
			notice.setTitle(title);
		}
		int pageNumber = 0;
		int pageSize = 0;
		Page<Notice> page = noticeService.getNoticeByPage(notice, pageSize, pageNumber);
		model.addAttribute("page", page);
		model.addAttribute("title", title);

		return "console/notice/noticelist";
	}

	/**
	 * 公告列表
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String noticeList(Model model, String content, @PathVariable int pageNumber, @PathVariable int pageSize) {
		Notice notice = new Notice();
		Page<Notice> page = noticeService.getNoticeByPage(notice, pageSize, pageNumber);
		model.addAttribute("page", page);
		return "console/notice/noticelist";
	}

	/***
	 * 公告API
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/noticeList")
	public void noticeList(int pageNumber, int pageSize, HttpServletRequest request, HttpServletResponse response) {
		Render<Object> render = new Render<Object>();
		Notice notice = new Notice();
		Page<Notice> page = noticeService.getNoticeByPage(notice, pageSize, pageNumber);
		render.setData(page);
		render.setCode("2000");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(render.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加公告
	 * 
	 * 
	 * @author zhangyi
	 * @2015-11-12
	 */
	@RequestMapping("/addNotice")
	public String addNotice(Notice notice) {
		User user = new User();
		user.setUsername("123");
		notice.setCreateBy(user.getUsername());
		noticeService.add(notice);
		return "redirect:/notice/list";
	}

	@RequestMapping("/edit/{id}")
	public String editNotice(@PathVariable int id, Model model) {
		Notice notice = new Notice();
		notice.setId(id);
		List<Notice> noticeList = noticeService.select(notice);
		model.addAttribute("noticeList", noticeList);
		return "console/notice/add";
	}

	@RequestMapping("/del/{ids}")
	public String delNotice(@PathVariable int[] ids, RedirectAttributes ra) {
		Render<Object> render = new Render<Object>();
		if (VerifyUtil.isEmpty(ids)) {
			log.info("删除资源信息的id是空!");
			render.setCode("20000");
			render.setData("删除资源id是空!");
			ra.addFlashAttribute("render", render);
			return "redirect:/notice/list";
		}

		for (int i = 0; i < ids.length; i++) {
			Notice notice = new Notice(ids[i]);
			noticeService.delete(notice);
		}
		return "redirect:/notice/list";
	}
}
