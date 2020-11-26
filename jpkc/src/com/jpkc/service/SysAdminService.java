package com.jpkc.service;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.SysAdminDao;
import com.jpkc.model.SysAdmin;
import com.jpkc.util.IDMaker;

@Service
public class SysAdminService {

	private static Log log = LogFactory.getLog(SysAdminService.class);

	@Resource
	private SysAdminDao sysAdminDao;

	public Page<SysAdmin> search(Map<String, Object> map) {
		return sysAdminDao.search(map);
	}

	public SysAdmin save(SysAdmin o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}
	public SysAdmin save(SysAdmin o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}
	public SysAdmin save(SysAdmin o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}
	public SysAdmin save(SysAdmin o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}
	public SysAdmin save(SysAdmin o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = sysAdminDao.insert(o);
		} else {
			row = sysAdminDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}

	public boolean delete(Long id) throws SQLException {
		return sysAdminDao.delete(id) > 0;
	}

	/**
	 * 
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 * 
	 */
	public SysAdmin login(String username, String password) throws SQLException {
		return sysAdminDao.login(username, password);
	}
}
