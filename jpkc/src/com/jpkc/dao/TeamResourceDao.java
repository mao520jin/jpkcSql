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
import com.jpkc.model.TeamResource;
import com.jpkc.util.DateUtil;

@Repository
public class TeamResourceDao implements Dao<TeamResource> {
	private static Log log = LogFactory.getLog(TeamResourceDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * team_resource 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class TeamResourceMapper implements RowMapper<TeamResource> {

		public TeamResource mapRow(ResultSet rs, int rowNum) throws SQLException {

			TeamResource resources = new TeamResource();
			resources.setId(rs.getLong("id"));
			resources.setTitle(rs.getString("title"));
			resources.setPath(rs.getString("path"));
			resources.setName(rs.getString("name"));
			resources.setDenseName(rs.getString("denseName"));
			resources.setType(rs.getInt("type"));
			resources.setCount(rs.getInt("count"));
			resources.setIsconvert(rs.getInt("isconvert"));
			resources.setDesc(rs.getString("desc"));
			resources.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			resources.setCreatedBy(rs.getString("createdBy"));
			resources.setLastModifiedBy(rs.getString("lastModifiedBy"));
			resources.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));
			resources.setDenseName(rs.getString("denseName"));
			resources.setType(rs.getInt("type"));
			resources.setCount(rs.getInt("count"));
			resources.setIsconvert(rs.getInt("isconvert"));
			resources.setDesc(rs.getString("desc"));
			resources.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			resources.setCreatedBy(rs.getString("createdBy"));
			resources.setLastModifiedBy(rs.getString("lastModifiedBy"));
			resources.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));
			resources.setDenseName(rs.getString("denseName"));
			resources.setType(rs.getInt("type"));
			resources.setCount(rs.getInt("count"));
			resources.setIsconvert(rs.getInt("isconvert"));
			resources.setDesc(rs.getString("desc"));
			resources.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			resources.setCreatedBy(rs.getString("createdBy"));
			resources.setLastModifiedBy(rs.getString("lastModifiedBy"));
			resources.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));

			return resources;
		}

	}

	@Override
	public int insert(TeamResource o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `team_resource` (");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`path`");
		sql.append(",").append("`name`");
		sql.append(",").append("`dense_name`");
		sql.append(",").append("`type`");
		sql.append(",").append("`count`");
		sql.append(",").append("`isconvert`");
		sql.append(",").append("`desc`");
		sql.append(",").append("`created_by`");
		sql.append(",").append("`created_date`");
		sql.append(",").append("`last_modified_by`");
		sql.append(",").append("`last_modified_date`");
		sql.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		List<Object> params = new ArrayList<Object>();
		params.add(o.getId());
		params.add(o.getTitle());
		params.add(o.getPath());
		params.add(o.getName());
		params.add(o.getDenseName());
		params.add(o.getType());
		params.add(o.getCount());
		params.add(o.getIsconvert());
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
	public int delete(TeamResource o) throws SQLException {
		return 0;
	}

	@Override
	public int update(TeamResource o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		sql.append("UPDATE `team_resource` SET `id` = :id");
		paramMap.put("id", o.getId());

		if (o.getTitle() != null) {
			sql.append(", `title` = :title");
			paramMap.put("title", o.getTitle());
		}

		if (o.getPath() != null) {
			sql.append(", `path` = :path");
			paramMap.put("path", o.getPath());
		}

		if (o.getName() != null) {
			sql.append(", `name` = :name");
			paramMap.put("name", o.getName());
		}

		if (o.getDenseName() != null) {
			sql.append(", `dense_name` = :dense_name");
			paramMap.put("dense_name", o.getDenseName());
		}

		if (o.getType() != null) {
			sql.append(", `type` = :type");
			paramMap.put("type", o.getType());
		}

		if (o.getCount() != null) {
			sql.append(", `count` = :count");
			paramMap.put("count", o.getCount());
		}

		if (o.getIsconvert() != null) {
			sql.append(", `isconvert` = :isconvert");
			paramMap.put("isconvert", o.getIsconvert());
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
	public List<TeamResource> select(TeamResource o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`path`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`dense_name`").append(" AS ").append("denseName");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`count`");
		sql.append(",").append("t.`isconvert`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_resource`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		sql.append(" ORDER BY t.`id` asc");

		log.info("sql: " + sql);
		log.info("params: " + params);
		return jdbcTemplate.query(sql.toString(), params.toArray(), new TeamResourceMapper());
	}

	/**
	 * 分页
	 * 
	 * @param map
	 * @return
	 */
	public Page<TeamResource> search(Map<String, Object> map) {

		int pageNumber = Integer.parseInt("" + map.get("pageNumber"));
		int pageSize = Integer.parseInt("" + map.get("pageSize"));

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`path`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`dense_name`").append(" AS ").append("denseName");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`count`");
		sql.append(",").append("t.`isconvert`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_resource`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object title = map.get("title");
		if (title != null) {
			sql.append(" AND t.`title` LIKE ?");
			params.add("%" + title + "%");
		}

		Object type = map.get("type");
		if (type != null) {
			sql.append(" AND t.`type` = ?");
			params.add(type);
		}

		Object isconvert = map.get("isconvert");
		if (isconvert != null) {
			sql.append(" AND t.`isconvert` = ?");
			params.add(isconvert);
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("t.`id` DESC");

		log.info("sql: " + sql);
		log.info("params: " + params);

		return new MySQLPage<TeamResource>(pageNumber, pageSize, jdbcTemplate, sql.toString(), new TeamResourceMapper(), params.toArray());

	}

	public int delete(Long id) throws SQLException {

		String sql = "DELETE FROM `team_resource` WHERE `id` = ?";

		List<Object> params = new ArrayList<Object>();
		params.add(id);

		log.info("sql: " + sql);
		log.info("params: " + params);

		return this.jdbcTemplate.update(sql, params.toArray());

	}

	/**
	 * 
	 * 查询单个对象
	 * 
	 * @param map
	 * @return
	 */
	public TeamResource select(Map<String, Object> map) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`title`");
		sql.append(",").append("t.`path`");
		sql.append(",").append("t.`name`");
		sql.append(",").append("t.`dense_name`").append(" AS ").append("denseName");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`count`");
		sql.append(",").append("t.`isconvert`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`team_resource`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object id = map.get("id");
		if (id != null) {
			sql.append(" AND t.`id` = ?");
			params.add(id);
		}

		log.info("sql: " + sql);
		log.info("params: " + params);

		return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), new TeamResourceMapper());
	}

}
