package com.jpkc.web.controller.console;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.jpkc.util.MD;
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
				log.error("删除管理员记录异常", e);
				return new Render<Object>("55010", "系统异常，请联系管理员！");
			}
		}
		return new Render<Object>("25010", "保存成功");
	}

	/**
	 *
	 * 管理员登陆
	 *
	 * @param ids
	 * @param ra
	 * @return
	 */
	@RequestMapping("/loginIn")
	public @ResponseBody Render<Object> loginIn(HttpServletRequest request) {
		log.debug("管理员 -> 登录");

		// return new Render<Object>("25010", "保存成功");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("username", username);
		request.setAttribute("password", password);

		log.info(String.format("系统后台登录参数：{ username: %s, password: %s}", username, password));

		if (!Toolkit.isUsername(username)) {
			log.info("账号应为3~32位，由字母、数字、下划线组成，username： " + username);
			return new Render<Object>("45010", "账号应为3~32位，由字母、数字、下划线组成！");
		}

		if (!Toolkit.isPassword(password)) {
			log.info("密码应为3~32位，由字母、数字、下划线组成，password：" + password);
			return new Render<Object>("45020", "密码应为3~32位，由字母、数字、下划线组成！");
		}

		SysAdmin sysAdmin = null;
		try {
			sysAdmin = sysAdminService.login(username, MD.md5(password));
		} catch (Exception e) {
		}

		if (sysAdmin == null) {
			log.info("用户名或密码错误！");
			return new Render<Object>("45040", "用户名或密码错误！");

		}

		log.info("管理员： " + username + "，系统后台登录！");

		SysAdmin user = new SysAdmin();
		user.setUsername(sysAdmin.getUsername());
		user.setPassword(sysAdmin.getPassword());
		user.setStatus(sysAdmin.getStatus());
		user.setDesc(sysAdmin.getDesc());
		user.setCreatedBy(sysAdmin.getCreatedBy());
		user.setCreatedDate(sysAdmin.getCreatedDate());
		user.setLastModifiedBy(sysAdmin.getLastModifiedBy());
		user.setLastModifiedDate(sysAdmin.getLastModifiedDate());

		HttpSession session = request.getSession();
		session.removeAttribute("sysAdmin");

		session.setAttribute("sysAdmin", user);
		return new Render<Object>("25001", "成功登陆");
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		return "console/login";
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("sysAdmin");
		return "console/login";
	}

}
