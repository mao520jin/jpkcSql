package com.jpkc.web.controller.console;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.controller.BaseController;
import com.jpkc.model.SysAdmin;
import com.jpkc.service.SysAdminService;
import com.jpkc.util.Toolkit;

/**
 * 用户
 * 
 * @author zhangyi
 * @version 1.0 2016年2月27日
 */
@Controller
@RequestMapping("/console/sysadmin")
public class SysAdminController extends BaseController {
	private static Log log = LogFactory.getLog(SysAdminController.class);

	@Resource
	private SysAdminService sysAdminService;

	/**
	 * 分页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {

		String username = request.getParameter("username");
		String status = request.getParameter("status");

		model.addAttribute("username", username);

		if (!Toolkit.length(username, 1, 64)) {
			username = null;
		}

		if (!Toolkit.contains(false, status, "0", "1")) {
			status = null;
		}

		model.addAttribute("status", status);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("username", username);
		map.put("status", status);

		Page<SysAdmin> pager = sysAdminService.search(map);
		model.addAttribute("pager", pager);

		return "console/sys_admin";
	}

	/**
	 * 添加
	 *
	 * @author zhangyi
	 * @2015-11-12
	 */
	@RequestMapping("/save")
	public @ResponseBody Render<Object> save(SysAdmin sysAdmin, HttpServletRequest request) {
		prepare(sysAdmin, request.getSession());
		try {
			sysAdminService.save(sysAdmin);
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
	public @ResponseBody Render<Object> delNotice(HttpServletRequest request) {
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
		for (String sId : idArr) {
			if (!Toolkit.isId(sId)) {
				continue;
			}

			Long id = Long.parseLong(sId);

			try {
				sysAdminService.delete(id);
			} catch (Exception e) {
				log.error("删除公告记录异常", e);
				return new Render<Object>("55010", "系统异常，请联系管理员！");
			}
		}
		return new Render<Object>("25010", "保存成功");
	}

}
