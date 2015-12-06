package com.jpkc.model;

import java.util.Date;

/**
 * 
 * result 表对应model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class Result {
	private Integer id;
	private Integer teamId;
	private String content;
	private Integer type;
	private Integer deleteStatus;
	private Date createTime;
	private String createBy;

	public Result(Integer id, Integer teamId, String content, Integer type, Integer deleteStatus, Date createTime, String createBy) {
		super();
		this.id = id;
		this.teamId = teamId;
		this.content = content;
		this.type = type;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
		this.createBy = createBy;
	}

	public Result(Integer id) {
		super();
		this.id = id;
	}

	public Result() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
