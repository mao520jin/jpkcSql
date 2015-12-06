package com.jpkc.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.model.Notice;
import com.jpkc.model.Team;
import com.jpkc.model.User;
import com.jpkc.service.TeamService;
import com.jpkc.util.VerifyUtil;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	private static Log log = LogFactory.getLog(TeamController.class);
	
	@Resource
	private TeamService teamService;
	
	
	/**
	 * 团队成员列表
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list")
	public String teamList(Model model,String memberName,Integer pageSize, Integer currentPage) {
		Team team = new Team();
		if(!VerifyUtil.isEmpty(memberName)) {
			team.setMemberName(memberName);
		}
		currentPage = 1;
		pageSize = 3;
		Page<Team> page = teamService.getTeamByPage(team,pageSize,currentPage);
		model.addAttribute("page", page);
		model.addAttribute("memberName", memberName);
		
		return "/console/team/teamlist";
	}
	
	/**
	 * 团队成员列表
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/list/{currentPage}/{pageSize}")
	public String teamList(Model model,@PathVariable int currentPage, @PathVariable int pageSize ) {
		Team team = new Team();
		Page<Team> page = teamService.getTeamByPage(team,pageSize,currentPage);
		model.addAttribute("page", page);
		return "console/team/teamlist";
	}
	
	/**
	 * 添加
	 * 
	 * @author zhangyi
	 * @2015-11-13
	 */
	@RequestMapping("/add")
	public String addIndex() {
		
		return "/console/team/add";
	}
	
	/**
	 * 添加成员
	 * 
	 * @author zhangyi
	 * @2015-11-13
	 */
	@RequestMapping("/addTeam")
	public String addTeam(Model model,Team team) {
		User user = new User();
		user.setUsername("123");
		team.setCreateBy(user.getUsername());
		teamService.add(team);
		
		return "redirect:/team/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editTeam(@PathVariable int id,Model model) {
		Team team = new Team();
		team.setId(id);
		List<Team> teamList = teamService.select(team);
		model.addAttribute("teamList", teamList);
		return "console/team/add";
	}
	
	@RequestMapping("/del/{id}")
	public String delNotice(@PathVariable int id) {
		Team team = new Team();
		team.setId(id);
		teamService.delete(team);
		return "redirect:/team/list";
	}
}
