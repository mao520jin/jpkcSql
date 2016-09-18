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
import com.jpkc.model.TeamHonor;
import com.jpkc.util.DateUtil;

/**
 * 
 * team_honor
 * 
 * @author zhangyi
 * @version 1.0 2016年3月6日
 */
@Repository
public class TeamHonorDao implements Dao<TeamHonor> {
	private static Log log = LogFactory.getLog(TeamHonorDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * team_honor 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class TeamHonorMapper implements RowMapper<TeamHonor> {

		public TeamHonor mapRow(ResultSet rs, int rowNum) throws SQLException {
			TeamHonor teamHonor = new TeamHonor();
			teamHonor.setId(rs.getLong("id"));
			teamHonor.setTeamGroupId(rs.getLong("teamGroupId"));
			teamHonor.setAbout(rs.getString("about"));
			teamHonor.setType(rs.getInt("type"));
			teamHonor.setDesc(rs.getString("desc"));
			teamHonor.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			teamHonor.setCreatedBy(rs.getString("createdBy"));
			teamHonor.setLastModifiedBy(rs.getString("lastModifiedBy"));
			teamHonor.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));
			teamHonor.setName(rs.getString("name"));

			return teamHonor;
		}
	}

	@Override
	public int insert(TeamHonor o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `team_honor` (");
		sql.append(" ").append("`id`");
		sql.append(",").append("`team_group_id`");
		sql.append(",").append("`about`");
		sql.append(",").append("`type`");
		sql.append(",").append("`desc`");
		sql.append(",").append("`created_by`");
		sql.append(",").append("`created_date`");
		sql.append(",").append("`last_modified_by`");
		sql.append(",").append("`last_modified_date`");
		sql.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		List<Object> params = new ArrayList<Object>();
		params.add(o.getId());
		params.add(o.getTeamGroupId());
		params.add(o.getAbout());
		params.add(o.getType());
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
	public int delete(TeamHonor o) throws SQLException {
		return 0;
	}

	public int delete(Long id) throws SQLException {

		String sql = "DELETE FROM `team_honor` WHERE `id` = ?";

		List<Object> params = new ArrayList<Object>();
		params.add(id);

		log.info("sql: " + sql);
		log.info("params: " + params);

		return this.jdbcTemplate.update(sql, params.toArray());

	}

	@Override
	public int update(TeamHonor o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		sql.append("UPDATE `team_honor` SET `id` = :id");
		paramMap.put("id", o.getId());

		if (o.getTeamGroupId() != null) {
			sql.append(", `team_group_id` = :team_group_id");
			paramMap.put("team_group_id", o.getTeamGroupId());
		}

		if (o.getAbout() != null) {
			sql.append(", `about` = :about");
			paramMap.put("about", o.getAbout());
		}

		if (o.getType() != null) {
			sql.append(", `type` = :type");
			paramMap.put("type", o.getType());
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
	public List<TeamHonor> select(TeamHonor o) throws SQLException {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`team_group_id`").append(" AS ").append("teamGroupId");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(",").append("t1.`name`");
		sql.append(" FROM");
		sql.append(" ").append("`team_honor`").append(" AS ").append("t");
		sql.append(",").append("`team_group`").append(" AS ").append("t1");
		sql.append(" WHERE t.`team_group_id` = t1.`id`");

		List<Object> params = new ArrayList<Object>();

		sql.append(" ORDER BY t.`id` asc");

		log.info("sql: " + sql);
		log.info("params: " + params);
		return jdbcTemplate.query(sql.toString(), params.toArray(), new TeamHonorMapper());
	}

	/**
	 * 分页
	 * 
	 * @param map
	 * @return
	 */
	public Page<TeamHonor> search(Map<String, Object> map) {

		int pageNumber = Integer.parseInt("" + map.get("pageNumber"));
		int pageSize = Integer.parseInt("" + map.get("pageSize"));

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`team_group_id`").append(" AS ").append("teamGroupId");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(",").append("t1.`name`").append(" AS ").append("`name`");
		sql.append(" FROM");
		sql.append(" ").append("`team_honor`").append(" AS ").append("t");
		sql.append(",").append("`team_group`").append(" AS ").append("t1");
		sql.append(" WHERE t.`team_group_id` = t1.`id`");

		List<Object> params = new ArrayList<Object>();

		Object name = map.get("name");
		if (name != null) {
			sql.append(" AND t1.`name` LIKE ?");
			params.add("%" + name + "%");
		}

		Object type = map.get("type");
		if (type != null) {
			sql.append(" AND t.`type` = ?");
			params.add(type);
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("t.`id` DESC");

		log.info("sql: " + sql);
		log.info("params: " + params);

		return new MySQLPage<TeamHonor>(pageNumber, pageSize, jdbcTemplate, sql.toString(), new TeamHonorMapper(), params.toArray());

	}

	public TeamHonor select(Map<String, Object> map) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`team_group_id`").append(" AS ").append("teamGroupId");
		sql.append(",").append("t.`about`");
		sql.append(",").append("t.`type`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(",").append("t1.`name`");
		sql.append(" FROM");
		sql.append(" ").append("`team_honor`").append(" AS ").append("t");
		sql.append(",").append("`team_group`").append(" AS ").append("t1");
		sql.append(" WHERE t.`team_group_id` = t1.`id`");

		List<Object> params = new ArrayList<Object>();

		Object id = map.get("id");
		if (id != null) {
			sql.append(" AND t.`id` = ?");
			params.add(id);
		}

		return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), new TeamHonorMapper());
	}

}
