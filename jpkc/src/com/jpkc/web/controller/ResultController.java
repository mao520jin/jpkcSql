package com.jpkc.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.model.Result;
import com.jpkc.model.Team;
import com.jpkc.model.User;
import com.jpkc.service.ResultService;
import com.jpkc.util.VerifyUtil;

/**
 * 
 * 成果 Controller
 * 
 * @author zhangyi
 * @version 1.0 2015年12月28日
 */
@Controller
@RequestMapping("/result")
public class ResultController {

	private static Log log = LogFactory.getLog(ResultController.class);

	@Resource
	private ResultService resultService;

	/**
	 * 
	 * 添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String addIndex(Model model) {
		List<Team> teamList = resultService.getTeam();
		model.addAttribute("teamList", teamList);
		return "/console/result/add";
	}

	/**
	 * 添加结果
	 * 
	 * @author zhangyi
	 * @2015-11-13
	 */
	@RequestMapping("/addResult")
	public String addResult(Model model, Result result, int teamId) {
		User user = new User();
		user.setUsername("123");
		result.setCreateBy(user.getUsername());
		result.setTeamId(teamId);
		resultService.add(result);

		return "redirect:/result/list";
	}

	/**
	 *
	 * 列表
	 * 
	 * @param model
	 * @param memberName
	 * @return
	 */
	@RequestMapping("/list")
	public String resultList(Model model, String memberName, Integer resultType) {
		Team team = new Team();
		if (!VerifyUtil.isEmpty(memberName)) {
			team.setMemberName(memberName);
			team.setDeleteStatus(0);
		}
		Result result = new Result();
		result.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(resultType) && resultType != 0) {
			result.setType(resultType);
		}

		int pageSize = 10;
		int pageNumber = 1;
		Page<Map<String, Object>> page = resultService.getResultByPage(result, team, pageSize, pageNumber);
		model.addAttribute("page", page);
		model.addAttribute("memberName", team.getMemberName());
		model.addAttribute("resultType", resultType);

		return "/console/result/resultlist";
	}

	/***
	 * 
	 * 分页
	 * 
	 * @param model
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String resultList(Model model, @PathVariable int pageNumber, @PathVariable int pageSize) {
		Result result = new Result();
		result.setDeleteStatus(0);

		Team team = new Team();
		team.setDeleteStatus(0);
		Page<Map<String, Object>> page = resultService.getResultByPage(result, team, pageSize, pageNumber);
		model.addAttribute("page", page);
		return "console/result/resultlist";
	}

	/***
	 * API
	 * 
	 * @param model
	 * @param pageNumber
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping("/resultList")
	public Render<Object> resultList(Model model, int pageNumber, int pageSize, int type) {
		Render<Object> render = new Render<Object>();

		Result result = new Result();
		result.setDeleteStatus(0);
		result.setType(type);

		Team team = new Team();
		team.setType(type);
		team.setDeleteStatus(0);
		Page<Map<String, Object>> page = resultService.getResultByPage(result, team, pageSize, pageNumber);
		render.setData(page);
		render.setCode("20000");
		return render;
	}

	/**
	 * 
	 * 编辑
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String editResult(@PathVariable int id, Model model) {
		Result result = new Result();
		result.setId(id);
		List<Map<String, Object>> list = resultService.select(result);
		model.addAttribute("list", list);
		List<Team> teamList = resultService.getTeam();
		model.addAttribute("teamList", teamList);
		return "console/result/add";
	}

	/**
	 * 
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/del/{ids}")
	public String delResult(@PathVariable int[] ids, RedirectAttributes ra) {
		Render<Object> render = new Render<Object>();
		if (VerifyUtil.isEmpty(ids)) {
			log.info("删除资源信息的id是空!");
			render.setCode("20000");
			render.setData("删除资源id是空!");
			ra.addFlashAttribute("render", render);
			return "redirect:/result/list";
		}
		for (int i = 0; i < ids.length; i++) {
			Result result = new Result(ids[i]);
			resultService.delete(result);
		}
		return "redirect:/result/list";
	}
}
