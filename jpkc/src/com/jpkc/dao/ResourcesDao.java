package com.jpkc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.Resources;
import com.jpkc.util.VerifyUtil;

@Repository
public class ResourcesDao {
	private static Log log = LogFactory.getLog(ResourcesDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * resources 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class ResourcesMapper implements RowMapper<Resources> {

		public Resources mapRow(ResultSet rs, int rowNum) throws SQLException {

			Resources resources = new Resources();
			resources.setId(rs.getInt("id"));
			resources.setTitle(rs.getString("title"));
			resources.setPath(rs.getString("path"));
			resources.setType(rs.getInt("type"));
			resources.setDeleteStatus(rs.getInt("delete_status"));
			resources.setCreateTime(rs.getTimestamp("create_time"));
			resources.setCreateBy(rs.getString("create_by"));

			return resources;
		}

	}

	public int add(Resources resources) {
		String sql = "INSERT INTO `resources`(`title`,`path`,`type`,`create_time`,`create_by`) VALUES(?,?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(resources.getTitle());
		args.add(resources.getPath());
		args.add(resources.getType());
		args.add(resources.getCreateTime());
		args.add(resources.getCreateBy());

		log.debug("sql:  " + sql);
		log.debug("args: " + JSONArray.fromObject(args));

		int row = jdbcTemplate.update(sql, args.toArray());
		return row;
	}

	public Page<Resources> getResourcesByPage(Resources resources, Integer pageSize, Integer currentPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`path`");
		sql.append(",").append("`type`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`resources`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(resources.getTitle())) {
			sql.append(" AND");
			sql.append(" ").append("`title` like ?");
			args.add("%" + resources.getTitle() + "%");
		}
		
		if (!VerifyUtil.isEmpty(resources.getPath())) {
			sql.append(" AND");
			sql.append(" ").append("`path` = ?");
			args.add(resources.getPath());
		}
		
		if (!VerifyUtil.isEmpty(resources.getType())) {
			sql.append(" AND");
			sql.append(" ").append("`type` = ?");
			args.add(resources.getType());
		}
		
		if (!VerifyUtil.isEmpty(resources.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(resources.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return new MySQLPage<Resources>(currentPage,pageSize,jdbcTemplate, sql.toString(),new ResourcesMapper(),args.toArray());
	}

	public List<Resources> select(Resources resources) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`path`");
		sql.append(",").append("`type`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`resources`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(resources.getTitle())) {
			sql.append(" AND");
			sql.append(" ").append("`title` = ?");
			args.add(resources.getTitle());
		}

		if (!VerifyUtil.isEmpty(resources.getPath())) {
			sql.append(" AND");
			sql.append(" ").append("`path` = ?");
			args.add(resources.getPath());
		}
		
		if (!VerifyUtil.isEmpty(resources.getType())) {
			sql.append(" AND");
			sql.append(" ").append("`type` = ?");
			args.add(resources.getType());
		}
		
		if (!VerifyUtil.isEmpty(resources.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(resources.getDeleteStatus());
		}
		
		if (!VerifyUtil.isEmpty(resources.getId())) {
			sql.append(" AND");
			sql.append(" ").append("`id` = ?");
			args.add(resources.getId());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		 return jdbcTemplate.query(sql.toString(), args.toArray(), new  ResourcesMapper());
	}

	public int edit(Resources resources) {
		String sql = "update `resources` set title = :title,path = :path,type = :type,create_time = :create_time,create_by = :create_by where delete_status = 0 and id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", resources.getTitle());
		paramMap.put("type", resources.getType());
		paramMap.put("path", resources.getPath());
		paramMap.put("create_time", resources.getCreateTime());
		paramMap.put("create_by", resources.getCreateBy());
		paramMap.put("id", resources.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}

	public int delete(Resources resources) {
		String sql = "update `resources` set `delete_status` = 1 where  `id` = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", resources.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}
}
