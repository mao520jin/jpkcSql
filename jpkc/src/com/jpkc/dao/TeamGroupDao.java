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
import com.jpkc.model.TeamGroup;
import com.jpkc.util.DateUtil;

/**
 * 
 * team_group
 * 
 * @author zhangyi
 * @version 1.0 2016年3月6日
 */
@Repository
public class TeamGroupDao implements Dao<TeamGroup> {
	private static Log log = LogFactory.getLog(TeamGroupDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * team_group 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class TeamGroupMapper implements RowMapper<TeamGroup> {

		public TeamGroup mapRow(ResultSet rs, int rowNum) throws SQLException {

			TeamGroup team = new TeamGroup();
			team.setId(rs.getLong("id"));
			team.setName(rs.getString("name"));
			team.setType(rs.getInt("type"));
			team.setAbout(rs.getString("about"));
			team.setPhoto(rs.getString("photo"));
			team.setEmail(rs.getString("email"));
			team.setMobile(rs.getString("mobile"));
			team.setDesc(rs.getString("desc"));
			team.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			team.setCreatedBy(rs.getString("createdBy"));
			team.setLastModifiedBy(rs.getString("lastModifiedBy"));
			team.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));

			return team;
		}

	}

	@Override
	public int insert(TeamGroup o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `team_group` (");
		sql.append(" ").append("`id`");
		sql.append(",").append("`name`");
		sql.append(",").append("`type`");
		sql.append(",").append("`about`");
		sql.append(",").append("`photo`");
		sql.append(",").append("`email`");
		sql.append(",").append("`mobile`");
		sql.append(",").append("`desc`");
		sql.append(",").append("`created_by`");
		sql.append(",").append("`created_date`");
		sql.append(",").append("`last_modified_by`");
		sql.append(",").append("`last_modified_date`");
		sql.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		List<Object> params = new ArrayList<Object>();
		params.add(o.getId());
		params.add(o.getName());
		params.add(o.getType());
		params.add(o.getAbout());
		params.add(o.getPhoto());
		params.add(o.getEmail());
		params.add(o.getMobile());
		params.add(o.getDesc());
		params.add(o.getCreatedBy());
		params.add(o.getCreatedDate());
		params.add(o.getLastModifiedBy());
		params.add(o.getLastModifiedDate());

		log.info("sql: " + sql);
		log.info("params: " + params);

		int row = jdbcTemplate.update(sql.toString(), params.toArray());
		return row;
	}

	@Override
	public int delete(TeamGroup o) throws SQLException {
		return 0;
	}

	public int delete(Long id) throws SQLException {

		String sql = "DELETE FROM `team_group` WHERE `id` = ?";

		List<Object> params = new ArrayList<Object>();
		params.add(id);

		log.info("sql: " + sql);
		log.info("params: " + params);

		return this.jdbcTemplate.update(sql, params.toArray());

	}

	@Override
	public int update(TeamGroup o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		sql.append("UPDATE `team_group` SET `id` = :id");
		paramMap.put("id", o.getId());

		if (o.getName() != null) {
			sql.append(", `name` = :name");
			paramMap.put("name", o.getName());
		}

		if (o.getType() != null) {
			sql.append(", `type` = :type");
			paramMap.put("type", o.getType());
		}

		if (o.getAbout() != null) {
			sql.append(", `about` = :about");
			paramMap.put("about", o.getAbout());
		}

		if (o.getPhoto() != null) {
			sql.append(", `photo` = :photo");
			paramMap.put("photo", o.getPhoto());
		}

		if (o.getEmail() != null) {
			sql.append(", `email` = :email");
			paramMap.put("email", o.getEmail());
		}

		if (o.getMobile() != null) {
			sql.append(", `mobile` = :mobile");
			paramMap.put("mobile", o.getMobile());
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
	public List<TeamGroup> select(TeamGroup o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`photo`");
		sql.append(",").append("t.`email`");
		sql.append(",").append("t.`mobile`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_group`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();
		if (o.getType() != null) {
			sql.append(" AND t.`type` = ?");
			params.add(o.getType());
		}
		sql.append(" ORDER BY t.`id` asc");

		log.info("sql: " + sql);
		log.info("params: " + params);
		return jdbcTemplate.query(sql.toString(), params.toArray(), new TeamGroupMapper());
	}

	/**
	 * 
	 * 查询单个对象
	 * 
	 * @param map
	 * @return
	 */
	public TeamGroup select(Map<String, Object> map) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`photo`");
		sql.append(",").append("t.`email`");
		sql.append(",").append("t.`mobile`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_group`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object id = map.get("id");
		if (id != null) {
			sql.append(" AND t.`id` = ?");
			params.add(id);
		}

		return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), new TeamGroupMapper());
	}

	/**
	 * 分页
	 * 
	 * @param map
	 * @return
	 */
	public Page<TeamGroup> search(Map<String, Object> map) {

		int pageNumber = Integer.parseInt("" + map.get("pageNumber"));
		int pageSize = Integer.parseInt("" + map.get("pageSize"));

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`photo`");
		sql.append(",").append("t.`email`");
		sql.append(",").append("t.`mobile`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_group`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object name = map.get("name");
		if (name != null) {
			sql.append(" AND t.`name` LIKE ?");
			params.add("%" + name + "%");
		}

		Object type = map.get("type");
		if (type != null) {
			sql.append(" AND t.`type` = ?");
			params.add(type);
		}

		Object nType = map.get("nType");
		if (nType != null) {
			sql.append(" AND t.`type` <> ?");
			params.add(nType);
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("t.`id` DESC");

		log.info("sql: " + sql);
		log.info("params: " + params);

		return new MySQLPage<TeamGroup>(pageNumber, pageSize, jdbcTemplate, sql.toString(), new TeamGroupMapper(), params.toArray());

	}
}
