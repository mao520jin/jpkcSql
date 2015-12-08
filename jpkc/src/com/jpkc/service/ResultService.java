package com.jpkc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.jpkc.commons.Page;
import com.jpkc.dao.ResultDao;
import com.jpkc.dao.TeamDao;
import com.jpkc.model.Result;
import com.jpkc.model.Team;
import com.jpkc.util.VerifyUtil;

@Controller
public class ResultService {

	private static Log log = LogFactory.getLog(ResultService.class);

	@Resource
	private ResultDao resultDao;

	@Resource
	private TeamDao teamDao;

	public void add(Result result) {

		int row = 0;
		result.setCreateTime(new Date());
		result.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(result.getId())) {
			// 修改内容
			row = teamDao.edit(result);
			log.debug("修改公告条数： " + row);
		} else {
			// 添加内容
			row = resultDao.add(result);
			log.debug("添加公告条数： " + row);
		}

	}

	public Page<Map<String, Object>> getTeamByPage(Result result, Team team, Integer pageSize, Integer currentPage) {
		result.setDeleteStatus(0);
		return resultDao.getNoticeByPage(result, team, pageSize, currentPage);
	}

	public List<Team> getTeam() {
		return teamDao.getTeam();
	}

	public List<Map<String, Object>> select(Result result) {

		return resultDao.select(result);
	}

	public void delete(Result result) {
		int row = resultDao.delete(result);
		log.debug("删除公告条数： " + row);
	}

}
