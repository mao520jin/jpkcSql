package com.jpkc.commons;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * MySQL + JdbcTemplate 分页
 * 
 * @author chenfan
 * @version 1.0, 2015/09/14
 * 
 * @param <T>
 * 
 */
public class MySQLPage<T> extends Page<T> {

	private JdbcTemplate jdbcTemplate;

	private String sql;

	private RowMapper<T> mapper;

	private Object[] params;

	public MySQLPage(int pageNumber, JdbcTemplate jdbcTemplate, String sql, RowMapper<T> mapper) {
		super(pageNumber, 0, jdbcTemplate, sql, mapper);
	}

	public MySQLPage(int pageNumber, JdbcTemplate jdbcTemplate, String sql, RowMapper<T> mapper, Object... params) {
		super(pageNumber, 0, jdbcTemplate, sql, mapper, params);
	}

	public MySQLPage(int pageNumber, int pageSize, JdbcTemplate jdbcTemplate, String sql, RowMapper<T> mapper) {
		super(pageNumber, pageSize, jdbcTemplate, sql, mapper);
	}

	public MySQLPage(int pageNumber, int pageSize, JdbcTemplate jdbcTemplate, String sql, RowMapper<T> mapper, Object... params) {
		super(pageNumber, pageSize, jdbcTemplate, sql, mapper, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Object... args) {

		try {
			jdbcTemplate = (JdbcTemplate) args[2];
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument: args[2]('jdbcTemplate')");
		}

		try {
			sql = (String) args[3];
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument: args[3]('sql')");
		}

		try {
			mapper = (RowMapper<T>) args[4];
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument: args[4]('mapper')");
		}

		try {
			params = (Object[]) args[5];
		} catch (Exception e) {
			params = null;
		}

	}

	@Override
	public int totalElements() {
		String newSql = "SELECT COUNT(1) FROM ( " + sql + " ) t";
		return jdbcTemplate.queryForObject(newSql, Integer.class, params);
	}

	@Override
	public List<T> content() {

		int pageNumber = getPageNumber();
		int pageSize = getPageSize();

		int offset = pageNumber == 1 ? 0 : (pageNumber - 1) * pageSize;
		int rowCount = pageSize;

		String newSql = "SELECT * FROM ( " + sql + " ) t LIMIT " + offset + ", " + rowCount;
		return jdbcTemplate.query(newSql, mapper, params);

	}
}
