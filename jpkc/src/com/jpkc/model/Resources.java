package com.jpkc.model;

import java.util.Date;

/**
 * 
 * resource 表对应的model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class Resources {
	private Integer id;
	private String title;
	private String path;
	private Integer type;
	private Integer deleteStatus;
	private Date createTime;
	private String createBy;

	public Resources(Integer id, String title, String path, Integer type, Integer deleteStatus, Date createTime, String createBy) {
		super();
		this.id = id;
		this.title = title;
		this.path = path;
		this.type = type;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
		this.createBy = createBy;
	}

	public Resources(Integer id) {
		super();
		this.id = id;
	}

	public Resources() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}
