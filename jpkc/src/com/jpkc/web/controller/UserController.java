package com.jpkc.web.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.model.User;
import com.jpkc.service.UserService;
import com.jpkc.util.VerifyUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Log log = LogFactory.getLog(UserController.class);

	@Resource
	private UserService userService;

	/**
	 * 用户登录
	 * 
	 * @author zhangyi
	 * @2015-11-7
	 */
	@RequestMapping("/login")
	public String getUsers(User user, Model model, HttpServletRequest request) {
		Boolean result = userService.login(user);
		if (result) {
			request.getSession().setAttribute("user", user);
			return "redirect:/user/list";
		} else {
			model.addAttribute("errorMsg", "用户名或密码错误!!");
			return "console/login";
		}
	}

	@RequestMapping("/add")
	public String addUserIndex() {
		return "console/user/add";
	}

	/**
	 * 用户名校验是否存在用户
	 * 
	 * @author zhangyi
	 * @2015-11-7
	 */
	@RequestMapping("/checkUsername")
	public @ResponseBody Render<Object> checkUsername(String username) {
		Render<Object> render = new Render<Object>();
		User user = new User();
		user.setUsername(username);
		List<User> usrList = userService.select(user);
		if (usrList.size() > 0) {
			render.setCode("40001");
		} else {
			render.setCode("20000");
		}
		return render;
	}

	/***
	 * 添加用户
	 * 
	 * @author zhangyi
	 * @2015-11-7
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		String result = userService.addUser(user);
		if ("20000".equals(result)) {
			log.debug("添加用户成功!!");
			return "redirect:/user/list";
		}
		return "redirect:/user/error";
	}

	/**
	 * 用户列表默认分页参数
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list")
	public String list(Model model, String Uname) {
		User user = new User();
		user.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(Uname)) {
			user.setUsername(Uname);
		}
		int pageSize = 10;
		int pageNumber = 1;
		Page<User> page = userService.getUserByPage(user, pageSize, pageNumber);
		model.addAttribute("page", page);
		model.addAttribute("Uname", Uname);

		return "console/user/userlist";
	}

	/**
	 * 用户列表指定分页参数
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String list(Model model, @PathVariable int pageNumber, @PathVariable int pageSize) {
		User user = new User();
		Page<User> page = userService.getUserByPage(user, pageSize, pageNumber);
		model.addAttribute("page", page);
		return "console/user/userlist";
	}

	/**
	 * 删除用户
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/del/{id}")
	public String delUser(@PathVariable int id) {
		User user = new User(id);
		userService.delete(user);
		return "redirect:/user/list";
	}

	/**
	 * 文件上传
	 * 
	 * @author zhangyi
	 * @2015-11-14
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(request.getContextPath() + "/upload/" + fileName);
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
		return "upload";
	}

	@RequestMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "/console/login";
	}
}
