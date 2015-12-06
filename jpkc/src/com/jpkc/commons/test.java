package com.jpkc.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jpkc.dao.UserDao;
import com.jpkc.model.User;
import com.jpkc.util.SpringHelper;


public class test {
	@Resource
	private UserDao userDao;
	
	@Resource
	private  JdbcTemplate jdbcTemplate;
	
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
	
	public test() {
		userDao = (UserDao) SpringHelper.getBean("userDao");
		jdbcTemplate = (JdbcTemplate) SpringHelper.getBean("jdbcTemplate");
	}
	
	public void selectTest() {
		System.out.println(jdbcTemplate);
		String sql = "select id,username,password,delete_status,create_time from user ";
		Page<User> page = new PageMap<User>(jdbcTemplate, new UserMapper() , 1, 7, sql,null);
		System.out.println(JSONObject.fromObject(page));
	}
	public static void main(String[] args) {
		Page<User> pa = new PageMap<User>();
		test t = new test();
		t.selectTest();
	}
}
