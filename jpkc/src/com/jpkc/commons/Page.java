package com.jpkc.commons;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 *  分页类 
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-10
 */
public abstract class Page<R> {
	private static Log log = LogFactory.getLog(Page.class);
	
	private int currentPage ; //当前页
	private int pageSize ;   //每页显示多少条
	private int totalCount;		//总记录数
	private int pageCount;		//页码数
	private boolean havaNextPage;	//是否有下一页
	private boolean havePrePage; 	//是否有上一页
	
	private List<R> content;
	
	public Page() {
	}

	
	public void setPage(int currentPage, int pageSize, int totalCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}


	public Page(JdbcTemplate jdbcTemplate, RowMapper<R> rowMapper, int pageSize2, int currentPage2, String sql, Object[] args) {
		String totalCountSql = "select count(*) from (" + sql + ") as totalCount";
		int totalCount2 = jdbcTemplate.queryForInt(totalCountSql, args);
		
		setPage(currentPage2,pageSize2,totalCount2);
		
		String sql1 = sql + " limit " + (currentPage - 1) * pageSize + "," +  pageSize;
		
		log.debug("sql1: "+ sql1);
		
		List<R> content2 = jdbcTemplate.query(sql1, args, rowMapper);
		content = content2;
		pageCount = getPageCount();
		isHavaNextPage();
		isHavePrePage();
	}

	public Page(JdbcTemplate jdbcTemplate, ColumnMapRowMapper columnMapRowMapper, int pageSize2, int currentPage2, String sql, Object[] args) {
		String totalCountSql = "select count(*) from (" + sql + ") as totalCount";
		int totalCount2 = jdbcTemplate.queryForInt(totalCountSql, args);
		
		setPage(currentPage2,pageSize2,totalCount2);
		
		String sql1 = sql + " limit " + (currentPage - 1) * pageSize + "," + currentPage  * pageSize;
		
		log.debug("sql1: "+ sql1);
		
		List<Map<String, Object>> content2 = jdbcTemplate.query(sql1, args, columnMapRowMapper);
		content = (List<R>) content2;
		pageCount = getPageCount();
		isHavaNextPage();
		isHavePrePage();
		
	}

	public int getCurrentPage() {
		currentPage = currentPage < getPageCount() ? currentPage :getPageCount();  
		currentPage = currentPage < 1 ? 1 : currentPage;  
		return currentPage; 
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		int pageCount = 0;
		if(pageSize != 0){
			pageCount = totalCount / pageSize;
			if (totalCount % pageSize != 0) {  
				pageCount++;  
			}
		}
		
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isHavaNextPage() {
		 havaNextPage = false;  
	      if ((getPageCount() > 1) && (getPageCount() > getCurrentPage())) {
	    	  havaNextPage = true;  
	      }
	      return havaNextPage;  
	}

	public void setHavaNextPage(boolean havaNextPage) {
		this.havaNextPage = havaNextPage;
	}

	public boolean isHavePrePage() {
		havePrePage = false;  
        if ((getPageCount() > 1) && (currentPage > 1)) {
        	havePrePage = true;  
        }
        return havePrePage;  
	}

	public void setHavePrePage(boolean havePrePage) {
		this.havePrePage = havePrePage;
	}

	public List<R> getContent() {
		return content;
	}

	public void setContent(List<R> content) {
		this.content = content;
	}
	
}
