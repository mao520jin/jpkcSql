package com.jpkc.web.controller.console;

import java.util.HashMap;
import java.util.List;
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
import com.jpkc.model.TeamGroup;
import com.jpkc.model.TeamHonor;
import com.jpkc.service.TeamGroupService;
import com.jpkc.service.TeamHonorService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 教学荣誉Controller
 * 
 * @author zhangyi
 * @version 1.0 2015年12月28日
 */
@Controller
@RequestMapping("/console/honor")
public class TeamHonorController extends BaseController {

	private static Log log = LogFactory.getLog(TeamHonorController.class);

	@Resource
	private TeamHonorService teamHonorService;

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

		if (!Toolkit.length(name, 1, 64)) {
			name = null;
		}

		if (!Toolkit.contains(false, type, "1", "2", "3", "4")) {
			type = null;
		}
		model.addAttribute("type", type);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("type", type);
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		Page<TeamHonor> pager = teamHonorService.search(map);
		model.addAttribute("pager", pager);

		return "console/team_honor_list";
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
		List<TeamGroup> teamGroupList = null;
		try {
			teamGroupList = teamGroupService.load(new TeamGroup());
		} catch (Exception e) {
			log.error("加载人员数据异常", e);
			model.addAttribute("render", new Render<String>("55010", "操作异常，请联系管理员！"));
			return "console/team_honor_edit";
		}

		model.addAttribute("list", teamGroupList);

		if (!"edit".equals(action)) {
			return "console/team_honor_edit";
		}

		String sId = request.getParameter("id");
		if (!Toolkit.isId(sId)) {
			model.addAttribute("render", new Render<String>("55010", "操作异常，请联系管理员！"));
			return "console/team_honor_edit";
		}
		Long id = Long.parseLong(sId);
		TeamHonor teamHonor = null;
		try {
			teamHonor = teamHonorService.select(id);
		} catch (Exception e) {
			model.addAttribute("render", new Render<String>("55020", "操作异常，请联系管理员！"));
			return "console/team_honor_edit";
		}

		if (teamHonor == null) {
			model.addAttribute("render", new Render<String>("55030", "操作异常，请联系管理员！"));
			return "console/team_honor_edit";
		}

		model.addAttribute("teamHonor", teamHonor);
		return "console/team_honor_edit";
	}

	/**
	 * 添加
	 *
	 *
	 * @author zhangyi @2015-11-12
	 */
	@RequestMapping("/add")
	public @ResponseBody Render<Object> add(TeamHonor teamHonor, HttpServletRequest request) {
		Long teamGroupId = teamHonor.getTeamGroupId();
		Integer type = teamHonor.getType();

		if (!Toolkit.isId(String.valueOf(teamGroupId))) {
			log.info("请选择项目人");
			return new Render<Object>("45010", "请选择成果人");
		}

		if (!Toolkit.contains(false, String.valueOf(type), "1", "2", "3", "4")) {
			log.info("请选择成果类别");
			return new Render<Object>("45010", "请选择成果类别");
		}

		prepare(teamHonor, request.getSession());
		try {
			teamHonorService.save(teamHonor);
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
		String ids = request.getParameter("ids");

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
				teamHonorService.delete(id);
			} catch (Exception e) {
				log.error("删除教学荣誉记录异常", e);
				return new Render<Object>("55010", "系统异常，请联系管理员！");
			}
		}
		return new Render<Object>("25010", "保存成功");
	}

}
