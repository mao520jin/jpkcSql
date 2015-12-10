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
import com.jpkc.commons.Render;
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
	public String teamList(Model model,String memberName) {
		Team team = new Team();
		if(!VerifyUtil.isEmpty(memberName)) {
			team.setMemberName(memberName);
		}
		int pageSize = 10;
		int pageNumber= 1;
		Page<Team> page = teamService.getTeamByPage(team,pageSize,pageNumber);
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
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String teamList(Model model,@PathVariable int pageNumber, @PathVariable int pageSize ) {
		Team team = new Team();
		Page<Team> page = teamService.getTeamByPage(team,pageSize,pageNumber);
		model.addAttribute("page", page);
		return "console/team/teamlist";
	}
	
	/**
	 * 团队成员列表API
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/teamList")
	public Render<Object> teamList(Model model,int pageNumber,int pageSize,int type) {
		Render<Object> render = new Render<Object>();
		Team team = new Team();
		team.setType(type);
		Page<Team> page = teamService.getTeamByPage(team,pageSize,pageNumber);
		render.setData(page);
		render.setCode("20000");
		return render;
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
