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

import com.jpkc.commons.Page;
import com.jpkc.model.Result;
import com.jpkc.model.Team;
import com.jpkc.model.User;
import com.jpkc.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController {

	private static Log log = LogFactory.getLog(ResultController.class);

	@Resource
	private ResultService resultService;

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

	@RequestMapping("/list")
	public String resultList(Model model, Team team, Integer pageSize, Integer currentPage) {
		Result result = new Result();
		currentPage = 1;
		pageSize = 3;
		Page<Object> page = resultService.getTeamByPage(result, team, pageSize, currentPage);
		model.addAttribute("page", page);
		model.addAttribute("memberName", team.getMemberName());

		return "/console/result/resultlist";
	}

	@RequestMapping("/list/{currentPage}/{pageSize}")
	public String resultList(Model model, Team team, @PathVariable int currentPage, @PathVariable int pageSize) {
		Result result = new Result();
		Page<Object> page = resultService.getTeamByPage(result, team, pageSize, currentPage);
		model.addAttribute("page", page);
		return "console/result/resultlist";
	}

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

	@RequestMapping("/del/{id}")
	public String delResult(@PathVariable int id) {
		Result result = new Result();
		result.setId(id);
		resultService.delete(result);
		return "redirect:/result/list";
	}
}
