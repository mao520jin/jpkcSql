package com.jpkc.service;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.TeamResourceDao;
import com.jpkc.model.TeamResource;

@Service
public class TeamResourceService {
	private static Log log = LogFactory.getLog(TeamResourceService.class);

	@Resource
	private TeamResourceDao teamResourceDao;

	public Page<TeamResource> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamResourceDao.search(map);
	}

	public boolean delete(Long id) throws SQLException {
		return teamResourceDao.delete(id) > 0;
	}

}