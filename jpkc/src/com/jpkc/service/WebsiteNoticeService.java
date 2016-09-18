package com.jpkc.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.WebsiteNoticeDao;
import com.jpkc.model.WebsiteNotice;
import com.jpkc.util.IDMaker;

@Service
public class WebsiteNoticeService {
	private static Log log = LogFactory.getLog(WebsiteNoticeService.class);

	@Resource
	private WebsiteNoticeDao websiteNoticeDao;

	/**
	 * 
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * 
	 */
	public Page<WebsiteNotice> search(Map<String, Object> map) {
		log.debug("map: " + map);
		return websiteNoticeDao.search(map);
	}

	public WebsiteNotice select(Long id) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return websiteNoticeDao.select(map);
	}

	public WebsiteNotice save(WebsiteNotice o) throws SQLException {
		int row = 0;
		if (o.getId() == null) {
			o.setId(IDMaker.make());
			row = websiteNoticeDao.insert(o);
		} else {
			row = websiteNoticeDao.update(o);
		}
		log.info("row: " + row);
		return row > 0 ? o : null;
	}

	public boolean delete(Map<String, Object> map) throws SQLException {
		return websiteNoticeDao.delete(map) > 0;
	}

}
