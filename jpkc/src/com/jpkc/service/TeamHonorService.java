package com.jpkc.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.TeamHonorDao;
import com.jpkc.model.TeamHonor;
import com.jpkc.util.IDMaker;

@Service
public class TeamHonorService {

	private static Log log = LogFactory.getLog(TeamHonorService.class);

	@Resource
	private TeamHonorDao teamHonorDao;

	public Page<TeamHonor> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamHonorDao.search(map);
	}

	@Resource
	private TeamHonorDao teamHonorDao;

	public Page<TeamHonor> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamHonorDao.search(map);
	}

	@Resource
	private TeamHonorDao teamHonorDao;

	public Page<TeamHonor> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamHonorDao.search(map);
	}

	public TeamHonor select(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return teamHonorDao.select(map);
	}

	public Page<TeamHonor> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamHonorDao.search(map);
	}

	public TeamHonor select(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return teamHonorDao.select(map);
	}

	public Page<TeamHonor> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return teamHonorDao.search(map);
	}

	public TeamHonor select(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return teamHonorDao.select(map);
	}

	public TeamHonor save(TeamHonor o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = teamHonorDao.insert(o);
		} else {
			row = teamHonorDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;

	}

	public boolean delete(Long id) throws SQLException {
		return teamHonorDao.delete(id) > 0;
	}

}
