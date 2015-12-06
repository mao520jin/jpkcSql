package com.jpkc.model;

import java.util.Date;

/**
 * 
 * user表对应model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer deleteStatus;
	private Date createTime;

	public User(Integer id, String username, String password, Integer deleteStatus, Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
