package com.jpkc.web.controller.console;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpkc.commons.JSONRender;
import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamGroup;
import com.jpkc.service.TeamGroupService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 团队成员
 * 
 * @author zhangyi
 * @version 1.0 2016年2月27日
 */
@Controller
@RequestMapping("/console/group")
public class TeamGroupController extends BaseController {

	private static Log log = LogFactory.getLog(TeamGroupController.class);

	@Resource
	private TeamGroupService teamGroupService;

	/**
	 * 分页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {

		String name = request.getParameter("name");
		String type = request.getParameter("type");

		model.addAttribute("name", name);
		model.addAttribute("type", type);

		if (!Toolkit.length(name, 1, 64)) {
			name = null;
		}

		if (!Toolkit.contains(false, type, "1", "2", "3")) {
			type = null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("name", name);
		map.put("type", type);

		Page<TeamGroup> pager = teamGroupService.search(map);
		model.addAttribute("pager", pager);

		return "console/team_group_list";
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
			return "console/team_group_edit";
		}

		String sId = request.getParameter("id");
		if (!Toolkit.isId(sId)) {
			model.addAttribute("render", new Render<String>("55010", "操作异常，请联系管理员！"));
			return "console/team_group_edit";
		}
		Long id = Long.parseLong(sId);
		TeamGroup teamGroup = null;
		try {
			teamGroup = teamGroupService.select(id);
		} catch (Exception e) {
			model.addAttribute("render", new Render<String>("55020", "操作异常，请联系管理员！"));
			return "console/team_group_edit";
		}

		if (teamGroup == null) {
			model.addAttribute("render", new Render<String>("55030", "操作异常，请联系管理员！"));
			return "console/team_group_edit";
		}

		model.addAttribute("teamGroup", teamGroup);
		return "console/team_group_edit";
	}

	/**
	 * 添加
	 *
	 *
	 * @author zhangyi @2015-11-12
	 */
	@RequestMapping("/add")
	public @ResponseBody Render<Object> add(@RequestParam(value = "image") MultipartFile image, TeamGroup teamGroup, HttpServletRequest request) {
		if (teamGroup == null) {
			return new Render<Object>("45010", "参数不合法！");
		}

		String name = teamGroup.getName();
		String about = teamGroup.getAbout();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
			teamGroup.setName(name);
			about = new String(about.getBytes("iso-8859-1"), "utf-8");
			teamGroup.setAbout(about);
		} catch (Exception e) {
		}
		String email = teamGroup.getEmail();
		String mobile = teamGroup.getMobile();
		String type = teamGroup.getType() + "";

		if (!Toolkit.length(name, 1, 64)) {
			return new Render<Object>("45010", "成员姓名不合法！");
		}

		if (!Toolkit.isEmpty(email) && !Pattern.matches("([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})", email)) {
			log.info("邮箱格式不正确，email：" + email);
			return new Render<Object>("45020", "邮箱格式不正确！");
		}

		if (!Toolkit.isMobile(mobile)) {
			return new Render<Object>("45030", "电话格式不正确！");
		}

		if (Toolkit.isEmpty(about)) {
			return new Render<Object>("45040", "成员简介不合法，不能为空！");
		}

		if (!Toolkit.contains(false, type, "1", "2", "3")) {
			return new Render<Object>("45050", "成员类别不合法！");
		}

		// 允许上传文件后缀MAP数组
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp,GIF,JPG,JPEG,PNG,BMP");
		// sizeMap.put("image", 10 * 1024 * 1024l);

		if (image.getSize() != 0) {

			String ext = FilenameUtils.getExtension(image.getOriginalFilename());
			// 检查上传文件类型
			if (!Arrays.<String>asList(extMap.get("image").split(",")).contains(ext)) {
				return new Render<Object>("45050", "上传文件的格式 只支持:gif, jpg, jpeg, png, bmp, GIF, JPG, JPEG, PNG, BMP ！");
			}

			// 检查上传文件的大小
			if (image.getSize() > 1 * 1024 * 1024l) {
				return new Render<Object>("45050", "上传文件大小最大2M！");
			}

			// String path = "D://upload//group//" + type + File.separator +
			// mobile + "//"; //win
			String path = "//home//upload//group//" + type + File.separator + mobile + "//"; // linux
			// 获取该文件的文件名
			String fileName = image.getOriginalFilename();
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				image.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teamGroup.setPhoto(path + fileName);
		}

		prepare(teamGroup, request.getSession());
		try {
			teamGroupService.save(teamGroup);
		} catch (Exception e) {
			log.error("保存异常", e);
			return new Render<Object>("55010", "系统异常！");
		}

		return new Render<Object>("25010", "保存成功！");
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
		for (String sId : idArr) {
			if (!Toolkit.isId(sId)) {
				continue;
			}

			Long id = Long.parseLong(sId);
			try {
				teamGroupService.delete(id);
			} catch (Exception e) {
				log.error("删除团队成员记录异常", e);
				return new Render<Object>("55010", "系统异常，请联系管理员！");
			}
		}
		return new Render<Object>("25010", "保存成功");
	}

	@RequestMapping("/load")
	public @ResponseBody Render<Object> load(HttpServletRequest request) {
		try {
			List<TeamGroup> list = teamGroupService.load(new TeamGroup());
			return new JSONRender<Object>("25010", list);
		} catch (Exception e) {
			log.error("删除团队成员记录异常", e);
			return new Render<Object>("55010", "系统异常，请联系管理员！");
		}
	}
}
