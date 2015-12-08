package com.jpkc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.User;
import com.jpkc.util.VerifyUtil;

@Repository
public class UserDao {
	private static Log log = LogFactory.getLog(UserDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * user 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setDeleteStatus(rs.getInt("delete_status"));
			user.setCreateTime(rs.getTimestamp("create_time"));

			return user;

		}

	}

	public Page<User> getUserByPage(User user, int pageSize, int currentPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`username`");
		sql.append(",").append("`password`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(" FROM");
		sql.append(" ").append("`user`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(user.getUsername())) {
			sql.append(" AND");
			sql.append(" ").append("`username` = ?");
			args.add(user.getUsername());
		}

		if (!VerifyUtil.isEmpty(user.getPassword())) {
			sql.append(" AND");
			sql.append(" ").append("`password` = ?");
			args.add(user.getPassword());
		}

		if (!VerifyUtil.isEmpty(user.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(user.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return new MySQLPage<User>(currentPage,pageSize, jdbcTemplate, sql.toString(),new UserMapper(),args.toArray());
	}

	public int save(User user) {
		String sql = "INSERT INTO `user` (`username`,`password`, `delete_status`, `create_time`)VALUES (?,?,?,?)";

		List<Object> args = new ArrayList<Object>();
		args.add(user.getUsername());
		args.add(user.getPassword());
		args.add(user.getDeleteStatus());
		args.add(user.getCreateTime());

		log.debug("sql: " + sql);
		log.debug("args: " + args);

		return jdbcTemplate.update(sql, args.toArray());
	}

	public int delete(User user) {
		String sql = "Update `user` u set u.`delete_status` = 1 where u.`id` = ?";

		List<Object> args = new ArrayList<Object>();
		args.add(user.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + args);

		return this.jdbcTemplate.update(sql, args.toArray());
	}

	public List<User> select(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`username`");
		sql.append(",").append("`password`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(" FROM");
		sql.append(" ").append("`user`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(user.getUsername())) {
			sql.append(" AND");
			sql.append(" ").append("`username` = ?");
			args.add(user.getUsername());
		}

		if (!VerifyUtil.isEmpty(user.getPassword())) {
			sql.append(" AND");
			sql.append(" ").append("`password` = ?");
			args.add(user.getPassword());
		}

		if (!VerifyUtil.isEmpty(user.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(user.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return jdbcTemplate.query(sql.toString(), args.toArray(), new UserMapper());
	}
}
