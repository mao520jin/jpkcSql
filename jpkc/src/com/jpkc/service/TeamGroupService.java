package com.jpkc.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.TeamGroupDao;
import com.jpkc.model.TeamGroup;
import com.jpkc.util.IDMaker;

/**
 * 
 * team_group
 * 
 * @author zhangyi
 * @version 1.0 2016年3月6日
 */
@Service
public class TeamGroupService {

	private static Log log = LogFactory.getLog(TeamGroupService.class);

	@Resource
	private TeamGroupDao teamGroupDao;

	public Page<TeamGroup> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamGroupDao.search(map);
	}

	public TeamGroup select(Long id) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return teamGroupDao.select(map);
	}

	public TeamGroup save(TeamGroup o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = teamGroupDao.insert(o);
		} else {
			row = teamGroupDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}

	public boolean delete(Long id) throws SQLException {
		return teamGroupDao.delete(id) > 0;
	}

	public List<TeamGroup> load() throws SQLException {
		return teamGroupDao.select(new TeamGroup());
	}

}
