package com.jpkc.model;

import java.util.Date;

/**
 * notice 表对应的model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class Notice {
	private Integer id;
	private String title;
	private String content;
	private Integer deleteStatus;
	private Date createTime;
	private String createBy;

	public Notice(Integer id, String title, String content, Integer deleteStatus, Date createTime, String createBy) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
		this.createBy = createBy;
	}

	public Notice() {
		super();
	}

	public Notice(Integer id) {
		super();
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
