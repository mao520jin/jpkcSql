package com.jpkc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.jpkc.commons.Page;
import com.jpkc.dao.TeamDao;
import com.jpkc.model.Team;
import com.jpkc.util.VerifyUtil;

@Controller
public class TeamService {

	private static Log log = LogFactory.getLog(TeamService.class);

	@Resource
	private TeamDao teamDao;

	public void add(Team team) {
		int row = 0;
		team.setCreateTime(new Date());
		team.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(team.getId())) {
			// 修改内容
			row = teamDao.edit(team);
			log.debug("修改公告条数： " + row);
		} else {
			// 添加内容
			row = teamDao.add(team);
			log.debug("添加公告条数： " + row);
		}
	}

	public Page<Team> getTeamByPage(Team team, Integer pageSize, Integer currentPage) {
		team.setDeleteStatus(0);
		return teamDao.getNoticeByPage(team, pageSize, currentPage);
	}

	public List<Team> select(Team team) {
		team.setDeleteStatus(0);
		return teamDao.select(team);
	}

	public void delete(Team team) {
		int row = teamDao.delete(team);
		log.debug("删除公告条数： " + row);
	}
}
