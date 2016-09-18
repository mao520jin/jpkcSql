package com.jpkc.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * 持久层接口DAO
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 * @param <T>
 * 
 */
public interface Dao<T> {

	/**
	 * 
	 * 插入
	 * 
	 * @param o
	 * @return
	 * @throws SQLException
	 * 
	 */
	public int insert(T o) throws SQLException;

	/**
	 * 
	 * 删除
	 * 
	 * @param o
	 * @return
	 * @throws SQLException
	 * 
	 */
	public int delete(T o) throws SQLException;

	/**
	 * 
	 * 更新
	 * 
	 * @param o
	 * @return
	 * @throws SQLException
	 * 
	 */
	public int update(T o) throws SQLException;

	/**
	 * 
	 * 查询
	 * 
	 * @param o
	 * @return
	 * @throws SQLException
	 * 
	 */
	public List<T> select(T o) throws SQLException;

}
