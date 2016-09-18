package com.jpkc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.SysAdmin;
import com.jpkc.util.DateUtil;

/**
 * 
 * sys_admin
 * 
 * @author zhangyi
 * @version 1.0 2016年3月6日
 */
@Repository
public class SysAdminDao implements Dao<SysAdmin> {
	private static Log log = LogFactory.getLog(SysAdminDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * user 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class SysAdminMapper implements RowMapper<SysAdmin> {

		public SysAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {

			SysAdmin sysAdmin = new SysAdmin();
			sysAdmin.setId(rs.getLong("id"));
			sysAdmin.setUsername(rs.getString("username"));
			sysAdmin.setPassword(rs.getString("password"));
			sysAdmin.setStatus(rs.getInt("status"));
			sysAdmin.setDesc(rs.getString("desc"));
			sysAdmin.setCreatedDate(DateUtil.toDate(rs.getString("createdDate")));
			sysAdmin.setCreatedBy(rs.getString("createdBy"));
			sysAdmin.setLastModifiedBy(rs.getString("lastModifiedBy"));
			sysAdmin.setLastModifiedDate(DateUtil.toDate(rs.getString("lastModifiedDate")));
			return sysAdmin;

		}
	}

	@Override
	public int insert(SysAdmin o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `sys_admin` (");
		sql.append(" ").append("`id`");
		sql.append(",").append("`username`");
		sql.append(",").append("`password`");
		sql.append(",").append("`status`");
		sql.append(",").append("`desc`");
		sql.append(",").append("`created_by`");
		sql.append(",").append("`created_date`");
		sql.append(",").append("`last_modified_by`");
		sql.append(",").append("`last_modified_date`");
		sql.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		List<Object> params = new ArrayList<Object>();
		params.add(o.getId());
		params.add(o.getUsername());
		params.add(o.getPassword());
		params.add(o.getStatus());
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
	public int delete(SysAdmin o) throws SQLException {
		return 0;
	}

	public int delete(Long id) throws SQLException {

		String sql = "DELETE FROM `sys_admin` WHERE `id` = ?";

		List<Object> params = new ArrayList<Object>();
		params.add(id);

		log.info("sql: " + sql);
		log.info("params: " + params);

		return this.jdbcTemplate.update(sql, params.toArray());

	}

	@Override
	public int update(SysAdmin o) throws SQLException {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();

		sql.append("UPDATE `sys_admin` SET `id` = ?");
		params.add(o.getId());

		if (o.getUsername() != null) {
			sql.append(",").append("`username` = ?");
			params.add(o.getUsername());
		}

		if (o.getPassword() != null) {
			sql.append(",").append("`password` = ?");
			params.add(o.getPassword());
		}

		if (o.getStatus() != null) {
			sql.append(",").append("`status` = ?");
			params.add(o.getStatus());
		}

		if (o.getDesc() != null) {
			sql.append(",").append("`desc` = ?");
			params.add(o.getDesc());
		}

		if (o.getCreatedBy() != null) {
			sql.append(",").append("`created_by` = ?");
			params.add(o.getCreatedBy());
		}

		if (o.getCreatedDate() != null) {
			sql.append(",").append("`created_date` = ?");
			params.add(o.getCreatedDate());
		}

		if (o.getLastModifiedBy() != null) {
			sql.append(",").append("`last_modified_by` = ?");
			params.add(o.getLastModifiedBy());
		}

		if (o.getLastModifiedDate() != null) {
			sql.append(",").append("`last_modified_date` = ?");
			params.add(o.getLastModifiedDate());
		}

		sql.append(" WHERE `id` = ?");
		params.add(o.getId());

		log.info("sql: " + sql);
		log.info("params: " + params);

		return this.jdbcTemplate.update(sql.toString(), params.toArray());
	}

	@Override
	public List<SysAdmin> select(SysAdmin o) throws SQLException {
		return null;
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

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`username`");
		sql.append(",").append("t.`password`");
		sql.append(",").append("t.`status`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`sys_admin`").append(" AS ").append("t");
		sql.append(" WHERE");
		sql.append(" ").append("t.`status` = 1");
		sql.append(" ").append(" AND ").append("t.`username` = ?");
		sql.append(" ").append(" AND ").append("t.`password` = ?");

		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);

		log.info("sql: " + sql);
		log.info("params: " + params);

		return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), new SysAdminMapper());

	}

	/**
	 * 
	 * 分页查询
	 * 
	 * @param map
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * 
	 */
	public Page<SysAdmin> search(Map<String, Object> map) {

		int pageNumber = Integer.parseInt("" + map.get("pageNumber"));
		int pageSize = Integer.parseInt("" + map.get("pageSize"));

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("t.`id`");
		sql.append(",").append("t.`username`");
		sql.append(",").append("t.`password`");
		sql.append(",").append("t.`status`");
		sql.append(",").append("t.`desc`");
		sql.append(",").append("t.`created_by`").append(" AS ").append("createdBy");
		sql.append(",").append("t.`created_date`").append(" AS ").append("createdDate");
		sql.append(",").append("t.`last_modified_by`").append(" AS ").append("lastModifiedBy");
		sql.append(",").append("t.`last_modified_date`").append(" AS ").append("lastModifiedDate");
		sql.append(" FROM");
		sql.append(" ").append("`sys_admin`").append(" AS ").append("t");
		sql.append(" WHERE 1 = 1");

		List<Object> params = new ArrayList<Object>();

		Object username = map.get("username");
		if (username != null) {
			sql.append(" AND t.`username` LIKE ?");
			params.add("%" + username + "%");
		}

		Object status = map.get("status");
		if (status != null) {
			sql.append(" AND t.`status` = ?");
			params.add(status);
		}

		sql.append(" ORDER BY t.`id` ASC");

		log.info("sql: " + sql);
		log.info("params: " + params);

		return new MySQLPage<SysAdmin>(pageNumber, pageSize, jdbcTemplate, sql.toString(), new SysAdminMapper(), params.toArray());
	}

}
