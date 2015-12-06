package com.jpkc.commons;


import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class PageMap<R> extends Page<R>{
	
	public PageMap() {
		super();
	}
	
	/**
	 * 带页码和页面大小参数
	 * 
	 * @param jdbcTemplate
	 * @param rowMapper
	 * @param pageSize
	 * @param currentPage
	 * @param sql
	 * @param args
	 */
	public PageMap(JdbcTemplate jdbcTemplate,RowMapper<R> rowMapper ,int pageSize,int currentPage,String sql,Object[] args) {
		super( jdbcTemplate, rowMapper , pageSize, currentPage, sql, args);
	}
	
	/**
	 * R 是非映射类，适用多表查询使用
	 * 
	 * @param jdbcTemplate
	 * @param columnMapRowMapper
	 * @param pageSize
	 * @param currentPage
	 * @param sql
	 * @param args
	 */
	public PageMap(JdbcTemplate jdbcTemplate,ColumnMapRowMapper columnMapRowMapper ,int pageSize,int currentPage,String sql,Object[] args) {
		super( jdbcTemplate, columnMapRowMapper , pageSize, currentPage, sql, args);
	}
}
