package com.jpkc.model;

import java.util.Date;

/**
 * 
 * team 表对应model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class Team {
	private Integer id;
	private String memberName;
	private String content;
	private Integer type;
	private String email;
	private String tel;
	private Integer deleteStatus;
	private Date createTime;
	private String createBy;

	public Team(Integer id, String memberName, String content, Integer type, String email, String tel, Integer deleteStatus, Date createTime, String createBy) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.content = content;
		this.type = type;
		this.email = email;
		this.tel = tel;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
		this.createBy = createBy;
	}

	public Team(Integer id) {
		super();
		this.id = id;
	}

	public Team() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
