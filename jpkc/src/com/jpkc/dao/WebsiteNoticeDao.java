package com.jpkc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.WebsiteNotice;
import com.jpkc.util.DateUtil;

/**
 * 
 * notice
 * 
 * @author zhangyi
 * @version 1.0 2016年3月6日
 */
@Repository
public class WebsiteNoticeDao implements Dao<WebsiteNotice> {
	private static Log log = LogFactory.getLog(WebsiteNoticeDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * website_notice 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class WebsiteNoticeMapper implements RowMapper<WebsiteNotice> {

		public WebsiteNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
			WebsiteNotice websiteNotice = new WebsiteNotice();
			websiteNotice.setId(rs.getLong("id"));
			websiteNotice.setTitle(rs.getString("title"));
			websiteNotice.setContent(rs.getString("content"));
			websiteNotice.setDesc(rs.getString("desc"));
			websiteNotice.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			websiteNotice.setCreatedBy(rs.getString("createdBy"));
			websiteNotice.setLastModifiedBy(rs.getString("lastModifiedBy"));
			websiteNotice.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));

			return websiteNotice;
		}
	}

	@Override
	public int insert(WebsiteNotice o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `website_notice` (");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`content`");
		sql.append(",").append("`desc`");
		sql.append(",").append("`created_by`");
		sql.append(",").append("`created_date`");
		sql.append(",").append("`last_modified_by`");
		sql.append(",").append("`last_modified_date`");
		sql.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

		List<Object> params = new ArrayList<Object>();
		params.add(o.getId());
		params.add(o.getTitle());
		params.add(o.getContent());
		params.add(o.getDesc());
		params.add(o.getCreatedBy());
		params.add(o.getCreatedDate());
		params.add(o.getLastModifiedBy());
		params.add(o.getLastModifiedDate());

		log.info("sql: " + sql);
		log.info("params: " + params);

		return jdbcTemplate.update(sql.toString(), params.toArray());
	}

	@Override
	public int delete(WebsiteNotice o) throws SQLException {
		return 0;
	}

	/**
	 * 
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public int delete(Map<String, Object> map) throws SQLException {

		if (map == null || map.isEmpty()) {
			return -1;
		}

		Object id = map.get("id");

		if (id == null) {
			return -1;
		}

		StringBuffer sql = new StringBuffer();

		sql.append("DELETE FROM `website_notice` WHERE 1 = 1");

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (id != null) {
			sql.append(" AND `id` = :id");
			paramMap.put("id", id);
		}

		log.info("sql: " + sql);
		log.info("params: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql.toString(), paramMap);

	}

	@Override
	public int update(WebsiteNotice o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		sql.append("UPDATE `website_notice` SET `id` = :id");
		paramMap.put("id", o.getId());

		if (o.getTitle() != null) {
			sql.append(", `title` = :title");
			paramMap.put("title", o.getTitle());
		}

		if (o.getContent() != null) {
			sql.append(", `content` = :content");
			paramMap.put("content", o.getContent());
		}

		if (o.getDesc() != null) {
			sql.append(", `desc` = :desc");
			paramMap.put("desc", o.getDesc());
		}

		if (o.getLastModifiedBy() != null) {
			sql.append(", `last_modified_by` = :last_modified_by");
			paramMap.put("last_modified_by", o.getLastModifiedBy());
		}

		if (o.getLastModifiedDate() != null) {
			sql.append(", `last_modified_date` = :last_modified_date");
			paramMap.put("last_modified_date", o.getLastModifiedDate());
		}

		sql.append(" WHERE `id` = :id");
		paramMap.put("id", o.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql.toString(), paramMap);

	}

	@Override
	public List<WebsiteNotice> select(WebsiteNotice o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`content`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`website_notice`").append(" AS ").append("t");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> params = new ArrayList<Object>();

		sql.append(" ORDER BY t.`id` asc");

		log.info("sql: " + sql);
		log.info("params: " + params);
		return jdbcTemplate.query(sql.toString(), params.toArray(), new WebsiteNoticeMapper());
	}

	/**
	 * 
	 * 查询单个对象
	 * 
	 * @param map
	 * @return
	 */
	public WebsiteNotice select(Map<String, Object> map) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`content`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`website_notice`").append(" AS ").append("t");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object id = map.get("id");
		if (id != null) {
			sql.append(" AND t.`id` = ?");
			params.add(id);
		}

		return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), new WebsiteNoticeMapper());
	}

	/**
	 * 分页
	 * 
	 * @param map
	 * @return
	 */
	public Page<WebsiteNotice> search(Map<String, Object> map) {

		int pageNumber = Integer.parseInt("" + map.get("pageNumber"));
		int pageSize = Integer.parseInt("" + map.get("pageSize"));

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`content`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`website_notice`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object title = map.get("title");
		if (title != null) {
			sql.append(" AND t.`title` LIKE ?");
			params.add("%" + title + "%");
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("t.`id` DESC");

		log.info("sql: " + sql);
		log.info("params: " + params);

		return new MySQLPage<WebsiteNotice>(pageNumber, pageSize, jdbcTemplate, sql.toString(), new WebsiteNoticeMapper(), params.toArray());

	}

}
