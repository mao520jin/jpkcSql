package com.jpkc.web.controller.console;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.controller.BaseController;
import com.jpkc.model.WebsiteNotice;
import com.jpkc.service.WebsiteNoticeService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 公告
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-8
 */
@Controller
@RequestMapping("/console/notice")
public class WebsiteNoticeController extends BaseController {

	private static Log log = LogFactory.getLog(WebsiteNoticeController.class);

	@Resource
	private WebsiteNoticeService websiteNoticeService;

	/**
	 * 分页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {

		String title = request.getParameter("title");

		model.addAttribute("title", title);

		if (!Toolkit.length(title, 1, 64)) {
			title = null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		Page<WebsiteNotice> pager = websiteNoticeService.search(map);
		model.addAttribute("pager", pager);

		return "console/website_notice_list";
	}

	/**
	 * 
	 * 编辑 ->到页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest request) {
		String action = request.getParameter("action");

		if (!"edit".equals(action)) {
			return "console/website_notice_edit";
		}

		String sId = request.getParameter("id");
		if (!Toolkit.isId(sId)) {
			model.addAttribute("render", new Render<String>("55010", "操作异常，请联系管理员！"));
			return "console/website_notice_edit";
		}
		Long id = Long.parseLong(sId);
		WebsiteNotice websiteNotice = null;
		try {
			websiteNotice = websiteNoticeService.select(id);
		} catch (Exception e) {
			model.addAttribute("render", new Render<String>("55020", "操作异常，请联系管理员！"));
			return "console/website_notice_edit";
		}

		if (websiteNotice == null) {
			model.addAttribute("render", new Render<String>("55030", "操作异常，请联系管理员！"));
			return "console/website_notice_edit";
		}

		model.addAttribute("websiteNotice", websiteNotice);
		return "console/website_notice_edit";
	}

	/**
	 * 添加
	 *
	 *
	 * @author zhangyi
	 * @2015-11-12
	 */
	@RequestMapping("/add")
	public @ResponseBody Render<Object> add(WebsiteNotice websiteNotice, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String title = request.getParameter("title");

		if (!Toolkit.length(title, 1, 64)) {
			return new Render<Object>("45010", "标题不合法");
		}
		
		log.info("title:" + title);

		prepare(websiteNotice, request.getSession());
		try {
			websiteNoticeService.save(websiteNotice);
		} catch (Exception e) {
			log.error("保存异常", e);
			return new Render<Object>("45010", "系统异常");
		}

		return new Render<Object>("25010", "保存成功");
	}

	/**
	 *
	 * 删除
	 *
	 * @param ids
	 * @param ra
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody Render<Object> delete(HttpServletRequest request) {
		String ids = request.getParameter("ids"); // ids由逗号和数字组成

		log.debug(String.format("{ids: %s}", ids));

		if (ids == null) {
			log.info("ids：" + ids);
			return new Render<Object>("45010", "操作失败，参数不合法！");
		}

		if (!Pattern.matches("[0-9,]+", ids)) {
			log.info("ids：" + ids);
			return new Render<Object>("45010", "操作失败，参数不合法！");
		}

		String[] idArr = ids.split(",");
		for (String id : idArr) {
			if (!Toolkit.isId(id)) {
				continue;
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			try {
				websiteNoticeService.delete(map);
			} catch (Exception e) {
				log.error("删除公告记录异常", e);
				return new Render<Object>("55010", "系统异常，请联系管理员！");
			}
		}
		return new Render<Object>("25010", "保存成功");
	}
}
